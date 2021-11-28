/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem.util;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



/**
 *
* 
 */
public class LUTTest {

    /**
     * 
     */
    public LUTTest() {
    }

    /**
     * 
     * @throws Exception
     */
    @BeforeAll
    public static void setUpClass() throws Exception {
       LUT.initialize();
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
     * Test of sin method, of class LUT.
     */
    @Test
    public void testSin0() {
        System.out.println("sin0");
        int theta = 0;
        float expResult = (float)Math.sin(Math.toRadians(theta));
        float result = LUT.sin(theta);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of cos method, of class LUT.
     */
    @Test
    public void testSinMinus36() {
        System.out.println("minusSine 36f");
        float theta = -36.0f;
        float expResult = (float)Math.sin(Math.toRadians(theta));
        float result = LUT.sin(theta);
        assertEquals(expResult, result, 0.001);
    }
        /**
     * Test of sin method, of class LUT.
     */
    @Test
    public void testSin320() {
        System.out.println("sin320f");
        float theta = 320.0f;
        float expResult = (float)Math.sin(Math.toRadians(theta));
        float result = LUT.sin(theta);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of cos method, of class LUT.
     */
    @Test
    public void testSin260() {
        System.out.println("sin260");
        int theta = 260;
        float expResult = (float)Math.sin(Math.toRadians(theta));
        float result = LUT.sin(theta);
        assertEquals(expResult, result, 0.001);
    }
    
        /**
     * Test of sin method, of class LUT.
     */
    @Test
    public void testCos0() {
        System.out.println("Cos0");
        int theta = 0;
        float expResult = (float)Math.cos(Math.toRadians(theta));
        float result = LUT.cos(theta);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of cos method, of class LUT.
     */
    @Test
    public void testCos10() {
        System.out.println("Cos10");
        int theta = 10;
        float expResult = (float)Math.cos(Math.toRadians(theta));
        float result = LUT.cos(theta);
        assertEquals(expResult, result, 0.001);
    }
        /**
     * Test of Cos method, of class LUT.
     */
    @Test
    public void testCosMinus20() {
        System.out.println("Cos-20");
        int theta = 340;
        float expResult = (float)Math.cos(Math.toRadians(theta));
        float result = LUT.cos(theta);
        assertEquals(expResult, result, 0.001);
    }
    
        /**
     * Test of cos method, of class LUT.
     */
    @Test
    public void testCos110() {
        System.out.println("cos110");
        int theta = 110;
        float expResult = (float)Math.sin(Math.toRadians(theta));
        float result = LUT.sin(theta);
        assertEquals(expResult, result, 0.001);
    }
        /**
     * Test of sin method, of class LUT.
     */
    @Test
    public void testCos320() {
        System.out.println("cos320");
        int theta = 320;
        float expResult = (float)Math.sin(Math.toRadians(theta));
        float result = LUT.sin(theta);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of cos method, of class LUT.
     */
    @Test
    public void testCos360() {
        System.out.println("Cos360");
        int theta = 360;
        float expResult = (float)Math.cos(Math.toRadians(theta));
        float result = LUT.cos(theta);
        assertEquals(expResult, result, 0.001);
    }
}
