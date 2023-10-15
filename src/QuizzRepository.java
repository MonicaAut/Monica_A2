
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 64273
 */
public class QuizzRepository {

    Database db;
    private int score;
    
    public QuizzRepository()
    {
    Database db = new Database();
    this.setScore(0);
    }
    
    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    // Get all question from Questions in the database
    public HashMap<String, Question> getQuestionCollection(String category) {
        HashMap<String, Question> qc = new HashMap<String, Question>();
        db.establishConnection();
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM questions WHERE category = ?";

            rs = db.queryDB(query, category);

            while (rs.next()) {
                Question quizz = new Question();
                quizz.setQuestionID(rs.getString("questionID"));
                quizz.setQuestion(rs.getString("question"));
                quizz.setCategory(rs.getString("category"));
                quizz.setAnswer(rs.getString("answer"));
                qc.put(quizz.getQuestionID(), quizz);
            }

            return qc;
        } catch (SQLException e) {
            System.out.println("ERROR - getFoodQuestionCollection" + e.getMessage());
        }

        db.closeConnections();
        return qc;
    }

    // Get a random question ID which hasn't answer from a question collection
    public String generateQuestion(HashMap<String, Question> qc) {
        // Get a list of all scoreID in database
        ArrayList<String> questionIDList = new ArrayList();

        for (HashMap.Entry<String, Question> q : qc.entrySet()) {
            questionIDList.add(q.getKey());
        }

        int questionListSize = questionIDList.size();

        boolean exist = true;

        //ID start with 'S'
        String chosenQuestionId = "";
        //ID end with 5
        while (exist) {
            Random rand = new Random();
            int index = rand.nextInt(questionListSize);

            chosenQuestionId = questionIDList.get(index);

            exist = qc.get(chosenQuestionId).getIsAnswered();
        }
        return chosenQuestionId;
    }
    
    // Set the question is answered and check if the answer is true or false, update the score
    // User get + 10 mark if answer is correct, no penalty mark
    public boolean checkUserAnswer(String userAnswer, String questionID, HashMap<String, Question> qc)
    {
        qc.get(questionID).setIsAnswered(true);
        String systemAnswer = qc.get(questionID).getAnswer();
        
        if(userAnswer.equalsIgnoreCase(systemAnswer))
        {
            this.setScore(this.getScore() + 10);
                 return true;
        }
        
        return false;        
    }

    public static void main(String[] args) {
        QuizzRepository qr = new QuizzRepository();

        HashMap<String, Question> qc = qr.getQuestionCollection("Food");

        System.out.println(qc.size());
        
        String question = qr.generateQuestion(qc);
        
        System.out.println(question);
        
        System.out.println(qr.checkUserAnswer("sfd", question, qc));
        
        System.out.println(qc.get(question).getIsAnswered());
        System.out.println(qr.getScore());      
    }

    

}
