/*
 * Joshua Wang - ICS4U
 */
package ooptestproject;

/**
 *Object Oriented Programming Test Part 2   
 * @author Mr. Payne
 */
public class OOPTestProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  // this part is worth 14 Application marks
       //sets boolean values of each plane's landing status
       boolean hornetStatus = false; 
       boolean sabreStatus = false;
       
       //instantiate an aircraft object 'hornet'  (A1)
       Aircraft hornet = new Aircraft("CF18");
       // give the hornet object the aircraft name 'CF18'  (A1)
       Aircraft sabre = new Aircraft("CF18");
       //give sabre plane the name CF86
       sabre.setName("CF86");   // FIX THIS - give the object the aircraft name 'CF86' (A1)
    
       // instantiated an aircraft object ufo (A1) by giving the object a setName argument of 1 (overloaded class method)
       Aircraft ufo = new Aircraft();
       //gives UFO object an argument of 1
       ufo.setName(1);
       //make the hornet take off and set its speed to 200 and altitude to 24000 (A1)
       hornetStatus = hornet.takeOff(200,24000);
       // make the sabre take off and set its speed to 150 and altitude to 10000 (A1)
       sabreStatus = sabre.takeOff(150,10000);
       //print out the hornet's altitude and speed by using getters (A2)
       //gets hornet speed
       int hornetSpeed = hornet.getSpeed();
       //gets hornet altitude
       int hornetAltitude = hornet.getAltitude();
       //print statement
       System.out.println("The hornet is traveling at " + hornetSpeed + " speed\n"
               + "and at " + hornetAltitude + " altitude");
       // get the UFO's altitude and name and print them out by using getter (A1)
       //get UFO's altitude
       int ufoAltitude = ufo.getAltitude();
       //get UFO's name
       String ufoName = ufo.getName();
       System.out.println("The " + ufoName + " is at an altitude of " + ufoAltitude);
     // Check if the sabre is NOT on the ground. If its flying, execute the landPlane method for sabre
        if(!sabreStatus){      //(A1)
            //sets status to landed plane status
            sabreStatus = sabre.landPlane();
            //prints message
            System.out.println("*The sabre has landed on the ground*");
           // land the plane  (A2)
       // print (sabre has landed message); (A1)
        }
        
    }
    
}
