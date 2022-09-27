module com.example.databaseapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.databaseapp to javafx.fxml;
    exports com.example.databaseapp;
}