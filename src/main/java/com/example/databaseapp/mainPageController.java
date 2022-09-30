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

public class mainPageController extends loginPageController implements Initializable {

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
        for(int i=0; i<listOfClients.size();i++){
            clients.add(listOfClients.get(i));
        }

        return clients;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public void removeClient(ActionEvent event) throws IOException {

        listOfClients.remove(tableView.getSelectionModel().getSelectedItem());
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void editClient(){
    }
    public void addClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addClient.fxml"));
        DialogPane addClientPane = fxmlLoader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(addClientPane);
        Optional<ButtonType> clickedButton = dialog.showAndWait();
        if(clickedButton.get() == (ButtonType.OK)){
            System.out.println("123");
        }

    }
    public void openWarehouse(ActionEvent event) throws IOException {

        root2 = FXMLLoader.load(getClass().getResource("warehousePage.fxml"));
        stage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene2 = new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();

    }









}
