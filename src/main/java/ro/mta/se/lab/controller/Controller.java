package ro.mta.se.lab.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import ro.mta.se.lab.model.Country;
import ro.mta.se.lab.model.Places;

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
    private Label temp;
    @FXML
    private AnchorPane leftPane;

    Places places;

    @FXML
    private void displayWeather() throws IOException {
        if(places == null)
            System.out.println("DAAA");

        //Main.setRoot("secondary");
        temp.setText("daaa");
    }

    @FXML
    public void initialize()
    {


        for (Country country : places.getCountryList()) {
            countryCombo.getItems().add(country.getCountryCode());
            System.out.println(country.getCountryCode());
        }
    }

    public Controller(Places places) {
        this.places = places;
        this.places.printPlaces();
    }

    /**
     * Functia seteaza elementele de stil ale unor
     * componente din view.
     */
    private void setViewStyle() {
        leftPane.setStyle("-fx-background-color: #808080;");
    }
}
