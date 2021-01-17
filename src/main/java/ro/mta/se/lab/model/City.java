package ro.mta.se.lab.model;

/**
 * Clasa ce memoreaza datele despre orase
 *
 * @author: VertUnix
 */
public class City {

    private String name;
    private int ID;
    private double lat;
    private double lon;
    private String countryCode;

    /**
     * Constructorul clasei
     */
    public City(int ID, String name, double lat, double lon, String countryCode) {
        this.name = name;
        this.ID = ID;
        this.lat = lat;
        this.lon = lon;
        this.countryCode = countryCode;
    }

    public void printCity()
    {
        System.out.println(this.ID + " " + name + " " + countryCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
