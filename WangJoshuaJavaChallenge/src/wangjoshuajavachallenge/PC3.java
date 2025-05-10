/*
Joshua Wang - ICS4U
Simple program that takes the player's
name, foul shots taken, foul shots made
and returns shot percent. Then also shows
which player has highest shot percent.
 */
package wangjoshuajavachallenge;

/**
 *
 * @author 340889765
 */
//import java libraries
import java.util.*;
public class PC3 {
    
    public static void main(String[]args){
        //declares scanner
        Scanner s = new Scanner(System.in);
        //declares variables for program
        boolean contVerify;
        String highestName = "";
        int loopCounter = 0;
        //char to verify type of tokens
        char [] typeHolder = {'s','d','d'};
        double maxVal = 0;
            //displays prigram intructions
            System.out.println("Please enter the foul shot data of 4 basketball players");
            System.out.println("enter their name, shots attempted and shots missed");
            System.out.println("Should be entered in that order seperated by spaces");
            System.out.println("Inputs should be String, Double, Double in that order");
            System.out.println("Only enter THREE values, any more you have to re-enter\n");
            //if loop counter is less than 4
            while(loopCounter < 4){
                //displays user input for player data
                System.out.print("Enter player " + (loopCounter+1) + " data: ");
                //asks for user input
                String userInput = s.nextLine();
                //resets all values to begin the program
                contVerify = true;
                int counter = 0;
                int enteredCounter = 0;
                double shotsMade = 0;
                double shotsTaken = 0;
                String nameHold = "";
                //creates tokenizer with delimeter as " "
                StringTokenizer userPrompt = new StringTokenizer(userInput," ");
                //if userPrompt has more elements and contVerify is true
                while(userPrompt.hasMoreElements() && contVerify){
                    //sets curElement to next token and to a string
                    String curElement = (userPrompt.nextElement().toString());
                    //increases enteredCounter
                    enteredCounter++;
                    //if counter is 0
                    if(counter == 0){
                        //returns boolean value depending if type is proper
                        contVerify = typeVerify(curElement, typeHolder[counter]);
                        //set nameHold to curElement
                        nameHold = curElement;
                        //increases counter by 1
                        counter++;
                    //if counter is 1
                    }else if(counter == 1){
                        //returns boolean value depending if type is proper
                        contVerify = typeVerify(curElement, typeHolder[counter]);
                        //if contVerify is true
                        if(contVerify){
                            //converts curElement to double
                            shotsTaken = Double.parseDouble(curElement);
                        }
                        //increases counter by 1
                        counter++;
                    //if counter is 2
                    }else if(counter == 2){
                        //returns boolean value depending if type is proper
                        contVerify = typeVerify(curElement, typeHolder[counter]);
                        //if contVerify is true
                        if(contVerify){
                            //converts curElement to double
                            shotsMade = Double.parseDouble(curElement);
                        }
                        //increases counter by 1
                        counter++;
                    }
                    //if counter is greater than two and contVerify is true
                    //and enteredCounter is less than or equal to 3
                    if(counter>2 && contVerify && enteredCounter<=3){
                        //increase loopCounter
                        loopCounter++;
                    }
                    //if enteredCounter is greater than 3
                    if(enteredCounter > 3){
                        //sets contVerify to false
                        contVerify = false;
                        //subtract from loopCounter
                        loopCounter--;
                    }
                }
                //uses formula to find shot percent
                double shotPercent = shotsMade/shotsTaken * 100;
                //contVerify is true
                if(contVerify){
                    //prints out user output of name and percent
                    System.out.printf(nameHold + "-%.2f \n",shotPercent);
                //if enteredCounter is greater than 3
                }else if(enteredCounter > 3){
                    //prints out error message
                    System.out.println("**ERROR! Please recheck intructions**");
                //else if anything else is wrong
                }else{
                    //prints out error message
                    System.out.println("**ERROR! Please recheck intructions**");
                }
                //if the max value is less than shotPercent
                if(maxVal<shotPercent){
                    //set maxVal to shotPercent
                    maxVal = shotPercent;
                    //set highestName to the name
                    highestName = nameHold;
                }
            }
            //prints out best player output
            System.out.println(highestName + " is the best player.");
    }
    //create the method to verify is the type is correct, input verification
    public static boolean typeVerify(String str, char i){
        //declares boolean val as false
        boolean returnVal = false;
        //trys to run program
        try{
            //sets switch value to i
            switch(i){
                //if i is 's'
                case 's':
                    //converts first char of string to int
                    int ascii = (int)str.charAt(0);
                    //if it is a to z or A to Z
                    if(ascii>=65 && ascii<=122){
                        //set boolean to true
                        returnVal = true;
                    }
                break; 
                //if i is d
                case 'd':
                    //parse string to double
                    double doubleParse = Double.parseDouble(str);
                    //if goes through, set boolean value to true
                    returnVal = true;
                break;
            }
        //if error happens
        }catch(NumberFormatException e){
            //boolean value is false
            returnVal = false;
        }
        //return boolean val to main method
        return returnVal;
    }

}