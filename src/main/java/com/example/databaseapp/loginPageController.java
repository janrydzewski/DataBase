package com.example.databaseapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginPageController {
    @FXML
    private Button button1;
    @FXML
    private TextField textField1;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private Label incorretLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSMainPage(ActionEvent event) throws IOException{
        if(passwordField1.getText().equals("admin") && textField1.getText().equals("admin")){
            root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            incorretLabel.setText("Incorret login or password, try again");
        }

    }

}