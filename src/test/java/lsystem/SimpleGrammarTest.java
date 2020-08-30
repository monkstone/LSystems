/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 *
*
 */
public class SimpleGrammarTest {

    /**
     *
     */
    public SimpleGrammarTest() {
    }

    /**
     *
     * @throws Exception
     */
    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     */
    @BeforeAll
    public void setUp() {
    }

    /**
     *
     */
    @AfterAll
    public void tearDown() {
    }

    /**
     * Test of addRule method, of class SimpleGrammar.
     */
    @Test
    public void testAddRule_char_String() {
        System.out.println("addRule");
        char premise = 'F';
        String rule = "F-F-F-F";
        Grammar instance = new SimpleGrammar("F");
        instance.addRule(premise, rule);
    }

    /**
     * Test of addRule method, of class SimpleGrammar.
     */
    @Test 
    public void testAddRule_3args() {
        System.out.println("addRule");
        char premise = ' ';
        String rule = "";
        float weight = 0.0F;
        Grammar instance = new SimpleGrammar("F");
        instance.addRule(premise, rule, weight);
    }

    /**
     * Test of getRule method, of class SimpleGrammar.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        char premise = 'F';
        Grammar instance = new SimpleGrammar("F");
        String rule = "F-F-F-F";
        instance.addRule(premise, rule);
        String expResult = "F-F-F-F";
        String result = instance.getRule(premise);
        assertEquals(expResult, result);
    }






    /**
     * Test of version method, of class SimpleGrammar.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        Grammar instance = new SimpleGrammar("FF");
        String expResult = "2.0.0";
        String result = instance.version();
        assertEquals(expResult, result);
    }

}
