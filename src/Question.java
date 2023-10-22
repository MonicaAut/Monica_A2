/**
 *
 * @author 64273
 */
public class Question {
    private String questionID;
    private String question;
    private String category;
    private String answer;
    private boolean isAnswered;

    public Question(String questionID, String question, String answer) {
        this.questionID = questionID;
        this.question = question;
        
        this.answer = answer;
        this.isAnswered = false;
    }
    public Question()
    {
       this.setIsAnswered(false); 
    }
    
    

    /**
     * @return the questionID
     */
    public String getQuestionID() {
        return questionID;
    }

    /**
     * @param questionID the questionID to set
     */
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    
    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the isAnswered
     */
    public boolean getIsAnswered() {
        return isAnswered;
    }

    /**
     * @param isAnswered the isAnswered to set
     */
    public void setIsAnswered(boolean isAnswered) {
        this.isAnswered = isAnswered;
    } 
}
