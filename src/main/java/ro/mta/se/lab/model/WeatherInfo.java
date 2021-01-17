package ro.mta.se.lab.model;

import javafx.scene.image.Image;

/**
 * Clasa contine informatiile meteo despre un oras.
 *
 * @author VertUnix
 */
public class WeatherInfo {

    protected String cityName;
    protected String temperature;
    protected String feelsLike;
    protected String tempMin;
    protected String tempMax;
    protected String pressure;
    protected String humidity;
    protected String windSpeed;
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

    public String getTemperature() {
        return temperature;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getTempMin() {
        return tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getDescription() {
        return description;
    }

    public String getIconCode() {
        return iconCode;
    }


}
