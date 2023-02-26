package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Savepoint {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Savepoint savePoint1 = null;
        Savepoint savePoint2 = null;
        Savepoint savePoint3 = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice", "root", "Usha@123");
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            savePoint1 = (Savepoint) connection.setSavepoint();
            stmt.execute("update persons set age=80 where personId=1;");
            // Syntax error
            stmt.execute("update persons set age=80 where personId=2;");
            savePoint2 = (Savepoint) connection.setSavepoint();
            savePoint3 = (Savepoint) connection.setSavepoint();
            stmt.execute("updated persons set age=50 where personId=3;");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            connection.rollback((java.sql.Savepoint) savePoint1);
        }
        finally {
            connection.commit();
        }

    }

}
