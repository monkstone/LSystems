/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem.collection;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




/**
 *
*
 */
public class CSListTest {

    /**
     * 
     */
    public CSListTest() {
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
     * Test of setIgnoreList method, of class CSList.
     */
    @Test
    public void testSetIgnoreList_String() {
        System.out.println("setIgnoreList");
        String str = "{}><";
        CSList instance = new CSList();
        instance.setIgnoreList(str);
    }

    /**
     * Test of setIgnoreList method, of class CSList.
     */
//    @Test
//    public void testSetIgnoreList_charArr() {
//        System.out.println("setIgnoreList");
//        char[] ignore = {']','['};
//        CSList instance = new CSList();
//        instance.setIgnoreList(ignore);
//    }

    /**
     * Test of isIgnored method, of class CSList.
     */
    @Test
    public void testIsIgnored() {
        System.out.println("isIgnored");
        char prod = ' ';
        CSList instance = new CSList();
        boolean expResult = false;
        boolean result = instance.isIgnored(prod);
        assertEquals(expResult, result);
    }

    /**
     * Test of addRule method, of class CSList.
     */
    @Test
    public void testAddRule_String_String() {
        System.out.println("addRule");
        String pre = "a<b";
        String rule = "a";
        CSList instance = new CSList();
        instance.addRule(pre, rule);
    }

    /**
     * Test of addRule method, of class CSList.
     */
    @Test
    public void testAddRule_char_String() {
        System.out.println("addRule");
        char pre = 'a';
        String rule = "b";
        CSList instance = new CSList();
        instance.addRule(pre, rule);
    }

   

    /**
     * Test of getCSRule method, of class CSList.
     */
    @Test
    public void testGetCSRule() {
        System.out.println("getCSRule");
        char pre = 'a';
        String production = "baaaaa";
        int index = 1;
        CSList instance = new CSList();
        instance.addRule("b<a", "b");
        instance.addRule('b', "a");
        String expResult = "b";
        StringBuilder result = instance.getCSRule(pre, production, index);
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of hasRule method, of class CSList.
     */
    @Test
    public void testHasRule() {
        System.out.println("hasRule");
        char pre = 'z';
        CSList instance = new CSList();
        instance.addRule('q', "SSSSSSSSSSS");
        boolean expResult = false;
        boolean result = instance.hasRule(pre);
        assertEquals(expResult, result);
    }

    /**
     * Test of testToStringBuilder method, of class CSList.
     */
    @Test
    public void testToStringBuilder() {
        System.out.println("toStringBuilder");
        CSList instance = new CSList();
        instance.addRule("b<a", "b");
        instance.addRule('b', "a");
        instance.setIgnoreList("[]1234");
        System.out.print(instance.toStringBuilder());
    }

    /**
     * Test of clear method, of class CSList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CSList instance = new CSList();
        instance.clear();
    }

}