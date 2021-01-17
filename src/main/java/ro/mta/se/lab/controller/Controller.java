package ro.mta.se.lab.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

import javafx.fxml.FXML;
import ro.mta.se.lab.model.*;

/**
 * Clasa controller din modelul MVC. Face legatura dintre
 * model si view.
 * @author VertUnix
 */
public class Controller  {

    @FXML
    private ComboBox<String> countryCombo;
    @FXML
    private ComboBox<String> cityCombo;
    @FXML
    private Button displayButton;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private AnchorPane rightAnchorPane;
    @FXML
    private Label cityNameLabel;
    @FXML
    private Label temp;
    @FXML
    private Label degreeCelsius;
    @FXML
    private Label feelsLike;
    @FXML
    private ImageView icon;
    @FXML
    private Label description;
    @FXML
    private Label minTemp;
    @FXML
    private Label maxTemp;
    @FXML
    private Label pressure;
    @FXML
    private Label humidity;
    @FXML
    private Label windSpeed;

    /**
     * places contine o lista cu toate tarile disponibile
     */
    Places places;
    int selectedCityID;
    Country selectedCountry;

    /**
     * Constructorul clasei
     * @param places tip Places, contine locurile incarcare
     *               din fisierul places.txt
     */
    public Controller(Places places) {
        this.places = places;
        //this.places.printPlaces();
    }

    /**
     * Functie initializata la inceput de View in care citesc
     * si creez lista de orase din CountryCombo si fac panel-ul
     * de informatii din dreapta nevizibil
     */
    @FXML
    public void initialize()
    {
        for (Country country : places.getCountryList()) {
            countryCombo.getItems().add(country.getCountryCode());
            //System.out.println(country.getCountryCode());
        }

        countryCombo.setOnAction(this::handleCountryCombo);
        cityCombo.setOnAction(this::handleCityCombo);

        cityCombo.setDisable(true);
        displayButton.setDisable(true);
        rightAnchorPane.setVisible(false);
    }

    /**
     * Handle ce trateaza selectarea unei tari.
     * Se vor afisa orasele specifice tarii in Combo-ul
     * urmator.
     * @param actionEvent
     */
    @FXML
    public void handleCountryCombo(ActionEvent actionEvent) {

        String userCountry = countryCombo.getValue();
        displayButton.setDisable(true);
        for (Country country : places.getCountryList()) {
            if(country.getCountryCode() == userCountry) {
                //System.out.println(selectedCountry);
                selectedCountry = country;
                cityCombo.getItems().clear();
                cityCombo.setDisable(false);
                for (City city : country.getCities()) {
                    cityCombo.getItems().add(city.getName());
                }
            }
        }
            //countryCombo.getItems().add(country.getCountryCode());
    }


    /**
     * Combo ce trateaza alegerea unui oras. Va
     * salva ID-ul orasului selectat intr-o variabila.
     * @param actionEvent
     */
    @FXML
    public void handleCityCombo(ActionEvent actionEvent) {
        displayButton.setDisable(false);
        selectedCityID = selectedCountry.getCityIDByName(cityCombo.getValue());

        //System.out.println(selectedCityID);

    }

    /**
     * Functia responsabila de comnuicarea cu modelul
     * si actualizarea view-ului.
     * Va cere interogarea API-ului meteo si va primi
     * raspunsul sub forma unui obiect WeatherInfo.
     * @throws IOException
     */
    @FXML
    private void displayWeather() throws IOException {

        //daca nu s-a gasit orasul in lista tarii selectate anterior, return
        if(selectedCityID == -1)
            return;


        WeatherInfo weather;
        WeatherAPI api = new WeatherAPI();
        weather = api.getWeatherInfo(String.valueOf(selectedCityID));

        rightAnchorPane.setVisible(true);

        temp.setAlignment(Pos.CENTER_RIGHT);
        temp.setText(weather.getTemperature());
        cityNameLabel.setAlignment(Pos.CENTER);
        cityNameLabel.setText(weather.getCityName());
        icon.setImage(weather.getImage());
        description.setText(weather.getDescription());
        description.setAlignment(Pos.CENTER);
        feelsLike.setText(weather.getFeelsLike());
        description.setAlignment(Pos.CENTER_RIGHT);
        description.setText(weather.getDescription());
        minTemp.setAlignment(Pos.CENTER_RIGHT);
        minTemp.setText(weather.getTempMin());
        maxTemp.setAlignment(Pos.CENTER_RIGHT);
        maxTemp.setText(weather.getTempMax());
        pressure.setAlignment(Pos.CENTER_RIGHT);
        pressure.setText(weather.getPressure());
        humidity.setAlignment(Pos.CENTER_RIGHT);
        humidity.setText(weather.getHumidity());
        windSpeed.setAlignment(Pos.CENTER_RIGHT);
        windSpeed.setText(weather.getWindSpeed());

    }


}
