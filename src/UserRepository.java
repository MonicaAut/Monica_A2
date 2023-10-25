
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class UserRepository {

    private Database db = new Database();

    // Get user info from username in the database
    public ResultSet getUserFromUsername(String username) {
        db.establishConnection();
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM Users WHERE username=?";

            rs = db.queryDB(query, username);

            return rs;
        } catch (SQLException e) {
            System.out.println("ERROR - getUserFromUsername" + e.getMessage());
        }

        db.closeConnections();
        return rs;
    }

    // Check username exist
    public boolean checkUsernameExist(String username) {
        boolean exist = false;

        ResultSet rs;

        try {
            rs = this.getUserFromUsername(username);
            if (rs.next()) {
                exist = true;
                return exist;
            }
        } catch (SQLException e) {
            System.out.println("ERROR - getUserFromUsername" + e.getMessage());
        }

        return exist;
    }

    // Check username and password match
    public boolean checkUsernamePasswordMatch(String username, String password) {
        boolean match = false;

        ResultSet rs;

        try {
            rs = this.getUserFromUsername(username);
            if (rs.next()) {
                String databasePassword = rs.getString("password");

                if (databasePassword.equals(password)) {
                    match = true;
                    return match;
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR - getUserFromUsername" + e.getMessage());
        }

        return match;
    }

    // Insert a new user
    public void insertNewUser(String firstname, String lastname, String username, String password) {
        String query = "INSERT INTO Users (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";

        try {
            if (!this.checkUsernameExist(username)) {
                this.db.updateDB(query, firstname, lastname, username, password);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR - Insert User" + ex.getMessage());
        }
    }
}
