
/**
 * Creates mountain objects and stores and retrives info on them including name and height.
 * 
 * @author Peter Triggs 
 * @version 1.0
 */
public class Mountain
{
    // instance variables
    private int height;
    private String name;

    /**
     * Constructor for objects of class Mountain.
     * 
     * @return Mountain object.
     * @param firstHeight - the height of the mountian in meters.
     * @param firstName - the name of the mountain.
     */
    public Mountain(int firstHeight, String firstName)
    {
        // initialise instance variables
        height = firstHeight;
        name = firstName;
    }

    /**
     * Accessor for height.
     * 
     * @return integer - height of the mountain. 
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * Accessor for name
     * 
     * @return  String - name of the mountain.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Setter for height
     * 
     * @param newHeight - assigns a new value for the height of a mountain.
     */
    public void setHeight(int newHeight)
    {
        height = newHeight;
    }
    
    /**
     * Setter for name
     * 
     * @param newName - assigns a new value for the name of the mountain.
     */
    public void setName (String newName)
    {
        name = newName;
    }
}