package com.example.kursowa.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.kursowa.HelloApplication;
import com.example.kursowa.consolemenu.CommandsController;
import com.example.kursowa.database.DataBaseHandler;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getSimpleName());
    private CommandsController commandsController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addANewTypeOfCoffee;

    @FXML
    private Button changeDataOfCoffee;

    @FXML
    private Button cleanTheVan;

    @FXML
    private Button deleteATypeOfCoffee;

    @FXML
    private Button exit;

    @FXML
    private Button fillInTheVan;

    @FXML
    private Button findCoffeeByRangeOfParameters;

    @FXML
    private Button printArrayOfCoffee;

    @FXML
    private Button sortCoffeeInTheVan;

    @FXML
    void initialize() {

        commandsController = HelloApplication.commandsController;

        addANewTypeOfCoffee.setOnAction(event -> {
            commandsController.execute("addCoffee");
            LOG.info("User clicks addANewTypeOfCoffee button. Executing \"addCoffee\" command");
        });

        changeDataOfCoffee.setOnAction(event -> {
            commandsController.execute("changeDataOfCoffee");
            LOG.info("User clicks changeDataOfCoffee button. Executing \"changeDataOfCoffee\" command");
        });

        deleteATypeOfCoffee.setOnAction(event -> {
            commandsController.execute("deleteATypeOfCoffee");
            LOG.info("User clicks deleteATypeOfCoffee button. Executing \"deleteATypeOfCoffee\" command");
        });

        printArrayOfCoffee.setOnAction(event -> {
            commandsController.execute("showTypesOfCoffee");
            LOG.info("User clicks printArrayOfCoffee button. Executing \"showTypesOfCoffee\" command");
        });

        fillInTheVan.setOnAction(event -> {
            commandsController.execute("createAndFillAVan");
            LOG.info("User clicks fillInTheVan button. Executing \"createAndFillAVan\" command");
        });

        sortCoffeeInTheVan.setOnAction(event -> {
            commandsController.execute("sortCoffee");
            LOG.info("User clicks sortCoffeeInTheVan button. Executing \"sortCoffee\" command");
        });

        findCoffeeByRangeOfParameters.setOnAction(event -> {
            commandsController.execute("findCoffeeByQualityParameters");
            LOG.info("User clicks findCoffeeByRangeOfParameters button. Executing \"findCoffeeByQualityParameters\" command");
        });

        cleanTheVan.setOnAction(event -> {
            DataBaseHandler dataBaseHandler=new DataBaseHandler();
            dataBaseHandler.cleanTheVan();
            LOG.info("User clicks cleanTheVan. Creating new empty salad");
        });

        exit.setOnAction(event -> {
            LOG.info("User clicks Exit button. Exiting program");
            Platform.exit();
            System.exit(0);
        });
    }
}