package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.Controller;
import ro.mta.se.lab.model.Places;
import ro.mta.se.lab.model.WeatherAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;
    public static Places places;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            scene = new Scene(loadFXML("primary"));
            stage.setScene(scene);
            stage.setTitle("WeatherApp");
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("/view/" + fxml +".fxml"));
        fxmlLoader.setController(new Controller(places));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        try {

            places = new Places("src/main/java/ro/mta/se/lab/resources/places.txt");
            places.modelInit();


            launch();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}