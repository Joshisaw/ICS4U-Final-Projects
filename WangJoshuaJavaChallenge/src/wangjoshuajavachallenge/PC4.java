/*
Joshua Wang - ICS4U
A simple program that tracks his climbing progresses.
User inputs total distance to climb, how much nick climbs,
the amount he slides down and how much the climbing distance
reduces. It then outputs whether nick fails or not and on what
attempt he succeeds or fails
 */
package wangjoshuajavachallenge;

/**
 *
 * @author 340889765
 */
//imports java libraries
import java.util.*;
public class PC4 {

    public static void main(String[]args){
        //declares scanner
        Scanner s  = new Scanner(System.in);
        //Prints out user intructions for the program
        System.out.println("Enter all values as ints between 1-100 inclusive"
                + "\nIn said order:\nD: distance to the top of the hill"
                + "\nC: distance Nicholas can climb on 1st attempt"
                + "\nS: distance he slides after he falls \nF: fatigue factor as a %"
                + "\nOnly FOUR values should be entered!"
                + "\nAll values should be seperated by spaces");
        //sets variables for the program
        boolean loopRepeat = false;
        boolean contLoop;
        double totalDistance = 0;
        double distanceClimb = 0;
        double distanceSlide = 0;
        double fatiguePercent = 0;
        //if loopRepeat is false
        while(!loopRepeat){
            //sets boolean to true
            loopRepeat = true;
            contLoop = true;
            //prints out user prompt
            System.out.print("Please enter D C S F (according to intructions): ");
            //set userInput as user input
            String userInput = s.nextLine();
            //create tokenizer with delimiter to " "
            StringTokenizer userPrompt = new StringTokenizer(userInput, " ");
            //resets counters
            int counter = 0;
            int counterVerify = 0;
            //is there are more elements and contLoop is true
            while(userPrompt.hasMoreElements() && contLoop){
                //set curElement to next token
                String curElement = userPrompt.nextElement().toString();
                //increase counter verify by 1
                counterVerify++;
                //if counter is 0
                if(counter == 0){
                    ////returns boolean value depending if type is proper
                    contLoop = typeVerify(curElement);
                    //if contLoop is true
                    if(contLoop){
                        //convert curElement to a double
                        totalDistance = Double.parseDouble(curElement);
                        //verify the length and return a boolean value
                        loopRepeat = lengthVerify(totalDistance, loopRepeat);
                        //increase counter by 1
                        counter++;
                    //else if contLoop isn't true
                    }else{
                        //repeat
                        loopRepeat = false;
                    }
                //if counter is 1
                }else if(counter == 1){
                    //returns boolean value depending if type is proper
                    contLoop = typeVerify(curElement);
                    //if contLoop is true
                    if(contLoop){
                        //parse curElement into a double
                        distanceClimb = Double.parseDouble(curElement);
                        //verify the length and return a boolean value
                        loopRepeat = lengthVerify(distanceClimb, loopRepeat);
                        //increase counter by 1
                        counter++;
                    //if contLoop is false
                    }else{
                        //loop repeats
                        loopRepeat = false;
                    }
                //if counter is 2
                }else if(counter == 2){
                    //returns boolean value depending if type is proper
                    contLoop = typeVerify(curElement);
                    //if contLoop is true
                    if(contLoop){
                        //convert curELement into a double
                        distanceSlide = Double.parseDouble(curElement);
                        //verify the length and return a boolean value
                        loopRepeat = lengthVerify(distanceSlide, loopRepeat);
                        //increase counter by 1
                        counter++;
                    //if contLoop isn't true
                    }else{
                        //loop repeats
                        loopRepeat = false;
                    }
                //if counter is 3
                }else if(counter == 3){
                    //returns boolean value depending if type is proper
                    contLoop = typeVerify(curElement);
                    //if contLoop is true
                    if(contLoop){
                        //convert curELement to a double
                        fatiguePercent = Double.parseDouble(curElement);
                        //return a boolean value if length is appropriate
                        loopRepeat = lengthVerify(fatiguePercent, loopRepeat);
                        //increase counter by 1
                        counter++;
                    //if contLoop isn't true
                    }else{
                        //loop repeats again
                        loopRepeat = false;
                    }
                    //calculates fatiguePercent as a decimal
                    fatiguePercent = fatiguePercent*distanceClimb/100;
                //else if counter is greater than 3
                }else{
                }
            }
            //if counter verify is 4
            if(counterVerify == 4){
            //reset values
            double nickPos = 0;
            int numAttempts = 0;
            //repeats if nickPos within range of 0 and total distance and loopRepeat is true
            while(nickPos>=0 && nickPos<totalDistance && loopRepeat){
                //increase number of attempts
                numAttempts++;
                //if distance climb is less than zero
                if(distanceClimb<0){
                    //set to zero
                    distanceClimb = 0;
                }
                //set nick position to add climb distance
                nickPos = nickPos + distanceClimb;
                //if nick position is greater than totalDistance
                if(nickPos>=totalDistance){
                    //add distance slide
                    nickPos = nickPos + distanceSlide;
                }
                //otherwise, nick position by distance slide
                nickPos = nickPos - distanceSlide;
                //subtract distance climbed with fatigue percent
                distanceClimb = distanceClimb - fatiguePercent;
            }
            //if nick pos is less than zero and loopRepeat is true
            if(nickPos<0 && loopRepeat){
                //print out fail prompt
                System.out.println("\nFailure on attempt " + numAttempts);
            //but if nick pos is greater than total distance and loopRepeat is true
            }else if(nickPos>=totalDistance && loopRepeat){
                //print out success prompt
                System.out.println("\nSuccess on attempt " + numAttempts);
            }
            //if counter verify is over 4, which means more/less than 4 are entered
            }else if(counterVerify!=4 && loopRepeat){
                //repeat program
                loopRepeat = false;
            }
        }
    }
    //method to verify if entered value is an int
    public static boolean typeVerify(String str){
        //declares boolean variable
        boolean returnVal;
        //try the program
        try{
            //parses string to an int
            int parsedInt = Integer.parseInt(str);
            //sets boolean to true
            returnVal = true;
        //if error happens
        }catch(NumberFormatException e){
            //boolean is false
            returnVal = false;
        }
        //returns boolean value to main method
        return returnVal;
    }
    //creates method to verify double length
    public static boolean lengthVerify(double i, boolean returnVal){
        //if double is between 1 and 100 inclusive
        if(i<1||i>100){
            //boolean is false
            returnVal = false;
        //otherwise nothing happens
        }else{

        }
        //returns boolean value to main method
        return returnVal;
    }
    
}
