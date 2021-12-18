package com.example.kursowa.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.kursowa.database.DataBaseHandler;
import com.example.kursowa.fillingthevan.Coffee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddANewTypeOfCoffeeController {

    private static final Logger LOG = Logger.getLogger(AddANewTypeOfCoffeeController.class.getSimpleName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField coffeeAmount;

    @FXML
    private TextField coffeeName;

    @FXML
    private TextField coffeePack;

    @FXML
    private TextField coffeeSort;

    @FXML
    private TextField coffeeType;

    @FXML
    private TextField coffeeVolume;

    @FXML
    private TextField coffeeWeight;

    @FXML
    private Button exit;

    @FXML
    private Button saveCoffeeData;

    @FXML
    void initialize() {

        saveCoffeeData.setOnAction(actionEvent -> {
            addNewCoffeeType();
            saveCoffeeData.getScene().getWindow().hide();
            LOG.info("User add and save coffee data");
        });

        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
            LOG.info("User go back");
        });

    }

    private void addNewCoffeeType() {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        if (coffeeName.getText().equals("") || coffeeSort.getText().equals("") || coffeeType.getText().equals("")
                || coffeeAmount.getText().equals("") || coffeeWeight.getText().equals("") || coffeeVolume.getText().equals("")) {
            warnIncorrectInput("You did not enter any data");
            coffeeName.setText("");
            coffeeSort.setText("");
            coffeeType.setText("");
            coffeeAmount.setText("");
            coffeeWeight.setText("");
            coffeeVolume.setText("");
        }
        String name = coffeeName.getText();
        String sort = coffeeSort.getText();
        String type = coffeeType.getText();
        Double price = new Double(coffeeAmount.getText());
        Double netWeight = new Double(coffeeWeight.getText());
        Double netVolume = new Double(coffeeVolume.getText());
        String pack = coffeePack.getText();

        Coffee coffee = new Coffee(name, sort, type, price, netWeight, netVolume, pack);

        dataBaseHandler.addNewCoffeeType(coffee);
    }

    private void warnIncorrectInput(String message) {
        Stage stage = (Stage) saveCoffeeData.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.WARNING, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setHeaderText("ERROR");

        alert.showAndWait();
    }
}