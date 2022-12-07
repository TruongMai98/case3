package com.casestudymodule3.dao;

import com.casestudymodule3.model.Customer;
import com.casestudymodule3.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/casestudy";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "admin";


    private static final String SELECT_ALL_PRODUCT = "select productid, name, image, price, title, SUBSTRING(description, 1, 26) as description, categoryId from product;";
    private static final String SEARCH_BY_ID = "select * from product where productid = ?";
    private static final String DELETE_PRODUCT = "delete from product where productid = ?;";
    private static final String CREATE_PRODUCT = "insert into product(name, title, price, description, image, categoryId) values (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT = "update product set name = ?,title= ?, price = ?, description = ?, image = ?, categoryId = ? where productid = ?";
    private static final String SEARCH_BY_NAME ="select productid, name, image, price, title, SUBSTRING(description, 1, 26) as description, categoryId from product where name like ? '%';";

    public ProductDAO() {
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

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("productid");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                int categoryId = resultSet.getInt("categoryId");
                String description = resultSet.getString("description");
                Product product = new Product(id, name, image, price, title, description, categoryId);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product search(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("productid");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                int categoryId = resultSet.getInt("categoryId");
                String description = resultSet.getString("description");
                product = new Product(id1, name, image, price, title, description, categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public boolean delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void create(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean update(int id, Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        Product product;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)){
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("productid");
                String name1 = resultSet.getString("name");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                int categoryId = resultSet.getInt("categoryId");
                String description = resultSet.getString("description");
                product = new Product(id, name1, image, price, title, description, categoryId);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}

