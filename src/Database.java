/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import org.apache.derby.iapi.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.Date;

/**
 *
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class Database {

    Connection conn = null;
    String url = "jdbc:derby:OriginalCountryQuizz_Ebd; create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";

    public Database() {
        this.establishConnection();

        try {
            if (!checkExistedTable("Users")) {
                String query = "CREATE TABLE " + "Users" + " (firstName VARCHAR(20), lastName VARCHAR(20), username VARCHAR(20), password VARCHAR(10))";
                this.updateDB(query);
            }

            if (!checkExistedTable("Scores")) {
                String query = "CREATE TABLE " + "Scores" + " (ScoreID VARCHAR(10), username VARCHAR(20), score INTEGER, date DATE)";
                this.updateDB(query);
            }

            if (!checkExistedTable("Questions")) {
                String query = "CREATE TABLE " + "Questions" + " (QuestionID VARCHAR(10), Question VARCHAR(50), Category VARCHAR (20), Answer VARCHAR(20))";
                this.updateDB(query);
            }

        } catch (Throwable e) {
            System.out.println("Error - Database: " + e.getMessage());
        }

        this.closeConnections();
    }

    /**
     * Executes a database query and returns the ResultSet.
     *
     * @param query The SQL query to execute.
     * @param args An array of query parameters to bind to the query.
     * @return A ResultSet containing the query results.
     * @throws SQLException If a database error occurs during the query
     * execution.
     */
    public ResultSet queryDB(String query, Object... args) throws SQLException {
        System.out.println("queryDB - " + query);

        ResultSet rs = null;

        try {
            // Create a PreparedStatement for the given query
            PreparedStatement ps = conn.prepareStatement(query);

            int i = 1;
            for (Object arg : args) {
                // Bind query parameters based on their data type
                if (arg instanceof Float) {
                    ps.setFloat(i, (Float) arg);
                } else if (arg instanceof Double) {
                    ps.setDouble(i, (Double) arg);
                } else if (arg instanceof Integer) {
                    ps.setInt(i, (Integer) arg);
                } else if (arg instanceof Boolean) {
                    ps.setBoolean(i, (Boolean) arg);
                } else if (arg instanceof Date) {
                    ps.setDate(i, (Date) arg);
                } else if (arg instanceof String) {
                    ps.setString(i, (String) arg);
                }

                i++;
            }
            // Execute the query and obtain the ResultSet
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            // Handle any SQLException by printing the error message
            System.out.println(ex.getMessage());
        }
        // Return the ResultSet, which may be null if there was an exception    
        return rs;
    }

    /**
     * Executes a database update operation, such as INSERT, UPDATE, or DELETE
     * based on the provided query.
     *
     * @param query The SQL query for the update operation.
     * @param args An array of query parameters to bind to the query.
     * @throws SQLException If a database error occurs during the update
     * operation.
     */
    public void updateDB(String query, Object... args) throws SQLException {
        try {
            // Create a PreparedStatement for the given query
            PreparedStatement ps = conn.prepareStatement(query);

            int i = 1;
            for (Object arg : args) {
                // Bind query parameters based on their data type
                if (arg instanceof Integer) {
                    ps.setInt(i, (Integer) arg);
                } else if (arg instanceof Boolean) {
                    ps.setBoolean(i, (Boolean) arg);
                } else if (arg instanceof String) {
                    ps.setString(i, (String) arg);
                }

                i++;
            }
            // Execute the update query and obtain the number of changed rows
            int changedRow = ps.executeUpdate();
            // Print a message if at least one row was changed
            if (changedRow > 0) {
                System.out.println("A row is changed.");
            }

        } catch (SQLException ex) {
            // Handle any SQLException by printing the error message
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Establishes a database connection using the specified connection details.
     *
     */
    public void establishConnection() {
        try {
            // Check if the connection is null or closed
            if (conn == null || conn.isClosed()) {
                // Create a new connection using the provided URL, username, and password
                conn = DriverManager.getConnection(url, dbusername, dbpassword);
                // Print a message to indicate a successful connection
                System.out.println(url + "   CONNECTED....");
            }

        } catch (SQLException ex) {
            // Handle any SQLException by printing an error message
            System.out.println("ERROR - establishConnection: " + ex.getMessage());
        }
    }

    /**
     * Closes the database connection if it is open.
     */
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();

                System.out.println(url + "   CLOSED....");
            } catch (SQLException ex) {
                System.out.println("ERROR: closeConnections - " + ex.getMessage());
            }
        }
    }

    // Check if a table is already existed
    private boolean checkExistedTable(String tableName) {
        boolean flag = false;
        try {
            System.out.println("Check existing table...");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = this.conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, null, null);//types

            // Drop the table
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                if (table_name.compareToIgnoreCase(tableName) == 0) {
                    System.out.println(table_name + " is exist already");
                    flag = true;
                }
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return flag;
    }
}
