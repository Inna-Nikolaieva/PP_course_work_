package com.example.kursowa.consolemenu;


import com.example.kursowa.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class DeleteATypeOfCoffeeCommand implements Command{
    private static final Logger LOG = Logger.getLogger(DeleteATypeOfCoffeeCommand.class.getSimpleName());

    public final static String NAME = "deleteATypeOfCoffee";

    @Override
    public void execute() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("DeleteACoffee.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            //LOG.error("Error opening ChangeDataOfCoffee window");
            //LOG.error(e.getMessage());
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
