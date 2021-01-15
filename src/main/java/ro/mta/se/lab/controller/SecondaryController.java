package ro.mta.se.lab.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import ro.mta.se.lab.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}