package ro.mta.se.lab.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clasa ce memoreaza o lista cu toate tarile si orasele
 * asociate, impreuna cu alte informatii despre acestea.
 *
 * @author: VertUnix
 */

public class Places {

    private ArrayList<Country> countryList;
    private String inputFileName;
    /**
     * Constructorul clasei
     */
    public Places(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    /**
     * Functia initializeaza modelul cu datele citite
     * din fisierul places.txt. Exista un rand de antet ce
     * identifica fiecare coloana. Fiecare din liniile
     * urmatoare contine date despre un oras. Datele sunt
     * separate prin tab-uri (unul sau mai multe).
     */
    public void modelInit() {
        try {
            File fisier = new File("src/main/java/ro/mta/se/lab/resources/places.txt");
            Scanner scan = new Scanner(fisier);
            String data = scan.nextLine();
            while (scan.hasNextLine()) {
                data = scan.nextLine();
                String[] cityAttr = data.split("\t+");
                //System.out.println(cityAttr[4]);
                City orasNou = new City(Integer.parseInt(cityAttr[0]), cityAttr[1],
                        Double.parseDouble(cityAttr[2]),  Double.parseDouble(cityAttr[3]), cityAttr[4]);
                addCity(orasNou);
                //orasNou.printCity();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Functia verifica daca o tara exista;
     * daca da, adauga noul oras in lista sa de orase.
     * Daca tara nu exista inca, o si adaug
     * in lista de tari.
     * @param cityToAdd orasul pe care dorim sa-l adaugam in lista unei tari
     */
    private void addCity(City cityToAdd) {
        //daca tara exista, adaug noul oras in lista sa de orase
        if(countryList != null) {
            for (Country country : countryList) {
                if (country.countryCode.equals(cityToAdd.getCountryCode())) {
                    country.addCity(cityToAdd);
                    return;
                }
            }
        }

        //daca lista este goala sau tara nu exista inca, adaug in lista de tari
        if(countryList == null)
            countryList = new ArrayList<Country>();
        Country countryToAdd = new Country(cityToAdd.getCountryCode());
        countryToAdd.addCity(cityToAdd);
        countryList.add(countryToAdd);

    }

    public void printPlaces() {
        for(Country country : countryList){
            country.printCityList();
        }
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }
}
