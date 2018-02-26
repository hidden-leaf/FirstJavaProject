
/**
 * Stores and retrieves info about a climber (name, age and gender) and the mountains they have climbed in an arraylist. 
 * Including the average height of all the mountains climbed, the highest mountain climbed and an arraylist of all the 
 * mountains above a specified height.
 * 
 * @author Peter Triggs
 * @version 1.0
 */

import java.util.ArrayList;

public class Climber
{
    // instance variables 
    private String name;
    private int age;
    private String gender;
    private ArrayList<Mountain> mountains;
    

    /**
     * Constructor for objects of class Climber.
     * 
     * @return Climber object.
     * @param firstAge - the age of the climber in years.
     * @param firstName - the name of the climber.
     * @param firstGender - the gender of the climber.
     */
    public Climber(String firstName, int firstAge, String firstGender)
    {
        // initialise instance variables
        name = firstName;
        age = firstAge;
        gender = firstGender;
        mountains = new ArrayList<Mountain>();
    }

    /**
     * Accessor for the climber's name.
     * 
     * @return  String - name of the climber.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Accessor for the climber's age.
     * 
     * @return integer - age of the climber.
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Accessor for the gender of the climber.
     * 
     * @return String - gender of the climber
     */
    public String getGender()
    {
        return gender;
    }
    
    /**
     * Accessor for the list of mountains a climber has climbed.
     * 
     * @return ArrayList of type Mountain. 
     */
    public ArrayList<Mountain> getMountain()
    {
        return mountains;
    }
    
    /**
     *  Setter for climber's name.
     *  
     *  @param newName - name for the climber.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Setter for climber's age.
     * 
     * @param newAge - age for the climber.
     */
    public void setAge(int newAge)
    {
        age = newAge;
    }
    
    /**
     * Setter for the climber's gender.
     * 
     * @param newGender - gender for the climber.
     */
    public void setGender(String newGender)
    {
        gender = newGender;
    }
    
    /**
     * Add to the climber's arraylist of moutains.
     * 
     * @param newMountain - the Mountain object to be added to the arraylist (mountians). 
     */
    public void addMountain(Mountain newMountain)
    {
        mountains.add(newMountain);
    }
    
    /**
     * Parses through the climbers arraylist of mountains and compares the heights. If a mountain is the highest so far
     * the previous highest is disgarded and replaced by it. If the arraylist is empty null is returned.
     * 
     * @return Mountain -  the mountain with the highest value for height.
     */
    public Mountain getMax()
    {
        int highest = 0; // intialise the local variables
        Mountain topMountain = null;
            if (mountains.isEmpty()){
               return topMountain;
            }
            else{
                for (Mountain i : mountains) { // loop through the mountains list
                    int height = i.getHeight();
                    if (height > highest) { // compare each element to the highest so far
                        highest = height; // assign new highest to local variable for loop
                        topMountain = i; // assign new highest to return variable
                    }
            }
        }
       return topMountain;
    }
    
    /**
     * Retrieves all the heights of the mountains in the arraylist and adds them together. The average height is then
     * calculated by dividing the total by the size of the arraylist. If the arraylist is empty zero is returned.
     * 
     * @return double - average height of all the mountains in the arraylist.
     */
    public double getAverage()
    {
        double average = 0;
        if (mountains.isEmpty()){
               return average;
            }
        else{
            double total = 0;
            for (Mountain i : mountains) {
                int height = i.getHeight();
                total = total + height;
            }
            average = total / mountains.size();
        }
        
        return average;
        
    }
    
    /**
     * Tests the height of all the mountains in the arraylist against a given value. If the mountains value is greater it
     * is placed in a new arraylist (above).
     * 
     * @return ArrayList of type Mountain.
     * @param limit - the test height.
     */
    public ArrayList<Mountain> getAboveMountList(int limit)
    {
       ArrayList<Mountain> above = new ArrayList<Mountain>();
       if (mountains.isEmpty()){
           above = null;
           return above;
            }
       else{
            for (Mountain i : mountains) { // loop through the mountains list
                int height = i.getHeight();
                if (height > limit) { // compare each element to the limit height
                    above.add(i); // assign the mountain to the new array
                }
            }
        }
        return above;
    }
}
