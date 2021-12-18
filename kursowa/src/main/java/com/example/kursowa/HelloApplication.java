package com.example.kursowa;

import com.example.kursowa.consolemenu.CommandsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class HelloApplication extends Application {
    private static final Logger LOG = Logger.getLogger(HelloApplication.class.getSimpleName());
    public static CommandsController commandsController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Фургон кави");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        commandsController = new CommandsController();
        LOG.info("Creating CommandsController");
        launch();
    }
}