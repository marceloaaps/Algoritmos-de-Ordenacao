module com.example.trabalhoed2 {
    requires javafx.controls;
    requires javafx.fxml;




    exports com.program;
    opens com.program to javafx.fxml;
    exports com.entities.lowQtt;
    opens com.entities.lowQtt to javafx.fxml;
    exports com.entities.mediumHighQtt;
    opens com.entities.mediumHighQtt to javafx.fxml;
    exports com.properties;
    opens com.properties to javafx.fxml;

}