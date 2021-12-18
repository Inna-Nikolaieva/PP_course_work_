package com.example.kursowa.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.kursowa.database.Const;
import com.example.kursowa.database.DataBaseHandler;
import com.example.kursowa.fillingthevan.Coffee;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FindCoffeeByQualityParametersController {

    private static final Logger LOG = Logger.getLogger(FindCoffeeByQualityParametersController.class.getSimpleName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Coffee, Double> coffeeAmount;

    @FXML
    private TableColumn<Coffee, String> coffeeName;

    @FXML
    private TableColumn<Coffee, String> coffeePack;

    @FXML
    private TableColumn<Coffee, String> coffeeSort;

    @FXML
    private TableColumn<Coffee, String> coffeeType;

    @FXML
    private TableColumn<Coffee, Double> coffeeVolume;

    @FXML
    private TableColumn<Coffee, Double> coffeeWeight;

    @FXML
    private Button exit;

    @FXML
    private Button findCoffeeByRangeOfParameters;

    @FXML
    private TableView<Coffee> coffeeTable;

    @FXML
    private TextField priceFrom;

    @FXML
    private TextField priceTo;

    @FXML
    private TextField volumeFrom;

    @FXML
    private TextField volumeTo;

    @FXML
    private TextField weightFrom;

    @FXML
    private TextField weightTo;

    @FXML
    void initialize() {
        findCoffeeByRangeOfParameters.setOnAction(actionEvent -> {

            findCoffeeInTheVan();
            LOG.info("User find coffee by range of parameters");
        });

        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
            LOG.info("User go back");
        });
    }

    public void findCoffeeInTheVan() {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        if (weightFrom.getText().equals("") && weightTo.getText().equals("")
                && volumeFrom.getText().equals("") && volumeTo.getText().equals("")) {

            double leftBound = Double.parseDouble(priceFrom.getText());
            double rightBound = Double.parseDouble(priceTo.getText());

            if (leftBound >= rightBound || (priceFrom.getText().equals("") || priceTo.getText().equals(""))) {
                warnIncorrectInput("Incorrect input data");
                priceFrom.setText("");
                priceTo.setText("");
                return;
            }
            dataBaseHandler.findCoffeeByRangeOfParameters(leftBound, rightBound, Const.COFFEE_AMOUNT);
        } else if (priceFrom.getText().equals("") && priceTo.getText().equals("")
                && volumeFrom.getText().equals("") && volumeTo.getText().equals("")) {

            double leftBound = Double.parseDouble(weightFrom.getText());
            double rightBound = Double.parseDouble(weightTo.getText());

            if (leftBound >= rightBound || (weightFrom.getText().equals("") || weightTo.getText().equals(""))) {
                warnIncorrectInput("Incorrect input data");
                weightFrom.setText("");
                weightTo.setText("");
                return;
            }

            dataBaseHandler.findCoffeeByRangeOfParameters(leftBound, rightBound, Const.COFFEE_WEIGHT);
        } else if (priceFrom.getText().equals("") && priceTo.getText().equals("")
                && weightFrom.getText().equals("") && weightTo.getText().equals("")) {

            double leftBound = Double.parseDouble(volumeFrom.getText());
            double rightBound = Double.parseDouble(volumeTo.getText());

            if (leftBound >= rightBound || (volumeFrom.getText().equals("") || volumeTo.getText().equals(""))) {
                warnIncorrectInput("Incorrect input data");
                volumeFrom.setText("");
                volumeTo.setText("");
                return;
            }
            dataBaseHandler.findCoffeeByRangeOfParameters(leftBound, rightBound, Const.COFFEE_VOLUME);
        }


        coffeeName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        coffeeSort.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeeSort()));
        coffeeType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeeType()));
        coffeeAmount.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getAmount()).asObject());
        coffeeWeight.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGrossWeight()).asObject());
        coffeeVolume.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getGrossVolume()).asObject());
        coffeePack.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoffeePack()));

        coffeeTable.setEditable(true);
        ObservableList<Coffee> tableData = FXCollections.observableArrayList(dataBaseHandler.getProductBoxes());
        System.out.println(tableData);
        coffeeTable.setItems(tableData);

        coffeeTable = new TableView<Coffee>(tableData);
    }

    private void warnIncorrectInput(String message) {
        Stage stage = (Stage) findCoffeeByRangeOfParameters.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.WARNING, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setHeaderText("ERROR");

        alert.showAndWait();
    }
}
