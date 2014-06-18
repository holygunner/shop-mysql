package com.shop;

import java.sql.*;

public class Connection {
	
    private static Connection ourInstance = new Connection();

    public static Connection getInstance() {
        return ourInstance;
    }

    private Connection() {
    }

    private String user;
    private String password;

    private java.sql.Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    private void setConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", user, password);
    }

    protected void setUser(String user) {
       this.user = user;
    }

    protected void setPassword(String password) {
       this.password = password;
    }

    public void changeData(String query) throws SQLException {
        Connection.getInstance().setConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();
    }




    public void showData(String query) throws SQLException {
        Connection.getInstance().setConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        if (query.contains("count")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("count(products.name)") + " product(s) is/are found");
            }
        }
        else {
             if (query.contains("producer")) {
                    while (resultSet.next()) {
                    System.out.println(resultSet.getString("producer.name") + " " + resultSet.getString("products.name")
                    + " - " + resultSet.getString("products.price") + "$" +
                    " - " + resultSet.getString("producer.country"));
        }

        }     else {
                    while (resultSet.next()) {
                    System.out.println(resultSet.getString("name") + " - " + resultSet.getString("price") + "$");
        }
        }
        }

        statement.close();
    }

}
