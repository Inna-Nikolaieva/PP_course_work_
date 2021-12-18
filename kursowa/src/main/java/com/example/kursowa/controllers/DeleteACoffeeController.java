package com.example.kursowa.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.kursowa.database.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class DeleteACoffeeController {

    private static final Logger LOG = Logger.getLogger(DeleteACoffeeController.class.getSimpleName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField coffeeName;

    @FXML
    private Button deleteATypeOfCoffee;

    @FXML
    private Button exit;

    @FXML
    void initialize() {

        deleteATypeOfCoffee.setOnAction(actionEvent -> {
            deleteATypeOfCoffee();
            deleteATypeOfCoffee.getScene().getWindow().hide();
            LOG.info("User delete a type of coffee");
        });

        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
            LOG.info("User go back");
        });
    }

    public void deleteATypeOfCoffee() {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        if(coffeeName.getText().equals(""))
            warnIncorrectInput("You did not enter any data");
        dataBaseHandler.deleteCoffeeTypeFromDB(coffeeName.getText());
    }

    private void warnIncorrectInput(String message) {
        Stage stage = (Stage)deleteATypeOfCoffee.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.WARNING, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setHeaderText("ERROR");

        alert.showAndWait();
    }
}

