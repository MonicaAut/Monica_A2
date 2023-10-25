
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class CategoryRepository {

    private Database db = new Database();

    // Get all categories from Scores table in the database
    public String[] getAllCategories() {
        HashSet<String> list = new HashSet<>();
        String[] allCategories;
        db.establishConnection();
        ResultSet rs = null;
        try {

            String query = "SELECT DISTINCT category FROM Questions WHERE category !=?";

            rs = db.queryDB(query, "");

            while (rs.next()) {
                list.add(rs.getString("category"));
            }

            allCategories = list.toArray(new String[0]);
            return allCategories;
        } catch (SQLException e) {
            System.out.println("ERROR - getAll Categories" + e.getMessage());
        }

        db.closeConnections();
        return null;
    }

}
