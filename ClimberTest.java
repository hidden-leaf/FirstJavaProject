

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class ClimberTest.
 *
 * @author  Peter Triggs
 * @version 1.0
 */
public class ClimberTest
{    
    /**
     * Default constructor for test class ClimberTest
     */
    public ClimberTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Standard output test for finding the highest mountain for a climber.
     */
    @Test
    public void getHighestStandard()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Climber climber1 = new Climber("David", 23, "Male");
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        assertEquals(mountain2, climber1.getMax());
    }
     
    /**
     * Test that a result is return if only one element is in the arraylist.
     */
    @Test
    public void getHighestOne()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Climber climber1 = new Climber("David", 23, "Male");
        climber1.addMountain(mountain1);
        assertEquals(mountain1, climber1.getMax());
    }
    
    /**
     * Tests that null is returned when the mountains arraylist is empty.
     */
    @Test
    public void getHighestNull()
    {
        Climber climber1 = new Climber("David", 23, "Male");
        assertNull(climber1.getMax());
    }
    
    /**
    *  Standard output test for finding the average height of a climbers mountains.
    */
    @Test
    public void getAvStandard()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Climber climber1 = new Climber("David", 23, "Male");
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        assertEquals(3954.75, climber1.getAverage(), 0.1);
    }
    
    /**
     * Tests that zero is returned if the arraylist is empty.
     */
    @Test
    public void getAvNull()
    {
        Climber climber1 = new Climber("David", 23, "Male");
        assertEquals(0, climber1.getAverage(), 0.1);
    }
    
    /**
     * Tests that items are added to the arraylist.
     */
    @Test
    public void addItemMountain()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Climber climber1 = new Climber("David", 23, "Male");
        climber1.addMountain(mountain1);
        assert (climber1.getMountain().contains(mountain1));
    }
        
        
    /**
     * Standard output test for getting the mountains above a specified height.
     */
    @Test
    public void getAboveStandard()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Climber climber1 = new Climber("David", 23, "Male");
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        ArrayList <Mountain> testMount = new ArrayList<Mountain>();
        testMount.add(mountain2);
        testMount.add(mountain4);
        assert (climber1.getAboveMountList(3500).containsAll(testMount));
    }
    
    /**
     * Test for mountains above a specified height, all mountains are lower.
     */
    @Test
    public void getAboveReturnNone()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Climber climber1 = new Climber("David", 23, "Male");
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        assert (climber1.getAboveMountList(6000).isEmpty());
    }
    
    /**
     * Test for mountains above a specified height, mountains list is empty.
     */
    @Test
    public void getAboveNull()
    {
        Climber climber1 = new Climber("David", 23, "Male");
        assertNull(climber1.getAboveMountList(3500));
    }
        
        
    
}



