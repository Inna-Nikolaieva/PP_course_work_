package com.example.kursowa.controllers;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.kursowa.database.DataBaseHandler;
import com.example.kursowa.fillingthevan.Coffee;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PrintListOfCoffeeController {

    private static final Logger LOG = Logger.getLogger(PrintListOfCoffeeController.class.getSimpleName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Coffee> coffeeTable;

    @FXML
    private Button exit;

    @FXML
    private Button OK;

    @FXML
    private AnchorPane listOfCoffee;

    @FXML
    private TableColumn<Coffee, Double> tableAmount;

    @FXML
    private TableColumn<Coffee, String> tableName;

    @FXML
    private TableColumn<Coffee, String> tablePack;

    @FXML
    private TableColumn<Coffee, String> tableSort;

    @FXML
    private TableColumn<Coffee, String> tableType;

    @FXML
    private TableColumn<Coffee, Double> tableVolume;

    @FXML
    private TableColumn<Coffee, Double> tableWeight;

    @FXML
    void initialize() {
        OK.setOnAction(actionEvent -> {
            getListOfCoffee();
            //OK.getScene().getWindow().hide();
            LOG.info("User view list of coffee");
        });

        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
            LOG.info("User go back");
        });
    }

    private void getListOfCoffee() {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        tableName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        tableSort.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeeSort()));
        tableType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeeType()));
        tableAmount.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getAmount()).asObject());
        tableWeight.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGrossWeight()).asObject());
        tableVolume.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGrossVolume()).asObject());
        tablePack.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeePack()));

        coffeeTable.setEditable(true);
        ObservableList<Coffee> tableData = FXCollections.observableArrayList(dataBaseHandler.getDataListOfCoffee());
        coffeeTable.setItems(tableData);

        coffeeTable = new TableView<Coffee>(tableData);

    }

}

