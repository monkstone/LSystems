/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;

import lsystem.turtle.Turtle;
import lsystem.turtle.TurtleInterface;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

/**
 *
*
 */
public class TurtleTest {
    TurtleInterface instance;
    /**
     *
     */
    public TurtleTest() {
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
        instance = new Turtle(0.0f, 0.0f, 0.0f);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }


    /**
     * Test of Constructor  class Turtle.
     */
    @Test
    public void testConstructor() {
        System.out.println("constructor");

        assertNotNull(instance);
        
    }

        /**
     * Test of Constructor  class Turtle.
     */
    @Test
    public void testCopyConstructor() {
        System.out.println("copy constructor");
        TurtleInterface copy = new Turtle((Turtle)instance);
        assertNotNull(copy);

    }

    /**
     * Test of getY method, of class Turtle.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        float expResult = 0.0F;
        float result = instance.getY();
        assertEquals(expResult, result, 0.0f);

    }

    /**
     * Test of getTheta method, of class Turtle.
     */
    @Test
    public void testGetTheta() {
        System.out.println("getTheta");
        float expResult = 0.0F;
        float result = instance.getTheta();
        assertEquals(expResult, result, 0.0f);

    }

    /**
     * Test clone method, of class Turtle.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        TurtleInterface expResult = new Turtle(1, 1, 1);
        Object result = expResult.clone();
        assertEquals(expResult.getTheta(), ((TurtleInterface)result).getTheta(), 1.0f);

    }

}