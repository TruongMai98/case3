package com.casestudymodule3.dao;

import com.casestudymodule3.model.Cart;
import com.casestudymodule3.model.CartDetail;
import com.casestudymodule3.model.Product;

import java.sql.*;
import java.time.LocalDate;

public class CartDAO {
    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/casestudy";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "admin";
    public static final String CREATE_CART = "insert into cart(cartid, customerid, createdate, status) values(?, ?, ?, ?);";
    public static final String CHECK_CART = "select * from cart where cartid = ? and status = false;";
    public static final String UPDATE_CART = "update cart set status = ?, createdate = ? where cartid = ?;";
    public static final String CREATE_CART_DETAIL = "insert into cartdetail(cartdetailid, cartid, productid,quantity, price) values (?, ?, ?, ?, ?);";
    public static final String CHECK_PRODUCT_ID = "select * from cartdetail where cardid = ? and productid = ?;";
    public static final String UPDATE_CART_DETAIL = "update  cartdetail set  productid = ?, quantity = ? where cartid = ?;";

    public CartDAO() {
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


    /*---------------cart----------------*/
    public void createCart(Cart cart) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CART)){
            preparedStatement.setInt(1, cart.getCartId());
            preparedStatement.setInt(2, cart.getCustomerId());
            preparedStatement.setDate(3, Date.valueOf(cart.getCreateDate()));
            preparedStatement.setBoolean(4, cart.isStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean checkCart(int cartId) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_CART)){
            if (preparedStatement != null) {
                return true;
            } else {
                try (Connection connection1 = getConnection();
                PreparedStatement preparedStatement1 = connection1.prepareStatement(UPDATE_CART)){
                    preparedStatement1.setBoolean(1, true);
                    preparedStatement1.setDate(2, Date.valueOf(LocalDate.now()));
                    preparedStatement1.setInt(3, cartId);
                    preparedStatement1.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /*------------cart detail-------------------*/
    public void createCartDetail(CartDetail cartDetail, Product product) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CART_DETAIL)){
            if (preparedStatement != null) {
                try (Connection connection1 = getConnection();
                PreparedStatement preparedStatement1 = connection1.prepareStatement(CHECK_PRODUCT_ID)){
                if (preparedStatement1 != null) {
                    try (Connection connection2 = getConnection();
                    PreparedStatement preparedStatement2 = connection2.prepareStatement(UPDATE_CART_DETAIL)){
                        preparedStatement2.setInt(1, product.getId());
                        preparedStatement2.setInt(2, cartDetail.getQuantity() + 1);
                    }
                } else {
                    try (Connection connection3 = getConnection();
                    PreparedStatement preparedStatement3 = connection3.prepareStatement(CREATE_CART_DETAIL)){
                        preparedStatement3.setInt(1, cartDetail.getCartDetailId());
                        preparedStatement3.setInt(2, cartDetail.getCartId());
                        preparedStatement3.setInt(3, cartDetail.getProductId());
                        preparedStatement3.setInt(4, cartDetail.getQuantity());
                        preparedStatement.setDouble(5, cartDetail.getPrice());
                        preparedStatement3.executeUpdate();
                    }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
