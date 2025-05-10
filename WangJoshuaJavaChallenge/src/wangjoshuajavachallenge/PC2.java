/*
Joshua Wang - ICS4U
This is a simple program that accepts
a simple string input and returns the
amounts of each different letter in
the string input
 */
package wangjoshuajavachallenge;

/**
 *
 * @author 340889765
 */
//imports java libraries
import java.util.*;
public class PC2 {
    
    public static void main(String[] args) {
        //declares all variables for the program
        int findPos;
        int letterCount;
        boolean loopRepeat;
        boolean reInput = false;
        int alphabetCount;
        String outputDisplay = "";
        
        //displays some intructions about program
        System.out.println("Your program should continue accepting\n"
                                +"inputs until the input is 'stop'\n"
                                +"Input should be no longer than 255 characters\n"
                                +"Input also shouldn't be empty!\n");
        //loops is reInput is false
        while(!reInput){
            //imports scanner
            Scanner s = new Scanner(System.in);
            //prints user prompt
            System.out.print("Enter a sentence: ");
            //accepts user input
            String userInput = s.nextLine();
            //takes length of user input
            int lengthOfInput = userInput.length();
            //if user input is stop
            if(userInput.equals("stop")){
                //stops loop from repeating
                reInput = true;
            //if length of input is longer than 255
            }else if(lengthOfInput>255){
                //prints out error prompt
                System.out.println("**ERROR! Please recheck intructions**");
            //if everything else is good, runs program
            }else{
            //sets userInput to upper cases
            String newUserInput = userInput.toUpperCase();
            //sets output display to nothing
            outputDisplay = "";
            //for loop that goes through the alphabet
            for(int i = 65; i <= 90 ; i++){
                //set current char from int to char
                char curAlphabet = (char)i;
                //sets loopRepeat to false
                loopRepeat = false;
                //reset all values
                letterCount = 0;
                findPos = 0;
                alphabetCount = 0;
                //if loopRepeat is false
                while(!loopRepeat){
                    //searches for alphabetical letter and return its position
                    alphabetCount = newUserInput.indexOf(curAlphabet,findPos);
                    //if there is a location
                    if(alphabetCount>=0){
                        //adds 1 to letterCount
                        letterCount++;
                        //add 1 to position of the found position
                        findPos=alphabetCount + 1;
                    //if there isn't a location
                    }else{
                        //loopRepeat is true
                        loopRepeat = true;
                        //if letterCount isn't zero
                        if(letterCount != 0)
                            //add current letter and amount found to outputDisplay
                            outputDisplay = outputDisplay + curAlphabet + "-" + letterCount + ":";
                    }
                }
            }
            //set length of String to outputDisplay
            int lengthOfString = outputDisplay.length();
            //if length isn't 0
            if(lengthOfString!=0){
                //subtract 1 char from outputDisplay
                outputDisplay = outputDisplay.substring(0,lengthOfString-1);
                //prints out outputDisplay
                System.out.println(outputDisplay);
            //but if it is 0
            }else{
                //asks user to recheck intructions
                System.out.println("**ERROR! Please recheck intructions**");
            }
        }
        }
    }
    
}