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
public class StochasticGrammarTest {

    Grammar instance;

    /**
     *
     */
    public StochasticGrammarTest() {
        instance = new StochasticGrammar("F");
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
     * Test of addRule method, of class StochasticGrammar.
     */
    @Test
    public void testAddRule_char_String() {
        System.out.println("addRule no weighting");
        char premise = 'F';
        String rule = "F-F-F";
        instance.addRule(premise, rule);
    }

    /**
     * Test of addRule method, of class StochasticGrammar.
     */
    @Test
    public void testAddRule_3args() {
        System.out.println("addRules with weighting");
        char premise = 'X';
        String rule = "FX-FX";
        float weight = 1.0F;
        instance.addRule(premise, rule, weight);
        String rule1 = "FX-FX";
        float weight1 = 1.0F;
        instance.addRule(premise, rule1, weight1);
    }

    /**
     * Test of getRule method, of class StochasticGrammar.
     */
    @Test
    public void testGetRule() {
        String expResult = "FX-FX";
        char premise = 'X';
        String rule = "FX-FX";
        float weight = 1.0F;
        instance.addRule(premise, rule, weight);
        String rule1 = "FF-FF";
        float weight1 = 1.0F;
        instance.addRule(premise, rule1, weight1);
        String result = instance.getRule('X');
        assertEquals(expResult, result);
    }



    /**
     * Test of version method, of class StochasticGrammar.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        String expResult = "2.0.0";
        String result = instance.version();
        assertEquals(expResult, result);
    }
}
