import org.junit.Before;
import org.junit.Test;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.Country;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Clasa ce contine metode de testare
 * a clasei Country.
 *
 * @author VertUnix
 */
public class CountryTest {

    private static Country country;
    ArrayList<City> correctList;

    /**
     * Functia ce se apeleaza inaintea testelor
     * si seteaza variabilele/ conditiile intiale.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        country = new Country("RU");
        City city1 = new City(1111, "Moscow", 10.01, 88.12, "RU");
        City city2 = new City(2222, "St. Petersburg", 20.02, 23.34, "RU");
        correctList = new ArrayList<City>();
        correctList.add(city1);
        correctList.add(city2);

        country.addCity(city1);
        country.addCity(city2);
    }

    /**
     * Functie ce testeaza functionalitatea functiei addCity().
     */
    @Test
    public void addCity(){

        boolean areEqual = correctList.equals(country.getCities());
        assertEquals(true, areEqual);

    }

    /**
     * Functie ce testeaza functionalitatea functiei getCityByID().
     */
    @Test
    public void getCityIDByName() {
        System.out.println(country.getCities().get(1).getName());
        assertEquals(2222, country.getCityIDByName("St. Petersburg"));
    }

    //NOTA: adauga la optiunile de compilare/ rulare pe JVM optiunea:
    // --add-exports ro.mta.se.lab/ro.mta.se.lab.model=ALL-UNNAMED
    // sau pe caz general --add-exports module/package==ALL-UNNAMED
    //cf. https://stackoverflow.com/questions/42538750/unable-to-export-a-package-from-java-base-module/42541096#42541096
}