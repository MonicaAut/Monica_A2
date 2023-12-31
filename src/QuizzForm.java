
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class QuizzForm extends javax.swing.JFrame {

    private QuizzRepository quizzRepository = new QuizzRepository();
    private HashMap<String, Question> questionMap = new HashMap<>();
    private String userAnswer = "";
    private String currentQuestionID = "";
    private int countQuestions = 0;
    private int currentScore = 0;
    private boolean isAnsweredCorrect;
    private final int ROUND_SIZE = 5;
    private String username;
    private ScoreRepository scoreResposity = new ScoreRepository();
    private StartGameForm startGameForm = new StartGameForm();
    
    // Set value for questionMap by retrieve the question collection for the chosen category from database
    public void setQuestionsForChosenCategory(String category) {
        HashMap<String, Question> result = quizzRepository.getQuestionCollection(category);

        // Check if result is null before returning
        if (result != null) {
            questionMap = result;
        }
    }

    //Set current question by randomly generate question method in QuizzRepository
    public void setQuestion() {
        currentQuestionID = quizzRepository.generateQuestion(questionMap);
        jTextField_Question.setText(questionMap.get(currentQuestionID).getQuestion());
    }

    /**
     * Creates new form QuizzForm
     */
    public QuizzForm() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_userAnswer = new javax.swing.JTextField();
        jButton_next = new javax.swing.JButton();
        jButton_quit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField_Question = new javax.swing.JTextArea();

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Question");

        jLabel2.setText("Answer");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("QUIZZ");

        jTextField_userAnswer.setText("Input a country name");
        jTextField_userAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_userAnswerActionPerformed(evt);
            }
        });

        jButton_next.setText("Next");
        jButton_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_nextMouseClicked(evt);
            }
        });
        jButton_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nextActionPerformed(evt);
            }
        });

        jButton_quit.setText("Quit");
        jButton_quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_quitMouseClicked(evt);
            }
        });

        jTextField_Question.setColumns(20);
        jTextField_Question.setRows(5);
        jScrollPane1.setViewportView(jTextField_Question);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jButton_next)
                        .addGap(43, 43, 43)
                        .addComponent(jButton_quit)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField_userAnswer))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_userAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_next)
                    .addComponent(jButton_quit))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Set the username value
    public void setUsername(String username) {
        this.username = username;
    }
    private void jTextField_userAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_userAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_userAnswerActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton_quitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_quitMouseClicked
        // Show message warning 
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure?", "You're quiting the game", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            //Set username
            startGameForm.setUsername(username);
            // Implement method to set all field in StartGame form
            startGameForm.innitialiseStartGameForm(username);
            // Go to Start Game form
            startGameForm.setVisible(true);
            startGameForm.pack();
            startGameForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        } else {
            // Remain the current round (do nothing)
        }

    }//GEN-LAST:event_jButton_quitMouseClicked

    private void jButton_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_nextActionPerformed

    private void jButton_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_nextMouseClicked
        // Set answer
        this.userAnswer = jTextField_userAnswer.getText();      
        //check if answerField is empty
        if (this.userAnswer.equalsIgnoreCase("") || this.userAnswer.equalsIgnoreCase("Input a country name"))
        {
            // Show a message to ask user to input the answer
            JOptionPane.showMessageDialog(this, "Please input your answer",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
          //Count the number of answered questions
        countQuestions++;
        System.out.println("You answered " + countQuestions + " question(s)!");
        
        // Set the isAnswered value of the currentQuestion in the questionMap to true
        questionMap.get(currentQuestionID).setIsAnswered(true);
       
        // Check the answer
        isAnsweredCorrect = quizzRepository.checkUserAnswer(userAnswer, currentQuestionID, questionMap);
        System.out.println("Your answer is " + isAnsweredCorrect);
        // Increment score by 10
        if (isAnsweredCorrect) {
            currentScore += 10;
            System.out.println("Your current score: " + currentScore);
        }
        //Clear the answer field
        jTextField_userAnswer.setText("");

        // Check if the user answered all questions in the round       
        if (countQuestions < ROUND_SIZE) {
            // Generate a new question
            System.out.println("Generating a new question!");
            this.setQuestion();
        } else {
            // Pop a message, let the user know he/she completed the round
            System.out.println("No more questions to go");
            JOptionPane.showMessageDialog(null, "Your score for this round: " + currentScore, "You've completed all questions!!!", JOptionPane.PLAIN_MESSAGE);
            // Record the score
            System.out.println("Update score database");
            scoreResposity.insertNewScore(username, currentScore);
            // Go back to StartGameForm:
            // Implement method to set all field in StartGame form
            startGameForm.innitialiseStartGameForm(username);
            // Go back to StartGame form
            startGameForm.setVisible(true);
            startGameForm.pack();
            startGameForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }  
        }
    }//GEN-LAST:event_jButton_nextMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_next;
    private javax.swing.JButton jButton_quit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea jTextField_Question;
    private javax.swing.JTextField jTextField_userAnswer;
    // End of variables declaration//GEN-END:variables
}
