/*
 Joshua Wang - ICS4U
 This is a simple program that intakes
 collector current and base current and
 returns cureent gain through division
 */
package wangjoshuajavachallenge;

/**
 *
 * @author 340889765
 */
//import libraries into code
import java.util.*;
public class WangJoshuaJavaChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declares scanner
        Scanner s = new Scanner(System.in);
        //declares all variables for program
        boolean loopRepeat;
        boolean counterLoop = false;
        int counterIf;
        double collectorCurrent = 0;
        double baseCurrent = 0;
        
        //if counter loop is false
        while(!counterLoop){
            //set to true
            counterLoop = true;
            //set counter for if statement to 0
            counterIf = 0;
            //print user prompt
            System.out.print("Please enter the base and collector "
                    + "\ncurrent(seperated by commas): ");
            //ask for user input
            String userPrompt = s.nextLine();
            //declare tokenizer and seperate by comma
            StringTokenizer promptToken = new StringTokenizer(userPrompt,",");
            
            //if promptToken has more elements and counterLoop is true, keeps looping
            while(promptToken.hasMoreElements()&&counterLoop){
                //set curElement to next token
                String curElement = (promptToken.nextElement().toString());
                //add 1 to counterIf
                counterIf++;
                //verify if curElement is a double
                loopRepeat = typeVerify(curElement);
                //if curElement is a double
                if(loopRepeat){
                    //if counterIf is 1
                    if(counterIf==1){
                        //make collectorCurrent into curElement after parsed
                        collectorCurrent = Double.parseDouble(curElement);
                    //if counterIf is 2
                    }else if(counterIf == 2){
                        //make baseCurrent into curElement after parsed
                        baseCurrent = Double.parseDouble(curElement);
                    }
                //if loopRepeat is false, and curElement isn't a double
                }else{
                    //set counterLoop to false and needs to rerun the code
                    counterLoop = false;
                    //prints out error message
                    System.out.println("***Please enter the proper values***");
                }
            }
            //if counterIf isn't two which mean not enough values have been entered
            if(counterIf!=2 && counterLoop){
                //set counterLoop to false and needs to rerun the code
                counterLoop = false;
                //prints out error message
                System.out.println("***Please enter the proper values***");
            }
        }
        //if collectorCurrent and baseCurrent aren't both 0
        if(collectorCurrent!=0 && baseCurrent!=0){
            //print out current gain
            System.out.println("The current gain is " + collectorCurrent/baseCurrent);
        //otherwise if both are zero
        }else{
            //tells user that program is ending
            System.out.println("Two zero's have been entered, ending program...");
        }
        
    }
    //typeVerify method to verify if double
    public static boolean typeVerify(String st){
        //declares boolean variable
        boolean properVal;
        //trys to run statement
        try{
            //parses string entered into a Double
            double doubleValue = Double.parseDouble(st);
            //if succeeded, set boolean to true
            properVal = true;
        //if error happened
        }catch(NumberFormatException e){
            //set boolean to false
            properVal = false;
        }
        //return boolean to main statment
        return properVal;
    }
    
}
