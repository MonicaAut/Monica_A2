/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

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
public class UserRepositoryTest {

    private UserRepository userRepositoryTest;

    public UserRepositoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        userRepositoryTest = new UserRepository();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkUsernameExist method, of class UserRepository. 
     * Test case: can find the username in the database
     */
    @Test
    public void testCheckUsernameExistTrue() {
        System.out.println("checkUsernameExist: case true");
        String username = "TaylorNo1";
        boolean expResult = true;
        boolean result = userRepositoryTest.checkUsernameExist(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUsernameExist method, of class UserRepository. Test case:
     * Test case: the username is not exist in the database
     */
    @Test
    public void testCheckUsernameExistFalse() {
        System.out.println("CheckUsernameExist: case false");
        String username = "Taylor";
        boolean expResult = false;
        boolean result = userRepositoryTest.checkUsernameExist(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUsernamePasswordMatch method, of class UserRepository. case:
     * Username and password match
     */
    @Test
    public void testCheckUsernamePasswordMatchTrue() {
        System.out.println("CheckUsernamePasswordMatch method: case true (usename and password match with data in the database)");
        String username = "TaylorNo1";
        String password = "123";
        boolean expResult = true;
        boolean result = userRepositoryTest.checkUsernamePasswordMatch(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkUsernamePasswordMatch method, of class UserRepository. case:
     * Username and password match
     */
    @Test
    public void testCheckUsernamePasswordMatchFalse() {
        System.out.println("CheckUsernamePasswordMatch method: case false (usename and password don't match with data in the database)");
        String username = "TaylorNo1";
        String password = "abc";
        boolean expResult = false;
        boolean result = userRepositoryTest.checkUsernamePasswordMatch(username, password);
        assertEquals(expResult, result);
    }

}
