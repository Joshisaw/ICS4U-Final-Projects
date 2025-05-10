/*
Joshua Wang - ICS4U
This is a simple rock paper scissors program
where the user enters a combination of games
where the first char in the combination is
player 1's choise and second char in the 
combination is player 2's choice and the
program returns who will win the combination
of games and will end if q is entered
 */
package wangjoshuajavachallenge;

/**
 *
 * @author 340889765
 */
//import all java libraries
import java.util.*;
public class PC1 {
    
    public static void main(String[] args) {
        //imports scanner
        Scanner s = new Scanner(System.in);
        //declares all variables for use in the program
        int playerTwoScore;
        int playerOneScore;
        int counter;
        boolean loopRepeat = false;
        
        //prints out intructions for game
        System.out.println("User will enter rounds of rock paper scissor games per line"
                                +"\nwith P being paper, S being scissors and R being rock.\n"
                                +"Per game, first char is p1's move and second is p2's move"
                                +"\nThe output is who wins after accounting for each round \n\n"
                                +"All rounds of games should be seperated by spaces\n"
                                +"The program will continue looping until Q is entered\n"
                                +"Input shouldn't be EMPTY and shouldn't exceed 255 chars\n");
        //loops is loopRepeat is false                    
        while(!loopRepeat){
            //prints user prompt
            System.out.print("Please enter each round of games (divided by spaces a game):");
            //sets p1 and p2 score as zero
            playerTwoScore = 0;
            playerOneScore = 0;
            //simple counter to judge if empty
            counter = 0;
            //sets userEntry to user input
            String userEntry = s.nextLine();
            //if userEntry is empty
            if(userEntry.equals("")){
                //print error message
                System.out.println("**ERROR! Please recheck intructions!**");
            }
            int userInputLength = userEntry.length();
            //if user input length exceeds 255
            if(userInputLength>255){
                //print error message
                System.out.println("**ERROR! Please recheck intructions!**");
                //clears userEntry
                userEntry = " ";
            }
            //if the user entry is Q, ends program and clears userEntry
            if(userEntry.equals("Q")){
                userEntry = " ";
                loopRepeat = true;
            }
            //declares tokenizer with " " as a delimeter
            StringTokenizer tokenPrompt = new StringTokenizer(userEntry," ");
            //runs if tokenPrompt has more elements
            while(tokenPrompt.hasMoreElements()){
                //sets current elements as the next token
                String curElement = (tokenPrompt.nextElement().toString());
                //adds 1 to counter
                counter++;
                //sets first char as first char of current element
                char firstElement = curElement.charAt(0);
                //sets second char as second char of current element
                char secondElement = curElement.charAt(1);
                //converts firstElement and secondElement to ints and sub
                int winLoseValue = (int)firstElement - (int)secondElement;
                //if is 0, don't do anything
                if(winLoseValue == 0){
                //if is 1
                }else if(winLoseValue == 1){
                    //player 2 gets point
                    playerTwoScore++;
                    //if is -1
                }else if(winLoseValue == -1){
                    //player 1 gets point
                    playerOneScore++;
                //if is 2
                }else if(winLoseValue == 2){
                    //player 2 gets point
                    playerTwoScore++;
                //if is -2
                }else if(winLoseValue == -2){
                    //player 1 gets point
                    playerOneScore++;
                //if is 3
                }else if(winLoseValue == 3){
                    //player 1 gets point
                    playerOneScore++;
                //if is -3
                }else if(winLoseValue == -3){
                    //player 2 gets point
                    playerTwoScore++;
                }
            }
            //if player 1 has more points
            if(playerOneScore>playerTwoScore){
                //print win prompt
                System.out.println("Player One Wins");
            //if player 2 has more points
            }else if(playerTwoScore>playerOneScore){
                //print win prompt
                System.out.println("Player Two Wins");
            //if counter isn't 0
            }else if(counter!=0){
                //print tie prompt
                System.out.println("It's a tie");
            }
        }
    }
}
