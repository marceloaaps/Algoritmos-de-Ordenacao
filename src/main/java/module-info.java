module com.example.trabalhoed2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.entities to javafx.fxml;
    exports com.entities;
    exports com.program;
    opens com.program to javafx.fxml;
    exports com.test;
    opens com.test to javafx.fxml;
    exports com.ui;
    opens com.ui to javafx.fxml;
}