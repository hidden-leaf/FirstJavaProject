

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClubStatsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClubStatsTest
{
    /**
     * Default constructor for test class ClubStatsTest
     */
    public ClubStatsTest()
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
     * Test searchClimbers if there are no climbers in the arraylist.
     */
    @Test
    public void searchClimbersNull()
    {
        ClubStats myClubStats = new ClubStats();
        assertNull(myClubStats.searchClimbers("David"));
    }
    
}
