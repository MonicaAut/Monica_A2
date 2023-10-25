
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class ScoreRepository {

    private Database db = new Database();

    // Get the highest score for a specific username in the database
    public int getUserHighestScore(String username) {
        int maxScore = 0;
        db.establishConnection();
        ResultSet rs = null;
        try {

            String query = "SELECT MAX(score) AS score FROM scores WHERE username = ?";

            rs = db.queryDB(query, username);

            if (rs.next()) {
                maxScore = rs.getInt("score");
                return maxScore;
            }
        } catch (SQLException e) {
            System.out.println("ERROR - getUserFromUsername" + e.getMessage());
        }

        db.closeConnections();
        return maxScore;
    }

    // Get all scoreID from Scores table in the database
    public ArrayList<String> getScoreID() {
        ArrayList<String> list = new ArrayList<>();
        db.establishConnection();
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM scores WHERE score >= ?";

            rs = db.queryDB(query, 0);

            while (rs.next()) {
                list.add(rs.getString("scoreID"));
            }

            return list;
        } catch (SQLException e) {
            System.out.println("ERROR - getllScore" + e.getMessage());
        }

        db.closeConnections();
        return list;
    }

    // Insert a new score record for a username
    public void insertNewScore(String username, int score) {
        String query = "INSERT INTO Scores (scoreID, username, score, date) VALUES (?, ?, ?, CURRENT_DATE)";

        try {
            String scoreID = this.generateScoreID();
            this.db.updateDB(query, scoreID, username, score);
        } catch (SQLException ex) {
            System.out.println("ERROR - Insert User" + ex.getMessage());
        }
    }

    // Generate ScoreID randomly
    public String generateScoreID() {
        // Get a list of all scoreID in database
        ArrayList<String> scoreIDList = this.getScoreID();
        boolean exist = true;

        //ID start with 'S'
        String id = "S";
        //ID end with 5
        DecimalFormat df = new DecimalFormat("0000");
        while (exist) {
            Random rand = new Random();
            int number = rand.nextInt(100000);

            id += df.format(number);

            exist = scoreIDList.contains(id);
        }

        return id;
    }
}
