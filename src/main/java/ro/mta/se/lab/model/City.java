package ro.mta.se.lab.model;

/**
 * Clasa ce memoreaza datele despre orase
 *
 * @author: VertUnix
 */
public class City {

    String name;
    int ID;
    float lat;
    float lon;
    String countryCode;

    /**
     * Constructorul clasei
     */
    public City(String name, int ID, float lat, float lon, String countryCode) {
        this.name = name;
        this.ID = ID;
        this.lat = lat;
        this.lon = lon;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
