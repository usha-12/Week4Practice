package com.jdbc;

import java.sql.*;

public class TransactionDemo {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice", "root", "Usha@123");

            connection.setAutoCommit(false);

            Statement stmt = connection.createStatement();

            stmt.execute("update persons set age=50 where personId=1;");

            // Syntax error
            stmt.execute("update persons set age=50 where personId=2;");

            stmt.execute("update persons set age = 40 where personId=3;");



        }catch (Exception e) {
            System.out.println(e.getMessage());
            connection.rollback();
        }
        finally {
            connection.commit();
        }

    }

}
