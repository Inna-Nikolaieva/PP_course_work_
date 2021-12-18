package com.example.kursowa.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.kursowa.database.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FillInTheVanController {

    private static final Logger LOG = Logger.getLogger(FillInTheVanController.class.getSimpleName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addCoffeeInTheVan;

    @FXML
    private TextField amountOfVan;

    @FXML
    private TextField coffeeName;

    @FXML
    private Button createAVan;

    @FXML
    private Button exit;

    @FXML
    private ListView<?> list;

    @FXML
    private AnchorPane listOfCoffee;

    @FXML
    private TextField numberOfPackages;

    @FXML
    private TextField volumeOfVav;

    @FXML
    void initialize() {

        createAVan.setOnAction(actionEvent -> {
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            dataBaseHandler.createAVan(new Double(volumeOfVav.getText()), new Double(amountOfVan.getText()));
            LOG.info("User create a van");
        });

        addCoffeeInTheVan.setOnAction(actionEvent -> {
            fillInTheVanOfCoffee();
            LOG.info("User add coffee in the van");
        });

        exit.setOnAction(actionEvent -> {
            exit.getScene().getWindow().hide();
            LOG.info("User go back");
        });
    }


    public void fillInTheVanOfCoffee() {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        if (volumeOfVav.getText().equals("") || amountOfVan.getText().equals("")) {
            Stage stage = (Stage) createAVan.getScene().getWindow();

            Alert alert = new Alert(Alert.AlertType.WARNING, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setContentText("You did not enter any data");
            alert.getDialogPane().setHeaderText("ERROR");

            alert.showAndWait();
            volumeOfVav.setText("");
            amountOfVan.setText("");
        }

        if (coffeeName.getText().equals("") || numberOfPackages.getText().equals("")) {
            Stage stage = (Stage) addCoffeeInTheVan.getScene().getWindow();

            Alert alert = new Alert(Alert.AlertType.WARNING, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setContentText("You did not enter any data");
            alert.getDialogPane().setHeaderText("ERROR");

            alert.showAndWait();
            coffeeName.setText("");
            numberOfPackages.setText("");
        }
        dataBaseHandler.fillInTheVanOfCoffee(new Double(volumeOfVav.getText()), new Double(amountOfVan.getText()), coffeeName.getText(), new Integer(numberOfPackages.getText()));

    }
}

