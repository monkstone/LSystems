/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem.collection.csrule;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Very limited context rule tests
*
 */
public class ContextRuleTest {

    /**
     *
     */
    public ContextRuleTest() {
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
     * Test of getContextChar method, of class ContextRule.
     */
    @Test
    public void testGetContextChar() {
        System.out.println("getContextChar");
        ContextRule instance = new ContextRule("a<b");
        char expResult = 'a';
        char result = instance.getContextChar();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKeyHash method, of class ContextRule.
     */
    @Test
    public void testGetKeyHash() {
        System.out.println("getKeyHash");
        ContextRule instance = new ContextRule("a<b");
        String expResult = "a<b";
        String result = instance.getKeyHash();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPremis method, of class ContextRule.
     */
    @Test
    public void testGetPremis() {
        System.out.println("getPremis");
        ContextRule instance = new ContextRule("a<b");
        char expResult = 'b';
        char result = instance.getPremis();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIndex method, of class ContextRule.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        ContextRule instance = new ContextRule("a<b");
        int expResult = -1;
        int result = instance.getIndex();
        assertEquals(expResult, result);
    }

}
