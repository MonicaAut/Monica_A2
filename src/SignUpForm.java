
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
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
public class SignUpForm extends javax.swing.JFrame {

    private UserRepository userRepository = new UserRepository();
    private StartGameForm startGameForm = new StartGameForm();

    /**
     * Creates new form SignUpForm
     */
    public SignUpForm() {
        initComponents();
        // Display homepage icon on Jlabel
        ImageIcon homepageIcon = new ImageIcon("./resources/homepageIcon.png");

        // Resize after_image to fit JLable
        Image homepageImage = homepageIcon.getImage().getScaledInstance(jLabel_SignUp_BackToFirstPage.getWidth(), jLabel_SignUp_BackToFirstPage.getHeight(), Image.SCALE_SMOOTH);
        jLabel_SignUp_BackToFirstPage.setIcon(new ImageIcon(homepageImage));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_SignUp_FirstName = new javax.swing.JTextField();
        jTextField_SignUp_LastName = new javax.swing.JTextField();
        jTextField_SignUp_Username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField_SignUp_Password = new javax.swing.JPasswordField();
        jPasswordField_SignUp_ConfirmPassword = new javax.swing.JPasswordField();
        jButton_CreateAccount_SignUp = new javax.swing.JButton();
        jLabel_SignUp_BackToFirstPage = new javax.swing.JLabel();
        jTextField_SignUp_Login = new javax.swing.JLabel();

        jButton2.setText("Back to First Page");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("CREATE A NEW ACCOUNT");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Username");

        jLabel6.setText("Confirm Password");

        jTextField_SignUp_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SignUp_FirstNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Password");

        jPasswordField_SignUp_Password.setText("jPasswordField1");

        jPasswordField_SignUp_ConfirmPassword.setText("jPasswordField1");

        jButton_CreateAccount_SignUp.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jButton_CreateAccount_SignUp.setText("SIGN UP");
        jButton_CreateAccount_SignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_CreateAccount_SignUpMouseClicked(evt);
            }
        });

        jLabel_SignUp_BackToFirstPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_SignUp_BackToFirstPageMouseClicked(evt);
            }
        });

        jTextField_SignUp_Login.setText("Already have one, back to log in");
        jTextField_SignUp_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_SignUp_LoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField_SignUp_LoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField_SignUp_LoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_SignUp_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField_SignUp_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_SignUp_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField_SignUp_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField_SignUp_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_SignUp_BackToFirstPage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_SignUp_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CreateAccount_SignUp))
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_SignUp_BackToFirstPage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_SignUp_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_SignUp_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_SignUp_Username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField_SignUp_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordField_SignUp_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton_CreateAccount_SignUp)
                .addGap(18, 18, 18)
                .addComponent(jTextField_SignUp_Login)
                .addGap(34, 34, 34))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_SignUp_FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SignUp_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SignUp_FirstNameActionPerformed

    private void jButton_CreateAccount_SignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CreateAccount_SignUpMouseClicked
        // Get input value
        String firstName = jTextField_SignUp_FirstName.getText();
        String lastName = jTextField_SignUp_LastName.getText();
        String username = jTextField_SignUp_Username.getText();
        String password = String.valueOf(jPasswordField_SignUp_Password.getPassword());
        String confirmPassword = String.valueOf(jPasswordField_SignUp_ConfirmPassword.getPassword());

        // Check empty fields
        boolean emptyFields = firstName.trim().equals("") || lastName.trim().equals("")
                || username.trim().equals("") || password.trim().equals("");

        if (!emptyFields) {
            // Check username exist
            boolean exist = userRepository.checkUsernameExist(username);

            if (!exist) {
                // check password and confrim password match 
                boolean match = password.equals(confirmPassword);

                if (match) {
                    // Insert this new user to database
                    userRepository.insertNewUser(firstName, lastName, username, password);
                    // Implement method to set all field in StartGame form
                    startGameForm.innitialiseStartGameForm(username);
                    // Go to StartGame form
                    startGameForm.setVisible(true);
                    startGameForm.pack();
                    startGameForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Password and Confirm password don't match! Please input again",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username is chosen by another person! Please choose different one",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //If there is empty fields: Show message, input again
            JOptionPane.showMessageDialog(this, "You must input all fields",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton_CreateAccount_SignUpMouseClicked

    private void jLabel_SignUp_BackToFirstPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SignUp_BackToFirstPageMouseClicked
        // Go to Firstpage form
        HomePage fp = new HomePage();
        fp.setVisible(true);
        fp.pack();
        fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel_SignUp_BackToFirstPageMouseClicked

    private void jTextField_SignUp_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SignUp_LoginMouseClicked
        // Go to SignIn form
        SignInForm si = new SignInForm();
        si.setVisible(true);
        si.pack();
        si.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jTextField_SignUp_LoginMouseClicked

    private void jTextField_SignUp_LoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SignUp_LoginMouseEntered
        jTextField_SignUp_Login.setForeground(Color.RED); // Change text color to red on mouse enter
    }//GEN-LAST:event_jTextField_SignUp_LoginMouseEntered

    private void jTextField_SignUp_LoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SignUp_LoginMouseExited
        jTextField_SignUp_Login.setForeground(Color.BLACK); // Restore the original text color on mouse exit
    }//GEN-LAST:event_jTextField_SignUp_LoginMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_CreateAccount_SignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_SignUp_BackToFirstPage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_SignUp_ConfirmPassword;
    private javax.swing.JPasswordField jPasswordField_SignUp_Password;
    private javax.swing.JTextField jTextField_SignUp_FirstName;
    private javax.swing.JTextField jTextField_SignUp_LastName;
    private javax.swing.JLabel jTextField_SignUp_Login;
    private javax.swing.JTextField jTextField_SignUp_Username;
    // End of variables declaration//GEN-END:variables
}
