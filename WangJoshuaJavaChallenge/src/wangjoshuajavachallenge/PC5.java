/*
Joshua Wang - ICS4U
Simple program that asks for number of adjectives
and number of nouns and asks for those adjectives
and nouns before printing out all possible outcomes
of similes.
 */
package wangjoshuajavachallenge;

/**
 *
 * @author 340889765
 */
//import java libraries
import java.util.*;
public class PC5 {
    
    public static void main(String[]args){
        //declares scanner
        Scanner s  = new Scanner(System.in);
        //creates arrays to store adjectives and nouns
        String [] adjectives = new String[5];
        String [] nouns = new String[5];
        //declares variables for program
        String printedLine;
        boolean verify2 = true;
        boolean verify1 = true;
        int adjectivesCounter = 0;
        //displays intructions
        System.out.println("Please enter the number of adjectives and nouns\n"
                                +"Value should not be ZERO or BELOW!\n");
        //is adjectivesCounter is less than equal to 0
        while(adjectivesCounter<=0){
            //prints user prompt
            System.out.print("How many adjectives?: ");
            //accepts the user input as an int
            adjectivesCounter = s.nextInt();
            //if adjectivesCounter is wrong
            if(adjectivesCounter<=0){
                //prints out error message
                System.out.println("**ERROR! Please recheck instruction!**");
            }
        }
        //sets nounCounter to 0
        int nounsCounter = 0;
        //repeats if nouns counter is less than equal to 0
        while(nounsCounter<=0){
            //prints user prompt
            System.out.print("How many nouns?: ");
            //accepts the user input as an int
            nounsCounter = s.nextInt();
            //if nounsCounter is wrong
            if(nounsCounter<=0){
                //prints out error message
                System.out.println("**ERROR! Please recheck instruction!**");
            }
        }
        //declares a backup nouns counter
        int secondNounsCounter;
        //clears gunk
        String gunk = s.nextLine();
        //displays intructions for adjective and noun input
        System.out.println("\nPlease enter your adjectives and nouns"
                            +"\nValues should be STRINGS and NOT EMPTY!\n");
        //for loop that inputs adjectives in array
        for(int i = 0;i < adjectivesCounter;i++){
            //set verify1 to true
            verify1 = true;
            //sets output number to +1 of for loop variable
            int adjNum1 = i+1;
            //prints use prompt for adjective
            System.out.print("Please enter adjective " + adjNum1 + ": ");
            //sets adjective array cell to user input
            adjectives[i] = s.nextLine();
            //if user input is empty
            if(adjectives[i].equals("")){
                //subtract from 1 from i for re input
                i--;
                //prints out error input
                System.out.println("**That's empty**");
                //sets verify1 to false
                verify1 = false;
            }
            //if verify1 is true
            if(verify1){
                //convert first char of adjective entered to ascii
                int integerCheck1 = (int)adjectives[i].charAt(0);
                //check if it is a string
                if(integerCheck1<65 || integerCheck1>122){
                    //if not, minus one from loop for re-input
                    i--;
                    //print out error prompt
                    System.out.println("**That's not a String**");
                }
            }
        }
        //for loop that inputs nouns in array
        for(int i = 0;i < nounsCounter;i++){
            //sets verify2 to true
            verify2 = true;
            //add 1 to noun to print
            int nounsNum2 = i+1;
            //displays user prompt
            System.out.print("Please enter noun " + nounsNum2 + ": ");
            //sets noun array cell to user input
            nouns[i] = s.nextLine();
            //if user input is empty
            if(nouns[i].equals("")){
                //allows for re input
                i--;
                //prints out error prompt
                System.out.println("**That's empty**");
                //set verify2 to false
                verify2 = false;
            }
            //if verify is true
            if(verify2){
                //convert first char to an int
                int integerCheck2 = (int)nouns[i].charAt(0);
                //if it is not a string
                if(integerCheck2<65 || integerCheck2>122){
                    //allows for re prompt
                    i--;
                    //prints out an error prompt
                    System.out.println("**That's not a String**");
                }
            }
        }
        //displays title for similes
        System.out.println("\nSimiles:");
        //repeats if adjective counter is greater than 0
        while(adjectivesCounter > 0){
            //set backup noun counter to noun counter
            secondNounsCounter = nounsCounter;
            //repeats if backup noun counter is greater than 0
            while(secondNounsCounter > 0){
                //makes a simile
                printedLine = adjectives[adjectivesCounter-1]+" as "+nouns[secondNounsCounter-1];
                //prints out simile
                System.out.println(printedLine);
                //reduces noun counter
                secondNounsCounter--;
            }
            //reduces adjective counter
            adjectivesCounter--;
        }
    }
    
}
