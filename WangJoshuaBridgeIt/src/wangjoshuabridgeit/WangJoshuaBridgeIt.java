//ICS3U - Joshua Wang - March 22, 2023
/*Basically a game where player 1 enters a secret word and player 2 has to 
guess the word 1 letter at a time. If it is wrong, the bridge collapses by 1, 
but if you get 1 right, your character will advance. When the bridge completely
collapses, you lose, but if your character gets across, you win. You can also
play again
*/
package wangjoshuabridgeit;

import java.util.Scanner; //imports scanner
public class WangJoshuaBridgeIt {

    public static void main(String[] args) {
        // TODO code application logic here
        //declares scanner variable
        Scanner s = new Scanner(System.in);
        //declares the alphabet variable
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        //declares the letters variable
        String letters = "";
        //declares the head variable
        String personHead = " .";
        //declares the body variable
        String personBody = " X";
        //starts the bridge
        String bridge = "/";
        //declares all the variables involving finding mechanics
        int findReplace;
        int searchFind;
        int findPos = 0;
        int extraPos = 0;
        int extraSearchFind; 
        //declares the char variable
        char yesNo;
        
        System.out.println("Welcome to BridgeIt!");
        
        do{
            System.out.print("Player one, please enter the secret word: ");
            //asks user for the secret word
            String secretWord = s.nextLine();
            //sets the user's guesses to the secretWord length
            int numGuesses = secretWord.length();
            //sets winCode to the secretWord length
            int winCode = secretWord.length();
            //uses for loop to create the bridge based on secretWord length
            for(int i = secretWord.length();i>0;i--){
                bridge = bridge + "-";
            }
            //ends with \
            bridge = bridge + "\\";
            //sets the letters to - based on secretWord length (numGuesses)
            while(numGuesses>0){
                letters = letters + "-";
                numGuesses--;
            }
            //resets num Guesses to secretWord length cause you subtracted it
            numGuesses = secretWord.length();
        
            //declares the counter variable
            int counter = 0;
            //uses counter to repeat 20 times
            while(counter<20){
                //goes down multiple lines
                System.out.println("");
                //increases counter increment
                counter++;
            }   
            System.out.println("You have " + numGuesses +
                                    " guesses left");
            System.out.println(personHead);
            System.out.println(personBody);
            System.out.println(bridge);
        
            do{ //declares do loop
                System.out.println("                  "+alphabet);
                System.out.println("                  "+letters);
                System.out.print("Guess a letter: ");
                //asks user for a letter
                String letterGuess = s.next();
                //searches for the letter position in the alphabet
                findReplace = alphabet.indexOf(letterGuess);
            
                if(findReplace>-1){ //if the letter is available in alphabet
                    //replaces letter in alphabet with /
                    alphabet = alphabet.substring(0,findReplace)+"/"
                            +alphabet.substring(findReplace+1); 
                    //determines whether guessed letter is in the secret word
                    extraSearchFind = secretWord.indexOf(letterGuess, extraPos);
                
                    while(findPos>-1){ //loop runs when findPos isn't -1
                        
                        //searches secret word to see if letter guessed is there
                        searchFind = secretWord.indexOf(letterGuess, extraPos);
                        //if letter is there
                        if(searchFind>-1){
                            //changes letters so now the letter is in there
                            letters = letters.substring(0,searchFind)+
                                    letterGuess+letters.substring(searchFind+1);
                            //you are closer to winning
                            winCode--; 
                            //person head moves one space right
                            personHead = " " + personHead;
                            //person body moves one space right
                            personBody = " " + personBody;
                            
                        //if extraSearchFind is -1    
                        }else if(extraSearchFind==-1){ 
                            //puts the hashtag at the end of the bridge
                            bridge = bridge.substring(0,numGuesses)+"#"+
                                    bridge.substring(numGuesses+1);
                            //you loss one guess
                            numGuesses--; 
                            System.out.println("You have " + numGuesses +
                                    " guesses left");
                        }
                        
                        //sets findPos to searchFind so it can keep a counter
                        findPos = searchFind;
                        //sets extraPos to searchFind+1, scan one ahead of value
                        extraPos = searchFind+1; 
                    
                    }
                //if not and is already a letter
                }else{ 
                    //puts the hashtag at the end of the bridge
                    bridge = bridge.substring(0,numGuesses)+"#"+
                            bridge.substring(numGuesses+1);
                    numGuesses--; //loss one guess
                    System.out.println("You have " + numGuesses +
                                    " guesses left");
                
                }
                //resets values
                findPos = 0;
                extraPos = 0;
                //prints everything
                System.out.println(letters);
                System.out.println(personHead);
                System.out.println(personBody);
                System.out.println(bridge);
                
            //runs if you still have guesses and you haven't won
            }while(numGuesses!=0 && winCode!=0); 
            
            //if you have won
            if(winCode == 0){
                System.out.println("            Congratulations, YOU WIN!!");
                System.out.println("");
            //if you have no more guesses    
            }else{
                System.out.println("            Unfortunately, you have "
                        + "skill issue :(");
                System.out.println("            The secret word was " 
                        + secretWord);
                System.out.println("");
            }

            System.out.print("Do you want to play again? (y/n) ");
            //clears keyboard gunk
            String gunk = s.nextLine();
            //asks user for letter
            yesNo = Character.toLowerCase(s.nextLine().charAt(0));
            //if yesNo is equal to y
            if(yesNo == 'y'){
                //resets all values
                alphabet = "abcdefghijklmnopqrstuvwxyz";
                personHead = " .";
                personBody = " X";
                bridge = "/";
                letters = "";
            //if yesNo is n    
            }else if(yesNo == 'n'){
                //prints out ending message
                System.out.println("");
                System.out.println("Thank you for playing BridgeIt");
            }
        //entire thing runs while yesNo is y, also do loop, so always runs once
        }while(yesNo == 'y');
        
        //closes scanner
        s.close();
        
    }
    
}
