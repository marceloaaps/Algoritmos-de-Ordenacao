module com.example.trabalhoed2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabalhoed2 to javafx.fxml;
    exports com.example.trabalhoed2;
}