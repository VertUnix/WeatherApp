package ro.mta.se.lab.model;

import java.util.ArrayList;

/**
 * Clasa ce memoreaza o lista de orase, specifica fiecarei tari.
 *
 * @author VertUnix
 */
public class Country {

    String countryCode;
    ArrayList<City> cities;

    /**
     * Constructorul clasei Country
     * @param countryCode codul tarii
     */
    public Country(String countryCode) {
        this.countryCode = countryCode;
        cities = new ArrayList<City>();
    }

    /**
     * Functia adauga un oras in lista de orase
     * @param cityToAdd oras de adaugat in lista
     */
    public void addCity(City cityToAdd) {
            cities.add(cityToAdd);
    }

    public void printCityList() {
        System.out.println(countryCode + ": ");
        for(City city : cities)
            System.out.println(city.getName());
    }

    public String getCountryCode() {
        return countryCode;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
}
