package ro.mta.se.lab.model;

import javafx.scene.image.Image;

/**
 * Clasa contine informatiile meteo despre un oras.
 *
 * @author VertUnix
 */
public class WeatherInfo {

    protected String cityName;
    protected int temperature;
    protected int feelsLike;
    protected int tempMin;
    protected int tempMax;
    protected int pressure;
    protected int humidity;
    protected int windSpeed;
    protected String description;
    protected String iconCode;
    protected Image image;


    public WeatherInfo() {
    }

    public Image getImage() {
        return image;
    }

    public String getCityName() {
        return cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public int getTempMin() {
        return tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public String getDescription() {
        return description;
    }

    public String getIconCode() {
        return iconCode;
    }


}
