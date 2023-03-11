package com.casestudymodule3.dao;

import com.casestudymodule3.model.Customer;
import com.casestudymodule3.model.Product;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    //    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/casestudy";
    private static final String URL_CONNECTION = "mysql://bdcfaa5d33ead7:6a0edec0@eu-cdbr-west-03.cleardb.net/heroku_531cd4f8c02cae4?reconnect=true";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //    private static final String USER_NAME = "root";
    private static final String USER_NAME = "bdcfaa5d33ead7";
    private static final String PASSWORD = "6a0edec0";
//    private static final String PASSWORD = "admin";


    private static final String CHECK_LOGIN = "select username, password from customer where username = ? and password = ?;";
    private static final String SEARCH_BY_ID = "select * from customer where customerid = ?;";
    private static final String SEARCH_BY_USERNAME = "select * from customer where username = ?;";
    public static final String SELECT_ALL_CUSTOMER = "select * from customer";

    public CustomerDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL_CONNECTION, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for jdbc connection!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not find database!");
            e.printStackTrace();
        }
        return connection;
    }

    public Customer checkLogin(String userName, String password) {
        Customer customer = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                customer = new Customer(user, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Customer search(int id) {
        Customer customer = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                int roleId = resultSet.getInt("roleId");
                String fullName = resultSet.getString("fullname");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                customer = new Customer(id1, roleId, fullName, user, pass, email, address, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int roleId = resultSet.getInt("roleId");
                String fullName = resultSet.getString("fullname");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                Customer customer = new Customer(id, roleId, fullName, user, pass, email, address, phone);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Customer searchByUserName(String userName) {
        Customer customer = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_USERNAME)) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int roleId = resultSet.getInt("roleId");
                String fullName = resultSet.getString("fullname");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                customer = new Customer(id, roleId, fullName, user, pass, email,address, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}