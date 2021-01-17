module ro.mta.se.lab {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires junit;
    opens ro.mta.se.lab.controller;
    opens ro.mta.se.lab to javafx.fxml;
    exports ro.mta.se.lab;
}