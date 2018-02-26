

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class ClubTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClubTest
{
    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
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
     * Tests that items are added to the arraylist.
     */
    @Test
    public void addItemClimber()
    {
        Climber climber1 = new Climber("David", 23, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        assert (club1.getClimbers().contains(climber1));
    }
    
    /**
     * Standard output test for the highest mountain climbed by all climbers.
     */
    @Test
    public void getClimberMaxStandard()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain5 = new Mountain(6934, "K7");
        Mountain mountain6 = new Mountain(5264, "Maipo");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber3.addMountain(mountain3);
        climber3.addMountain(mountain4);
        climber2.addMountain(mountain5);
        climber1.addMountain(mountain6);
        assert (club1.getClimberMax().equals(mountain5));
    }
    
    /**
     * Tests if there are no climbers in the climbers arraylist.
     */
    @Test
    public void getClimberMaxEmpty()
    {
        Club club1 = new Club();
        assertNull(club1.getClimberMax());
    }
    
    /**
     * Test if some climbers have no associated mountains a highest mountain is still returned.
     */
    @Test
    public void getClimberMaxZeroHeight()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain5 = new Mountain(6934, "K7");
        Mountain mountain6 = new Mountain(5264, "Maipo");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber2.addMountain(mountain3);
        climber1.addMountain(mountain4);
        climber2.addMountain(mountain5);
        climber1.addMountain(mountain6);
        assert (club1.getClimberMax().equals(mountain5));
    }
    
    /**
     * Standard output test for getting the maximum average height by a climber.
     */
    @Test
    public void getMaxAverageStandard()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain5 = new Mountain(6934, "K7");
        Mountain mountain6 = new Mountain(5264, "Maipo");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber3.addMountain(mountain3);
        climber3.addMountain(mountain4);
        climber2.addMountain(mountain5);
        climber1.addMountain(mountain6);
        assert (club1.getMaxAverage().contains(climber2));
    }
    
    /**
     * Tests if there are no climbers in the climbers arraylist.
     */
    @Test
    public void getMaxAverageEmpty()
    {
        Club club1 = new Club();
        assert (club1.getMaxAverage().isEmpty());
    }
    
    /**
     * Test if some climbers have no associated mountains a highest average is still returned.
     */
    @Test
    public void getMaxAverageZeroHeight()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain5 = new Mountain(6934, "K7");
        Mountain mountain6 = new Mountain(5264, "Maipo");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber2.addMountain(mountain3);
        climber1.addMountain(mountain4);
        climber2.addMountain(mountain5);
        climber1.addMountain(mountain6);
        assert (club1.getMaxAverage().contains(climber1));
    }
    
    /**
     * Test if two climbers have same average they are both returned.
     */
    @Test
    public void getMaxAverageTwo()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain4 = new Mountain(6934, "K7");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain3);
        climber2.addMountain(mountain3);
        climber3.addMountain(mountain1);
        climber1.addMountain(mountain4);
        climber2.addMountain(mountain4);
        climber3.addMountain(mountain2);
        ArrayList<Climber> testClimber = new ArrayList<Climber>();
        testClimber.add(climber1);
        testClimber.add(climber2);
        assert (club1.getMaxAverage().containsAll(testClimber));
    }
    
    /**
     * Standard output test for getting the list of mountains above a specified height for all climbers.
     */
    @Test
    public void getCombinedAboveStandard()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain5 = new Mountain(6934, "K7");
        Mountain mountain6 = new Mountain(5264, "Maipo");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber3.addMountain(mountain3);
        climber3.addMountain(mountain4);
        climber2.addMountain(mountain5);
        climber1.addMountain(mountain6);
        ArrayList <Mountain> testMount = new ArrayList<Mountain>();
        testMount.add(mountain6);
        testMount.add(mountain5);
        testMount.add(mountain4);
        assert (club1.getCombinedAboveMountList(5000).containsAll(testMount));
    }
    
    /**
     * Tests if there are no climbers in the climbers arraylist.
     */
    @Test
    public void getCombinedAboveEmpty()
    {
        Club club1 = new Club();
        assert (club1.getCombinedAboveMountList(5000).isEmpty());
    }
    
    /**
     * Test if some climbers have no associated mountains a list is still returned.
     */
    @Test
    public void getCombinedAboveNoMount()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain5 = new Mountain(6934, "K7");
        Mountain mountain6 = new Mountain(5264, "Maipo");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber2.addMountain(mountain3);
        climber1.addMountain(mountain4);
        climber2.addMountain(mountain5);
        climber1.addMountain(mountain6);
        ArrayList <Mountain> testMount = new ArrayList<Mountain>();
        testMount.add(mountain6);
        testMount.add(mountain5);
        testMount.add(mountain4);
        assert (club1.getCombinedAboveMountList(5000).containsAll(testMount));
    }
    
    /**
     * Test for mountains above a specified height, all mountains are lower.
     */
    @Test
    public void getCombinedAboveZeroReturn()
    {
        Mountain mountain1 = new Mountain(3242, "Williams Peak");
        Mountain mountain2 = new Mountain(4013, "Cloud Peak");
        Mountain mountain3 = new Mountain(2900, "Rising Wolf Mountain");
        Mountain mountain4 = new Mountain(5664, "Pichu Pichu");
        Mountain mountain5 = new Mountain(6934, "K7");
        Mountain mountain6 = new Mountain(5264, "Maipo");
        Climber climber1 = new Climber("David", 23, "Male");
        Climber climber2 = new Climber("Sue", 43, "Female");
        Climber climber3 = new Climber("Jack", 55, "Male");
        Club club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber2.addMountain(mountain3);
        climber1.addMountain(mountain4);
        climber2.addMountain(mountain5);
        climber1.addMountain(mountain6);
        ArrayList <Mountain> testMount = new ArrayList<Mountain>();
        testMount.add(mountain6);
        testMount.add(mountain5);
        testMount.add(mountain4);
        assert (club1.getCombinedAboveMountList(7000).isEmpty());
    }
}
