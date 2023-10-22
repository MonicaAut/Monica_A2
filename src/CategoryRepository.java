
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 64273
 */
public class CategoryRepository {
    Database db = new Database();
    
    // Get all Category from Scores in the database
    public String[] getAllCategories() {
        HashSet<String> list = new HashSet<>();
        String[] allCategories;
        db.establishConnection();
        ResultSet rs = null;
        try {

            String query = "SELECT DISTINCT category FROM Questions WHERE category !=?";

            rs = db.queryDB(query, "");
            
            while (rs.next())
            {
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
    
//    public static void main(String[] args) {
//        CategoryRepository ct = new CategoryRepository();
//        String [] categories = ct.getAllCategories();
//         // Display the HashSet
//        for(String category : categories)
//        {System.out.println(category);}
//    }
    
}
