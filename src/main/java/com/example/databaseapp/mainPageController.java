package com.example.databaseapp;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class mainPageController extends addClientController implements Initializable {

    @FXML
    private TableView<Client> tableView;
    @FXML
    private TableColumn<Client, SimpleStringProperty> firstNameColumn;
    @FXML
    private TableColumn<Client, SimpleStringProperty> lastNameColumn;
    @FXML
    private TableColumn<Client, SimpleStringProperty> addressColumn;
    @FXML
    private TableColumn<Client, SimpleStringProperty> productColumn;
    @FXML
    private TableColumn<Client, SimpleStringProperty> quantityColumn;

    @FXML
    private Button addButton, openWarehouse;
    @FXML
    private GridPane addClientPane;

    ObservableList<Client> clients;

    private Scene scene, scene2;
    private Stage stage, stage2;
    private Parent root, root2;
    private Client client;
    private Node addClientNode;
    private Node warehouseNode;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Client, SimpleStringProperty>("FirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Client, SimpleStringProperty>("LastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Client, SimpleStringProperty>("Address"));
        productColumn.setCellValueFactory(new PropertyValueFactory<Client, SimpleStringProperty>("Product"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Client, SimpleStringProperty>("Quantity"));

        tableView.setItems(getClient());
    }

    public ObservableList<Client> getClient() {
        clients = FXCollections.observableArrayList();
        clients.add(new Client("Shiloh", "Nelson", "London", "OrbitalKeys", "5"));
        clients.add(new Client("Tommie", "Goulding", "Cuahland", "InstaPress", "2"));
        clients.add(new Client("Arwa", "Glenn", "Hiding", "UnoWear", "9"));
        clients.add(new Client("Evelina", "Sellers", "Sluubury", "SwishWallet", "15"));
        clients.add(new Client("Macsen", "Howard", "Slealedo", "HandyMop", "19"));
        return clients;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public void removeClient() {
        clients.remove(tableView.getSelectionModel().getSelectedItem());
    }
    public void addClient() throws IOException {
            add();
    }
    public void openWarehouse(ActionEvent event) throws IOException {

        root2 = FXMLLoader.load(getClass().getResource("warehousePage.fxml"));
        stage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene2 = new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();

    }









}
