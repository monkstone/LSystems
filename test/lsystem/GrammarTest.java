/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem;

import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Martin Prout
 */
public class GrammarTest {

    Grammar instance;

    /**
     *
     */
    public GrammarTest() {
        instance = new SimpleGrammar("F-F-F-F");
    }

    /**
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of addRule method, of class Grammar.
     */
    @Test
    public void testAddRule() {
        System.out.println("addRule");
        char premise = 'F';
        String rule = "FFFF";
        instance.addRule(premise, rule);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRule method, of class Grammar.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        char premise = 'F';
        String rule = "FFFF";
        instance.addRule(premise, rule);
        String expResult = "FFFF";
        String result = instance.getRule(premise);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    /**
     * Test of hasKey method, of class Grammar.
     */
    @Test
    public void testHasKey() {
        System.out.println("hasKey");
        char premise = 'F';
        String rule = "FFFF";
        instance.addRule(premise, rule);
        boolean expResult = true;
        boolean result = instance.hasKey(premise);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }








    /**
     * Test of version method, of class Grammar.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        String expResult = "1.0.0";
        String result = instance.version();
        assertEquals(expResult, result);
    }
}
