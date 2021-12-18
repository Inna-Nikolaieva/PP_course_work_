package com.example.kursowa.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.kursowa.database.Const;
import com.example.kursowa.database.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeDataOfCoffeeController {

    private static final Logger LOG = Logger.getLogger(ChangeDataOfCoffeeController.class.getSimpleName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField coffeeName;

    @FXML
    private Button exit;

    @FXML
    private TextField newData;

    @FXML
    private Button saveNewAmount;

    @FXML
    private Button saveNewName;

    @FXML
    private Button saveNewPack;

    @FXML
    private Button saveNewSort;

    @FXML
    private Button saveNewType;

    @FXML
    private Button saveNewVolume;

    @FXML
    private Button saveNewWeight;

    @FXML
    void initialize() {

        saveNewName.setOnAction(actionEvent -> {
            changeDataOfCoffee(Const.COFFEE_NAME);
            LOG.info("User save new name data");
        });

        saveNewSort.setOnAction(actionEvent -> {
            changeDataOfCoffee(Const.COFFEE_SORT);
            LOG.info("User save new sort data");
        });

        saveNewType.setOnAction(actionEvent -> {
            changeDataOfCoffee(Const.COFFEE_TYPE);
            LOG.info("User save new type data");
        });

        saveNewAmount.setOnAction(actionEvent -> {
            changeDataOfCoffee(Const.COFFEE_AMOUNT);
            LOG.info("User save new amount data");
        });

        saveNewWeight.setOnAction(actionEvent -> {
            changeDataOfCoffee(Const.COFFEE_WEIGHT);
            LOG.info("User save new weight data");
        });

        saveNewVolume.setOnAction(actionEvent -> {
            changeDataOfCoffee(Const.COFFEE_VOLUME);
            LOG.info("User save new volume data");
        });

        saveNewPack.setOnAction(actionEvent -> {
            changeDataOfCoffee(Const.COFFEE_PACK);
            LOG.info("User save new pack data");
        });

        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
            LOG.info("User go back");
        });
    }

    public void changeDataOfCoffee(String nameOfParameter) {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        if (coffeeName.getText().equals("") || newData.getText().equals("")) {
            warnIncorrectInput("You did not enter any data");
            coffeeName.setText("");
            newData.setText("");
        }

        dataBaseHandler.changeParametersOfCoffee(coffeeName.getText(), nameOfParameter, newData.getText());
        coffeeName.setText("");
        newData.setText("");
    }

    private void warnIncorrectInput(String message) {
        Stage stage = (Stage) saveNewName.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.WARNING, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setHeaderText("ERROR");

        alert.showAndWait();
    }

}
