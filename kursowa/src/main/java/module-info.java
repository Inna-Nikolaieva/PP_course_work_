module com.example.kursowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.testng;
    requires org.junit.jupiter.api;


    opens com.example.kursowa to javafx.fxml;
    exports com.example.kursowa;
    exports com.example.kursowa.controllers;
    opens com.example.kursowa.controllers to javafx.fxml;
    exports com.example.kursowa.database;
    opens com.example.kursowa.database to javafx.fxml;
}