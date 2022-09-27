package com.example.databaseapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Optional;

public class addClientController {
    String string;
    @FXML
    private TextField firstTextField;

    private Node addClientNode;

    public void add() throws IOException {
        Dialog addNewClient = new Dialog();
        addClientNode = (Node) FXMLLoader.load(getClass().getResource("addClient.fxml"));
        addNewClient.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        addNewClient.getDialogPane().getButtonTypes().add(ButtonType.APPLY);
        addNewClient.getDialogPane().setContent(addClientNode);
        Optional<ButtonType> clickedButton = addNewClient.showAndWait();

        if (clickedButton.get() == ButtonType.APPLY) {
            System.out.println("APPLY");

        } else {
            System.out.println("CLOSE");
        }
    }

}
