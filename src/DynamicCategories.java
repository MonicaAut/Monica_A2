/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Group 51 - Monica Luong - ID: 22163241
 */
public class DynamicCategories extends JFrame implements ActionListener {

    private QuizzForm quizzForm = new QuizzForm();
    private String username;
    private StartGameForm startGameForm = new StartGameForm();
    private CategoryRepository categoryRepository = new CategoryRepository();
    private JLabel name;
    private String[] categories = categoryRepository.getAllCategories();
    private JButton[] categoryButtons = new JButton[categories.length];
    private JButton restartGame;

    public DynamicCategories() {
        //initialize all the components
        initComponents();
        initPanels();
        initActionListener();
        // Move the frame to the top-left corner of the screen
        this.setLocation(0, 0);
    }

    private void initComponents() {
        name = new JLabel("Choose a category to play");
        // Create a custom Font object with "Segoe UI", plain style, and size 24
        Font customFont = new Font("Segoe UI BLACK", Font.PLAIN, 24);

        // Apply the custom Font to the JLabel
        name.setFont(customFont);

        // Create an array of all category buttons
        for (int i = 0; i < categories.length; i++) {
            categoryButtons[i] = new JButton(categories[i]);
        }

        restartGame = new JButton("Restart Game");

        // Set frame
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // Make the frame not resizable
        this.setResizable(false);
    }

    private void initPanels() {
        // North Panel
        JPanel northPanel = new JPanel();
        northPanel.add(name);
        this.add(northPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();

        for (int i = 0; i < categoryButtons.length; i++) {
            centerPanel.add(categoryButtons[i]);
        }
        this.add(centerPanel, BorderLayout.CENTER);

        // South Panel
        JPanel southPanel = new JPanel();
        southPanel.add(restartGame);
        this.add(southPanel, BorderLayout.SOUTH);

        // Set the preferred size of the frame
        this.setPreferredSize(new Dimension(400, 400));
    }

    // Initializes action listeners for the category buttons and the "Restart Game" button.
    private void initActionListener() {
        for (int i = 0; i < categoryButtons.length; i++) {
            this.categoryButtons[i].addActionListener(this);
        }

        this.restartGame.addActionListener(this);
    }

    /**
     * Invoked when a button is clicked in the user interface. 
     * Handles button click events for category buttons and the "Restart Game" button.
     *
     * @param e The ActionEvent representing the button click event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Click events for category buttons
        for (int i = 0; i < categoryButtons.length; i++) {
            if (e.getSource() == this.categoryButtons[i]) {
                // Set the question collection only contains food question
                quizzForm.setQuestionsForChosenCategory(categories[i]);
                // Generate the firstQuestion, display to the screen of quizzForm
                quizzForm.setQuestion();
                //Pass username to Quizz form
                quizzForm.setUsername(username);
                // Go to Quizz form
                quizzForm.setUsername(username);
                quizzForm.setVisible(true);
                quizzForm.pack();
                quizzForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
        }
        
        // Click events for Restar game button
        if (e.getSource() == this.restartGame) {
            System.out.println("Restart");
            // Implement method to set all field in StartGame form
            startGameForm.innitialiseStartGameForm(username);
            // Go to Start Game form
            startGameForm.setVisible(true);
            startGameForm.pack();
            startGameForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
    }

    //Set the username value
    public void setUsername(String username) {
        this.username = username;
    }
}
