/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 64273
 */
public class QuizzRepositoryTest {
    private QuizzRepository quizzRepositoryTest;
    HashMap<String, Question> questionMap = new HashMap<>();
    
    public QuizzRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        quizzRepositoryTest = new QuizzRepository();
        questionMap.put("Q00001", new Question("Q00001", "What is the original country of pizza?", "Food", "Italy"));
        questionMap.put("Q00002", new Question("Q00002", "Which country is Pad Thai from?", "Food", "ThaiLand"));
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of checkUserAnswer method, of class QuizzRepository.
     * Test case: the answer is correct
     */
    @Test
    public void testCheckUserAnswerCorrect() {
        System.out.println("CheckUserAnswer: case correct answer");
        String userAnswer = "Italy";
        String questionID = "Q00001";
        boolean expResult = true;
        boolean result = quizzRepositoryTest.checkUserAnswer(userAnswer, questionID, questionMap);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkUserAnswer method, of class QuizzRepository.
     * Test case: the answer is correct
     */
    @Test
    public void testCheckUserAnswerInCorrect() {
        System.out.println("CheckUserAnswer: case incorrect answer");
        String userAnswer = "France";
        String questionID = "Q00002";
        boolean expResult = false;
        boolean result = quizzRepositoryTest.checkUserAnswer(userAnswer, questionID, questionMap);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkUserAnswer method, of class QuizzRepository.
     * Test case: test the method all UPPERCASE: the answer is correct 
     */
    @Test
    public void testCheckUserAnswerCorrectIgnoreCase() {
        System.out.println("CheckUserAnswer: case correct answer, Ignorecase");
        String userAnswer = "ITALY";
        String questionID = "Q00001";
        boolean expResult = true;
        boolean result = quizzRepositoryTest.checkUserAnswer(userAnswer, questionID, questionMap);
        assertEquals(expResult, result);
    }
    
}
