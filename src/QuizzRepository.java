
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
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class QuizzRepository {

    private Database db = new Database();

    public QuizzRepository() {

    }

    // Get all question from Questions in the database
    public HashMap<String, Question> getQuestionCollection(String category) {
        HashMap<String, Question> questionCollection = new HashMap<String, Question>();
        db.establishConnection();
        ResultSet result;
        try {

            String query = "SELECT * FROM questions WHERE category = ?";

            result = db.queryDB(query, category);

            while (result.next()) {
                Question quizz = new Question();
                quizz.setQuestionID(result.getString("questionID"));
                quizz.setQuestion(result.getString("question"));
                quizz.setCategory(result.getString("category"));
                quizz.setAnswer(result.getString("answer"));
                questionCollection.put(quizz.getQuestionID(), quizz);
            }

            return questionCollection;
        } catch (SQLException e) {
            System.out.println("ERROR - getFoodQuestionCollection" + e.getMessage());
        }

        db.closeConnections();
        return questionCollection;
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

    // Set the question is answered and check if the answer is true or false
    public boolean checkUserAnswer(String userAnswer, String questionID, HashMap<String, Question> qc) {
        System.out.println("User's answer: " + userAnswer);
        String systemAnswer = qc.get(questionID).getAnswer();
        System.out.println("System answer: " + systemAnswer);
        return userAnswer.equalsIgnoreCase(systemAnswer);
    }

}
