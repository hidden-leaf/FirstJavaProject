
// to extend the usability in the future extra menu options to edit climbers and mountians could be added.
// testing the user input reduces the code but could reduce flexibility later on if other functions are added.
// if a climber is not found when trying to add a Mountain object then add the ability to create a new climber without returning to the main menu.
/**
 * Contains the main method and start method. Provides users with a menu. Takes inputs of type String, integer and boolean. User input is 
 * used to create Climber and Mountain objects and assign Mountain objects to a particular Climber object. Allows all the Climber objects
 * name parameters to be searched against a String. Outputs the highest mountain, highest average mountain height and mountains above a 
 * specified height to the console.
 * 
 * @author Peter Triggs
 * @version 0.1
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.InputMismatchException;


public class ClubStats
{
    // instance variables 
    private Scanner readerStr;
    private Scanner readerInt;
    private Club firstClub;

    /**
     * Constructor for objects of class ClubStats
     */
    public ClubStats()
    {
        // initialise instance variables
       readerStr = new Scanner(System.in);
       readerInt = new Scanner(System.in);
       firstClub = new Club();
    }

    /**
     * main method
     */
    public static void main(String[] args)
    {
        ClubStats myClubStats = new ClubStats();
        myClubStats.start();
        
    }
    
    /**
     * Start method for the program. This will print the menu to the console and wait for input from the user. It will call 
     * relevant methods requested by the user related to the menu items. If the addClubClimber method returns null the addClimber
     * method isn't called to prevent a null pointer.
     * 
     */
    public void start()
    {
        boolean exit = false;
        
        while(!exit) {
            getMenu();
            int input = getNumInput();
            
            switch (input) {
                case 1: Climber climberToAdd = addClubClimber();
                            if (climberToAdd != null) {
                            firstClub.addClimber(climberToAdd);
                        }
                        break;
                case 2: Mountain mountainToAdd = addNewMountain();
                        addMountainToClimber(mountainToAdd);
                        break;
                case 3: showHighestAv();
                        break;
                case 4: showHighestMountain();
                        break;
                case 5: showMountainsAbove();
                        break;
                case 6: exit = true;
                        System.out.println("Goodbye");
                        break;
                default: System.out.println("Please enter a number between 1 and 6");
                        break;
            }
        
        }
    }   
  
    /**
     * Takes input from the user with the getStringInput and getNumInput methods. Checks the user input for name against the current names in 
     * the Climber class and asks the user to input a different name if there is a match. A new Climber object is then created using the user
     * inputs.
     * 
     * @return Climber - a new object of the Climber class.
     */
    public Climber addClubClimber()
    {
        boolean nameIsOk = false;
        String name = null;
        
        do{
            System.out.println("Please input a name for the new climber");
            String search = getStringInput();
            Climber foundClimber = searchClimbers(search);
            
            if (foundClimber != null){
                System.out.println("That climber already exists do you wish to enter a different name : y/n");
                boolean response = getYesNo();
                    if (response == true){
                        nameIsOk = false;
                    }
                    else if (response == false) {
                        Climber newClimber = null;
                        return newClimber;
                    }
                }
            else {
                name = search;  
                nameIsOk = true;
            }
        } while (nameIsOk == false);
               
        System.out.println("Please input an age for the new climber");
        int age = getNumInput();
        System.out.println("Please input a gender for the new climber");
        String gender = getStringInput();
        Climber newClimber = new Climber(name, age, gender);
        return newClimber;
    }
   
    /**
     * Takes input from the user with the getStringInput and getNumInput methods. A new Mountain object is then created using the user
     * inputs.
     * 
     * @return Mountain - a new object of the Mountain class.
     */
    public Mountain addNewMountain()
    {
        System.out.println("Please input the height of the mountain");
        int height = getNumInput();
        System.out.println("Please input the name of the mountain");
        String name = getStringInput();
        Mountain newMountain = new Mountain (height, name);
        return newMountain;        
        
    }
    
    /**
     * Finds the user specified climber in the climbers array list and adds the new mountain to it. If the climber search returns null the 
     * Mountain object is not added. 
     * 
     * @param mountainToAdd - the Mountain object specified in addNewMountain method.
     *
     */
    public void addMountainToClimber(Mountain mountainToAdd)
    {
        System.out.println("Which climber would you like to add this mountain to?");
        String inputName = getStringInput();
        Climber foundClimber = searchClimbers(inputName);
 
           if (foundClimber != null){
               foundClimber.addMountain(mountainToAdd);
           }
           else { 
               System.out.println("******************************************************************************");
               System.out.println("******************************************************************************");
               System.out.println("That climber is not currently in the system please add the");
               System.out.println("climber via the main menu before adding the mountain again");
               System.out.println("******************************************************************************");
               System.out.println("******************************************************************************");
           }
            
        
    }
    
    /**
     * Iterates through the climbers arraylist and looks for a climber with the same name as the parameter, the search is not case sensitive.
     * If the climbers arraylist is empty or there is no match null is returned.
     * 
     * @return Climber - the Climber object that matches the parameter.
     * @param climberName - the name of the climber being searched for.
     */
    public Climber searchClimbers(String climberName)
    
    {
        ArrayList<Climber> climbers = firstClub.getClimbers();
        Climber foundClimber = null;
        if (climbers.isEmpty()){
            foundClimber = null;
        }
        
        else{
                Iterator<Climber> it = climbers.iterator();
                    while(it.hasNext()){
                       Climber c = it.next();
                       String listName = c.getName();
                       if (listName.equalsIgnoreCase(climberName)){
                           foundClimber = c;
                           return foundClimber;
                       }
                       else if (!it.hasNext() & !listName.equalsIgnoreCase(climberName)){ 
                           foundClimber = null;
                       }
                    }
            }
            
        return foundClimber;
    }    
    
    /**
     * Prints to the console the names of the climber(s) with the highest average mountain height and the value of the average. If there are
     * no climbers in the system nothing is printed to the console from this method.
     * 
     */
    public void showHighestAv()
    {
        
        ArrayList<Climber> bestClimber = firstClub.getMaxAverage();
        
        if (bestClimber != null){
            for (Climber i : bestClimber) {
            String name = i.getName();
            double avheight = i.getAverage();
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("The climber with the highest average mountain height is " + name);
            System.out.println("The average height of the mountains they have climbed is " + avheight);
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
        }
    }
        
    }
    
    /**
     * Prints to the console the name of the Mountain with the highest height and the value of the height. If there are
     * no mountains in the system nothing is printed to the console from this method.
     */
    public void showHighestMountain()
    {
        Mountain highestMountain = firstClub.getClimberMax();
        
        if (highestMountain != null){
            String mountainName = highestMountain.getName();
            int mountainHeight = highestMountain.getHeight();
            
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("The highest mountain climbed is " + mountainName);
            System.out.println("It's height is " + mountainHeight + " meters");
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
        }
        
    }
    
    /**
     * Prints to the console the names and heights of the mountain(s) with a height greater than the value of the user input via getNumInput 
     * method. If there are no mountains greater than the specified height a message is printed to the console.
     */
    public void showMountainsAbove()
    {
        System.out.println("******************************************************************************");
        System.out.println("******************************************************************************");
        
        System.out.println("Please input the height limit you wish to show mountains higher than");
        int limit = getNumInput();
        
       
        ArrayList<Mountain> mountAbove = firstClub.getCombinedAboveMountList(limit);
        
        if (mountAbove.isEmpty()){
            
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("There are no mountains currently recorded in the system that are greater than " + limit + " meters");
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
           
            }
     
        else{
            System.out.println("******************************************************************************");
            for (Mountain i : mountAbove) {
                String name = i.getName();
                int height = i.getHeight();
                System.out.println(name);
                System.out.println(height);
                System.out.println("******************************************************************************");
            
             }
       }
        
       System.out.println("******************************************************************************");
       System.out.println("******************************************************************************");
      
        
    }
    
    /**
     * Reads input from the user via the console. If the user enters nothing they are prompted to enter something.
     * 
     * @return String - user input from the console.
     */
    public String getStringInput()
    {
        
        System.out.print("> ");   //print prompt
        String inputLine = readerStr.nextLine();
        
        if (inputLine.isEmpty()) {   //stop the user from entering nothing
            while (inputLine.isEmpty()){ // loops until something is entered
                System.out.println("Please don't leave this entry blank, try again");
                System.out.print("> ");   //print prompt
                inputLine = readerStr.nextLine();
            }
        }
        
        return inputLine;
    }
    
    /**
     * Reads input from the user via the console. If the user enters a negative, decimal number or characters they are prompted to enter a 
     * whole number.
     * 
     * @return int - user input from the console.
     */
    public int getNumInput()
    {
        int inputLine = 0;
        
        while (inputLine <= 0) { //loops until a valid number has been entered
            try {
                System.out.print("> "); //print prompt
                inputLine = readerInt.nextInt();
                
                if (inputLine <=0) {
                    System.out.println("Please enter a positive number");
                }
            }
            
            catch(InputMismatchException e)  {
               System.out.println("That wasn't a valid number, please enter a whole number");
               readerInt.next();
            }
           // need catch for negative number
        }
        
        return inputLine;
    }
    
    /**
     * Reads a boolean response from the user.
     * 
     * @return boolean - user input from the console.
     */
    public boolean getYesNo() 
    {
        boolean validResponse = false;
        boolean intention = false;
        while (validResponse == false){
            String response = getStringInput();
                switch (response){
                    case "y":    
                        intention = true;
                        return intention;
                    
                    case "n":
                        intention = false;
                        return intention;
                    
                    default:
                        System.out.println("Please enter y for yes or n for no");
                        validResponse = false;
                    }
        }
        return intention;
        
    }
    
    /**
     *Prints out the menu for the user to the console.
     */
    public void getMenu()
    {
        System.out.println("1. Add a new climber to the club.");
        System.out.println("2. Add a new mountain for a climber");
        System.out.println("3. Show the climber with the highest average mountain height");
        System.out.println("4. Show the highest mountain recorded by a club member");
        System.out.println("5. Show all the mountains greater than a given height");
        System.out.println("6. Exit");
        System.out.println("Enter a number to select a menu option");
            
    }
}
