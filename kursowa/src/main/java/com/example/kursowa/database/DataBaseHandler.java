package com.example.kursowa.database;

import com.example.kursowa.fillingthevan.Coffee;
import com.example.kursowa.fillingthevan.ProductBox;
import com.example.kursowa.van.Van;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBaseHandler extends ConnectToDataBase {
    private Connection dbConnection;
    private ArrayList<Coffee> coffeeArrayList = new ArrayList<>();
    private Van van;
    private ArrayList<Coffee> productBoxes = new ArrayList<>();

    public ArrayList getCoffeeArrayList() {
        return coffeeArrayList;
    }

    public ArrayList getProductBoxes() {
        return productBoxes;
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void addNewCoffeeType(Coffee coffee) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.COFFEE_NAME
                + "," + Const.COFFEE_SORT + "," + Const.COFFEE_TYPE + "," + Const.COFFEE_AMOUNT
                + "," + Const.COFFEE_WEIGHT + "," + Const.COFFEE_VOLUME + "," + Const.COFFEE_PACK + ")"
                + " VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, coffee.getProductName());
            preparedStatement.setString(2, coffee.getCoffeeSort());
            preparedStatement.setString(3, coffee.getCoffeeType());
            preparedStatement.setDouble(4, coffee.getAmount());
            preparedStatement.setDouble(5, coffee.getGrossWeight());
            preparedStatement.setDouble(6, coffee.getGrossVolume());
            preparedStatement.setString(7, coffee.getCoffeePack());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList getDataListOfCoffee() {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            String select = "SELECT * FROM " + Const.USER_TABLE;

            Connection connection = getDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                coffeeArrayList.add(new Coffee(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getString(8)));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            } catch (SQLException ignored) {
            }
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException ignored) {
            }
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException ignored) {
            }
        }

        return coffeeArrayList;
    }

    public void deleteCoffeeTypeFromDB(String name) {

        try {
            String delete = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.COFFEE_NAME + " = '" + name + "';";

            Connection connection = getDbConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(delete);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

    }

    public void changeParametersOfCoffee(String nameOfCoffee, String nameOfParameter, String newData) {

        try {
            String update = "UPDATE " + Const.USER_TABLE + " SET " + nameOfParameter + " = '" +
                    newData + "'" + " WHERE " + Const.COFFEE_NAME + " = '" + nameOfCoffee + "';";

            Connection connection = getDbConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(update);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public void createAVan(Double maxVolume, Double maxAmount) {
        van = new Van(maxVolume, maxAmount);
    }

    public void fillInTheVanOfCoffee(Double maxVolume, Double maxAmount, String coffeeName, Integer numberOfPack) {

        try {
            String update = "CALL fillTheVan( " + maxAmount + "," + maxVolume + "," + coffeeName + "," + numberOfPack + ");";


            Connection connection = getDbConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(update);

            String select = "SELECT * FROM " + Const.USER_TABLE_2;
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                van.addPack(new Coffee(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getString(8)), numberOfPack);

            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public ArrayList findCoffeeByRangeOfParameters(Double From, Double To, String parameter) {

        try {
            String select = "SELECT * FROM " + Const.USER_TABLE_2 + " WHERE " +
                    parameter + " > " + From + " AND " + parameter + " < " + To;

            Connection connection = getDbConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                productBoxes.add(new Coffee(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getString(8)));
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return productBoxes;
    }

    public void sortByPriceByWeight() {

        van.sortByPriceByWeight();
    }

    public void cleanTheVan(){

        van.makeWagonEmpty();
        try {
            String drop = "TRUNCATE TABLE " + Const.USER_TABLE_2 + ";";

            Connection connection = getDbConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(drop);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }
}
