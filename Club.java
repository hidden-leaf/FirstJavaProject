
/**
 * Stores and retrieves info about all the climbers in the club in an arraylist. Compares the mountain arraylists of
 * all the climbers to give the highest mountain climbed by any climber, the climber with the highest average mountain 
 * height and all the mountains climbed by any climber above a specified height.
 * 
 * @author Peter Triggs
 * @version 1.0
 */
import java.util.ArrayList;

public class Club
{
    // instance variables 
    private ArrayList<Climber> climbers;

    /**
     * Constructor for objects of class Club.
     */
    public Club()
    {
        // initialise instance variables
        climbers = new ArrayList<Climber>();
    }
    
    /**
     * Accessor for the climbers array.
     * 
     * @return ArrayList of type Climber.
     */
    public ArrayList<Climber> getClimbers()
    {
        return climbers;
    }
    
     /**
     * Add to the club's arraylist of climbers.
     * 
     * @param newClimber - the Climber object to be added to the arraylist (climbers).
     */
    public void addClimber(Climber newClimber)
    {
        climbers.add(newClimber);
    }
    
     /**
     * Parses the climber's arraylist and retrieves the highest mountain from each climber's mountain arraylist using
     * the getMax method in the Climber class. If the getMax method returns null, zero is assigned for that climber's
     * highest mountain. The climber's highest mountains are compared and the highest of all is returned. If there
     * are no climbers in the arraylist null is returned and a message is printed to the console.
     * 
     * @return Mountain - the mountain with the highest value for height.
     */
    public Mountain getClimberMax()
    {
        int highest = 0; // intialise the local variables
        Mountain topMountain = null;
        
        if (climbers.isEmpty()){
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("There are no climbers currently stored in the system");
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
     
        }
        else{
            int height = 0;
            for (Climber i : climbers) { // loop through the climbers list
                Mountain top = i.getMax();
                
                if (top != null){
                    height = top.getHeight();
                }
                else {
                    height = 0;
                }
                
                if (height > highest) { // compare each element to the highest so far
                    highest = height; // assign new highest to local variable for loop
                    topMountain = top; // assign new highest to return variable
                }
            }
        }
        return topMountain;
    }
    
    /**
     * Parses the climber's arraylist and retrieves the average height of the mountains climbed by each climber using
     * the getAverage method in the Climber class. The climber's average height of the mountains climbed are compared
     * and the highest average is returned. If there are no climbers in the arraylist null is returned and a message
     * is printed to the console. If two or more climbers have the same average they all returned.
     * 
     * @return ArrayList of type Climber - the climber(s) with the highest average mountain height.
     */
    public ArrayList<Climber> getMaxAverage()
    {
        double highest = 0; // intialise the local variables
        ArrayList<Climber> topClimber = new ArrayList<Climber>(); //incase 2 or more climbers have the same average
        
        if (climbers.isEmpty()){
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("There are no climbers currently stored in the system");
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
     
        }
        
        else{  
  
            for (Climber i : climbers) { // loop through the climbers list
                double height = i.getAverage();
                if (height == highest) { // compare each element to the highest so far - error her
                    topClimber.add(i); // if 2 or more climbers have the same average they will all appear
                }
                else if (height > highest) {
                    highest = height;
                    topClimber.clear(); // the latest average is higher so all others must be removed 
                    topClimber.add(i);
                }
            }
        }
        
        return topClimber;
    }
    
    /**
     * Tests the height of all the mountains in all the climber's arraylists of mountains against a given value using
     * the getAboveMountList method in the Climber class. The returned arraylists from the Climber class are combined
     * in to a new arraylist (allAbove).If there are no climbers in the arraylist null is returned and a message
     * is printed to the console.
     * 
     * @return ArrayList of type Mountain.
     * @param limit - the test height.
     */
    public ArrayList<Mountain> getCombinedAboveMountList(int limit)
    {
       ArrayList<Mountain> greaterThan = new ArrayList<Mountain>();
       
       if (climbers.isEmpty()){
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("There are no climbers currently stored in the system");
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
       }
        
       else{
           ArrayList<Mountain> allAbove = null;
           for (Climber i : climbers) {
               allAbove = i.getAboveMountList(limit);
                   if (allAbove != null) {
                   greaterThan.addAll(allAbove);
                }
               }
           }
       
       return greaterThan;
    
    } 
    
}
