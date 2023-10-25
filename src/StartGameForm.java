
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class StartGameForm extends javax.swing.JFrame {

    private String firstName;
    private String lastName;
    String username;
    private String password;
    private int highestScore = 0;
    ScoreRepository scoreRepository = new ScoreRepository();
    UserRepository userRepository = new UserRepository();

    /**
     * Creates new form StartGameForm
     */
    public StartGameForm() {
        initComponents();

        // Display homepage icon on Jlabel
        ImageIcon homepageIcon = new ImageIcon("./resources/homepageIcon.png");

        // Resize after_image to fit JLable
        Image homepageImage = homepageIcon.getImage().getScaledInstance(jLabel_BackToHomePage.getWidth(), jLabel_BackToHomePage.getHeight(), Image.SCALE_SMOOTH);
        jLabel_BackToHomePage.setIcon(new ImageIcon(homepageImage));
    }

    // Set the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Set the firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Set the lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     // Set the password
    public void setPassword(String password) {
        this.password = password;
    }

    // Set the highest Score
    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    //Innitialise all field in the Start Game Form
    public void innitialiseStartGameForm(String username) {
        this.setUsername(username);
        //Get all user info
        highestScore = scoreRepository.getUserHighestScore(username);
        ResultSet rs = userRepository.getUserFromUsername(username);
        try {
            if (rs.next()) {
                this.setFirstName(rs.getString("firstname"));
                this.setLastName(rs.getString("lastname"));
                this.setUsername(rs.getString("username"));
                this.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        // Display all field in the form
        jTextField_StartGame_FirstName.setText(firstName);
        jTextField_StartGame_LastName.setText(lastName);
        jTextField_StartGame_Username.setText(username);
        jPasswordField_password.setText(password);
        jTextField_StartGame_HighestScore.setText(String.valueOf(highestScore));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_StartGame = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_StartGame_Username = new javax.swing.JTextField();
        jTextField_StartGame_LastName = new javax.swing.JTextField();
        jTextField_StartGame_FirstName = new javax.swing.JTextField();
        jPasswordField_password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_StartGame_HighestScore = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel_BackToHomePage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jButton_StartGame.setText("START A GAME");
        jButton_StartGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_StartGameMouseClicked(evt);
            }
        });
        jButton_StartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StartGameActionPerformed(evt);
            }
        });

        jLabel4.setText("First Name");

        jLabel5.setText("Last Name");

        jTextField_StartGame_LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StartGame_LastNameActionPerformed(evt);
            }
        });

        jTextField_StartGame_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StartGame_FirstNameActionPerformed(evt);
            }
        });

        jPasswordField_password.setText("jPasswordField1");
        jPasswordField_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_passwordActionPerformed(evt);
            }
        });

        jLabel6.setText("Your Highest Score");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("YOUR DETAILS");

        jLabel_BackToHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BackToHomePageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_StartGame_FirstName)
                                    .addComponent(jTextField_StartGame_LastName, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_StartGame_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_StartGame_HighestScore, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_StartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_BackToHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addComponent(jLabel_BackToHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_StartGame_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_StartGame_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_StartGame_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_StartGame_HighestScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_StartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_StartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_StartGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_StartGameActionPerformed

    private void jPasswordField_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField_passwordActionPerformed

    private void jTextField_StartGame_FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StartGame_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StartGame_FirstNameActionPerformed

    private void jTextField_StartGame_LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StartGame_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StartGame_LastNameActionPerformed

    // Action when StartGame button is clicked
    private void jButton_StartGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_StartGameMouseClicked
        // Go to Dynamics Categories form
        System.out.println("Go to DyamicCategories form");
        System.out.println("UserName" + username);
        DynamicCategories dynamicCategoriesForm = new DynamicCategories();
        dynamicCategoriesForm.setUsername(this.username);
        dynamicCategoriesForm.setVisible(true);
        dynamicCategoriesForm.pack();
        dynamicCategoriesForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_StartGameMouseClicked

    // Action when mouse clicked in BackToHomePage symbol
    private void jLabel_BackToHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BackToHomePageMouseClicked
        // Go to Firstpage form
        HomePage fp = new HomePage();
        fp.setVisible(true);
        fp.pack();
        fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel_BackToHomePageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_StartGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_BackToHomePage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_password;
    private javax.swing.JTextField jTextField_StartGame_FirstName;
    private javax.swing.JTextField jTextField_StartGame_HighestScore;
    private javax.swing.JTextField jTextField_StartGame_LastName;
    private javax.swing.JTextField jTextField_StartGame_Username;
    // End of variables declaration//GEN-END:variables
}
