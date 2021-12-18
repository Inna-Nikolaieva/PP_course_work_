package com.example.kursowa.controllers;

import java.net.URL;
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

public class SortCoffeeInTheVanController {

    private static final Logger LOG = Logger.getLogger(SortCoffeeInTheVanController.class.getSimpleName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button OK;

    @FXML
    private TableColumn<Coffee, Double> coffeeAmount;

    @FXML
    private TableColumn<Coffee, String> coffeeName;

    @FXML
    private TableColumn<Coffee, String> coffeePack;

    @FXML
    private TableColumn<Coffee, String> coffeeSort;

    @FXML
    private TableView<Coffee> coffeeTable;

    @FXML
    private TableColumn<Coffee, String> coffeeType;

    @FXML
    private TableColumn<Coffee, Double> coffeeVolume;

    @FXML
    private TableColumn<Coffee, Double> coffeeWeight;

    @FXML
    private Button exit;

    @FXML
    void initialize() {
        OK.setOnAction(actionEvent -> {
            sortCoffeeInTheVan();
            OK.getScene().getWindow().hide();
            LOG.info("User view sorted by amount/weight list of coffee");
        });

        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
            LOG.info("User go back");
        });
    }

    public void sortCoffeeInTheVan(){

        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        dataBaseHandler.sortByPriceByWeight();

        coffeeName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        coffeeSort.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeeSort()));
        coffeeType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeeType()));
        coffeeAmount.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getAmount()).asObject());
        coffeeWeight.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGrossWeight()).asObject());
        coffeeVolume.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGrossVolume()).asObject());
        coffeePack.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeePack()));

        coffeeTable.setEditable(true);
        ObservableList<Coffee> tableData = FXCollections.observableArrayList(dataBaseHandler.getProductBoxes());
        coffeeTable.setItems(tableData);

        coffeeTable = new TableView<Coffee>(tableData);
    }
}

