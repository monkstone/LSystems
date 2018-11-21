package lsystem.util;

import static org.junit.Assert.assertEquals;


/**
 *
* 
 */
public class LUT2Test {
    
    /**
     * 
     */
    public LUT2Test() {
    }

    /**
     * 
     * @throws Exception
     */
 
    public static void setUpClass() throws Exception {
        LUT2.initialize();
    }

    /**
     * 
     * @throws Exception
     */
  
    public static void tearDownClass() throws Exception {
    }
    
    /**
     * 
     */
 
    public void setUp() {
        
    }
    
    /**
     * 
     */
  
    public void tearDown() {
    }


    /**
     * Test of sin method, of class LUT2.
     */

    public void testMinusSin() {
        System.out.println("minus sin");
        float thet = -37.5F;
        float expResult = (float)Math.sin(Math.toRadians(thet));
        float result = LUT2.sin(thet);
        assertEquals(expResult, result, 0.01F);
    }

    /**
     * Test of cos method, of class LUT2.
     */
    public void testMinusCos() {
        System.out.println("minus cos");
        float thet = -37.5F;
        float expResult = (float)Math.cos(Math.toRadians(thet));
        float result = LUT2.cos(thet);
        assertEquals(expResult, result, 0.01F);
    }
    
        /**
     * Test of sin method, of class LUT2.
     */

    public void testSin() {
        System.out.println("sin");
        float thet = 90.5F;
        float expResult = (float)Math.sin(Math.toRadians(thet));
        float result = LUT2.sin(thet);
        assertEquals(expResult, result, 0.01F);
    }

    /**
     * Test of cos method, of class LUT2.
     */

    public void testCos() {
        System.out.println("cos");
        float thet = 90.5F;
        float expResult = (float)Math.cos(Math.toRadians(thet));
        float result = LUT2.cos(thet);
        assertEquals(expResult, result, 0.01F);
    }
    
            /**
     * Test of sin method, of class LUT2.
     */

    public void testLargeSin() {
        System.out.println("large sin");
        float thet = 2000.5F;
        float expResult = (float)Math.sin(Math.toRadians(thet));
        float result = LUT2.sin(thet);
        assertEquals(expResult, result, 0.01F);
    }

    /**
     * Test of cos method, of class LUT2.
     */

    public void testLargeCos() {
        System.out.println("large cos");
        float thet = 2000.5F;
        float expResult = (float)Math.cos(Math.toRadians(thet));
        float result = LUT2.cos(thet);
        assertEquals(expResult, result, 0.01F);
    }
      /**
     * Test of sin method, of class LUT.
     */

    public void testLutSinMinus() {
        System.out.println("lutSinMinus");
        float theta = (float)Math.toRadians(-36);
        float expResult = (float)Math.sin(theta);
        float result = LUT2.sinLut(theta);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of sinLut method, of class LUT.
     */

    public void testLutSin() {
        System.out.println("lutSin");
       float theta = (float)Math.toRadians(36);
        float expResult = (float)Math.sin(theta);
        float result = LUT2.sinLut(theta);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of cos method, of class LUT.
     */

    public void testLutCosMinus() {
        System.out.println("lutCosMinus");
       float theta = (float)Math.toRadians(-36);
        float expResult = (float)Math.cos(theta);
        float result = LUT2.cosLut(theta);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of cosLut method, of class LUT.
     */

    public void testLutCos() {
        System.out.println("lutCos");
        float theta = (float)Math.toRadians(36);
        float expResult = (float)Math.cos(theta);
        float result = LUT2.cosLut(theta);
        assertEquals(expResult, result, 0.01);
    }
}
