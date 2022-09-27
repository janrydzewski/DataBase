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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class warehouseController extends loginPageController implements Initializable {
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, SimpleStringProperty> idColumn;
    @FXML
    private TableColumn<Product, SimpleStringProperty> productColumn;
    @FXML
    private TableColumn<Product, SimpleStringProperty> priceColumn;

    ObservableList<Product> products;
    private Product product;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, SimpleStringProperty>("Id"));
        productColumn.setCellValueFactory(new PropertyValueFactory<Product, SimpleStringProperty>("Product"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, SimpleStringProperty>("Price"));

        tableView.setItems(getProduct());
    }
    public ObservableList<Product> getProduct() {
        products = FXCollections.observableArrayList();
        products.add(new Product("1", "OrbitalKeys", "20"));
        return products;
    }
    public void setProduct(Product product){
        this.product = product;
    }

    public void changeToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
