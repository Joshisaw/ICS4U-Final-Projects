/*
 Joshua Wang - ICS4U
 */
package ooptestproject;
// this part is worth 17 Thinking marks
// 8 total Communication marks for Javaocs commenting of all methods
    // only maximum 5 marks available if you don't know how to Javadoc and do standard comments
//******* PROPER ENCAPSULATION PRACTICES are expected. ************
public class Aircraft {   

    //declare name variable
    private String planeName;

    // constructor here (T3)
    /**
     * Sets the plane's name with user parameter when an object is instantiated.
     * @param planeName String value of plane's name
     */
    public Aircraft(String planeName){
        this.planeName = planeName;
    }
     // set speed to zero, altitude to zero, ground status to "on ground" 
                                             //(what is the best type for this variable? - NOT A STRING!!!) 
    //declares all variables for speed, altitude and ground
    private int planeSpeed = 0;
    private int planeAltitude = 0;
    private boolean groundCheck = true;
    
    /**
     * Sets plane name to user entered parameter
     * @param name String value of plane's name
     */
    public void setName(String name) {
        planeName = name;
    }
     /**
      * Returns name of plane to the main method
      * @return planeName - String value of planes name
      */
    public String getName(){
        return planeName;
    }
    
     // overloaded setName method with INTEGER parameter here (T3)
    /**
     * Returns an integer parameter to main method
     * @param i Int parameter
     */
    public void setName(int i){
        
    }
      // gives name "UFO" to the object instantiated by calling this method
    /**
     * Sets aircraft name to "UFO" is no parameters are typed
     */
     public Aircraft(){
         this.planeName = "UFO";
     }
     
     
    

    //create speed getter and setter methods (T2)
    /**
     * Sets speed of the plane
     * @param planeSpeed - Int value of plane speed
     */
    public void setSpeed(int planeSpeed){
        this.planeSpeed = planeSpeed;
    }
    // getters should return an integer
    /**
     * Returns speed of the plane to main
     * @return planeSpeed - Int value of plane speed
     */
    public int getSpeed(){
        return planeSpeed;
    }
    
    // create altitude getter and setter methods (T2)
    /**
     * Sets altitude of the plane
     * @param planeAltitude - Int value of plane altitude
     */
    public void setAltitude(int planeAltitude){
        this.planeAltitude = planeAltitude;
    }
    // getters should return an integer
    /**
     * Returns altitude of the plane to main
     * @return planeAltitude - Int value of plane altitude
     */
    public int getAltitude(){
        return planeAltitude;
    }
    // create method to GET the status of the plane on ground or not (T1)
    /**
     * returns status of plane on the ground (true) or not(false) 
     * @return groundCheck - Boolean value that tells whether plane if on the
     * ground or not
     */
    public boolean groundStatus(){
        return groundCheck;
    }
    
    //create a landPlane method - returns boolean
              // speed and altitude to zero, set onground value for plane on ground (T3)
    /**
     * sets plane speed, altitude and status on the ground to 0, 0 and true.
     * Indicates that the plane has landed on the ground
     * @return groundCheck  - Boolean value that tells whether plane if on the
     * ground or not
     */
    public boolean landPlane(){
        planeSpeed = 0;
        planeAltitude = 0;
        groundCheck = true;
        return groundCheck;
    }
  
       
   // public boolean takeOff(...) { (T3)
    /**
     * Simulates the plane taking off by setting a speed it reaches, altitude
     * it will reach and changes status from on the ground to up (false)
     * @param planeSpeed - int value of the plane's speed
     * @param planeAltitude - int value of the plane's altitude
     * @return groundCheck - Boolean value that tells whether plane if on the
     * ground or not
     */
    public boolean takeOff(int planeSpeed, int planeAltitude){
        groundCheck = false;
        setSpeed(planeSpeed);
        setAltitude(planeAltitude);
        return groundCheck;
    }
      
        
       
}
