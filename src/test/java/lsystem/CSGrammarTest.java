/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
*
 */
public class CSGrammarTest {
    CSGrammar instance;
    /**
     * 
     */
    public CSGrammarTest() {
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
        instance = new CSGrammar("FFF");
        instance.setIgnoreList("[]");
    }

    /**
     * 
     */
    @AfterAll
    public void tearDown() {
    }

    /**
     * Test of addRule method, of class CSGrammar.
     */
    @Test
    public void testAddRule_char_String() {
        System.out.println("addRule");
        char premise = 'F';
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule(premise, rule);
    }

    /**
     * Test of addRule method, of class CSGrammar.
     */
    @Test
    public void testAddRule_String_String() {
        System.out.println("addRule");
        instance = new CSGrammar("baaaaa");
        String premise = "b<a";
        String rule = "b";
        instance.addRule(premise, rule);
        assert(instance.hasKey('a'));
//        String expResult = "b";
//        StringBuilder result = instance.getRule('a', "baaaaa", 1);
//        assertEquals(expResult, result.toString());
    }


    /**
     * Test of getRule method, of class CSGrammar.
     */
    @Test
    public void testGetRule() {
        System.out.println("getRule");
        char premise = 'F';
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule(premise, rule);
        int count = 0;
        String production = "F";
        String expResult = "F[-EF[3&A]]E[+F[3^A]]";
        StringBuilder result = instance.getRule(premise, production, count);
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of hasKey method, of class CSGrammar.
     */
    @Test
    public void testHasKey() {
        System.out.println("hasKey");
        char premise = 'F';
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule(premise, rule);
        boolean expResult = true;
        boolean result = instance.hasKey(premise);
        assertEquals(expResult, result);
    }

    /**
     * Test of setIgnoreList method, of class CSGrammar.
     */
    @Test
    public void testSetIgnoreList_String() {
        System.out.println("setIgnoreList");
        String str = "[]+-^&3";
        instance.setIgnoreList(str);
    }

    /**
     * Test of setIgnoreList method, of class CSGrammar.
     */
//    @Test
//    @SuppressWarnings("empty-statement")
//    public void testSetIgnoreList_charArr() {
//        System.out.println("setIgnoreList");
//        char[] str = {'[',']','+','-','^','&','3'};
//        instance.setIgnoreList(str.clone());
//    }



    /**
     * Test of getIterator method, of class CSGrammar.
     */
    @Test
    public void testGetIterator() {
        System.out.println("getIterator");
        CharacterIterator expResult = new StringCharacterIterator( "FFF") ;
        CharacterIterator result = instance.getIterator();
        assertEquals(expResult, result);
    }

    /**
     * Test of dispose method, of class CSGrammar.
     */
    @Test
    public void testDispose() {
        System.out.println("dispose");
        instance.dispose();
    }

  
    /**
     * Test of dispose method, of class CSGrammar.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String str = "[]+-^&3";
        instance.setIgnoreList(str);
        String rule = "F[-EF[3&A]]E[+F[3^A]]";
        instance.addRule('F', rule);
        String premise2 = "F<E";
        String rule2 = "F[&F[3+A]][^F[3-A]]";
        instance.addRule(premise2, rule2);
        System.out.print(instance.toString());
    }
    /**
     * Test of version method, of class CSGrammar.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        String expResult = "2.0.0";
        String result = instance.version();
        assertEquals(expResult, result);
    }

}