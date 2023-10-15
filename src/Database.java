/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import org.apache.derby.iapi.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.Date;

/**
 *
 * @author 64273
 */
public class Database {

    Connection conn = null;
    String url = "jdbc:derby:OriginalCountryQuizz_Ebd; create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";
    private Statement statement;

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

    public ResultSet queryDB(String query, Object... args) throws SQLException {
        System.out.println("queryDB - " + query);

        ResultSet rs = null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            int i = 1;
            for (Object arg : args) {
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

            rs = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return rs;
    }

    public void updateDB(String query, Object... args) throws SQLException {
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            int i = 1;
            for (Object arg : args) {
                if (arg instanceof Integer) {
                    ps.setInt(i, (Integer) arg);
                } else if (arg instanceof Boolean) {
                    ps.setBoolean(i, (Boolean) arg);
                } else if (arg instanceof String) {
                    ps.setString(i, (String) arg);
                }

                i++;
            }

            int changedRow = ps.executeUpdate();
            if (changedRow > 0) {
                System.out.println("A row is changed.");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean checkExistedTable(String tableName) {
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

    public void establishConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, dbusername, dbpassword);
                System.out.println(url + "   CONNECTED....");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR - establishConnection: " + ex.getMessage());
        }
    }

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

    public static void main(String args[]) throws SQLException {
        Database db = new Database();
    }
}
