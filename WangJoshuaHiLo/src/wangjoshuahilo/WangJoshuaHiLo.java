
package wangjoshuahilo;

//Joshua Wang - ICS3U Computer Science - February 27, 2023
//340889765
/*This program generates a number 1-5 and asks the user to guess it
If it's to low, it tells the user that. If it's to high, it tells the user that
If the number is right, it is told, and you can play again
*/

import java.util.Scanner; //imports Scanner
public class WangJoshuaHiLo {

    public static void main(String[] args) {
        //declares Scanner variable
        Scanner s = new Scanner(System.in);
        //declares variable for amount of guesses
        int guessCounter = 0; 
        //declares variable for the integer the user will input
        int inputtedGuess = 0;
        //declares the random number integer
        int randomNum1To5; 
        //declares the playAgain count to a so it is initialized
        boolean playAgain = true; 
        //declares variable to determine yes or no for playing again
        char yesNo;
        
        //Introduction and ASCII art of spongebob. Looks cursed
        System.out.println("Welcome to the HiLo game. It's time to guess!");
        System.out.println("\u2593\u2593\u2593\u2593\u2593\u2593\u2593\u2593"
                + "\u2593");
        System.out.println("\u2593\u2592\u2591\u2592\u2592\u2592\u2591\u2592"
                + "\u2593");
        System.out.println("\u2593\u2591\u2593\u2591\u2592\u2591\u2593\u2591"
                + "\u2593");
        System.out.println("\u2593\u2592\u2591\u2592\u2592\u2592\u2591\u2592"
                + "\u2593");
        System.out.println("\u2593\u2592\u2592\u2592\u2592\u2592\u2592\u2592"
                + "\u2593");
        System.out.println("\u2593\u2592\u2593\u2592\u2592\u2592\u2593\u2592"
                + "\u2593");
        System.out.println("\u2593\u2592\u2592\u2593\u2593\u2593\u2592\u2592"
                + "\u2593");
        System.out.println("\u2593\u2593\u2593\u2593\u2593\u2593\u2593\u2593"
                + "\u2593");
        System.out.println("\u005F\u005F\u005F\u2593\u005F\u005F\u005F\u005F"
                + "\u2593");
        System.out.println("\u005F\u005F\u005F\u2593\u005F\u005F\u005F\u005F"
                + "\u2593");
        System.out.println("\u005F\u005F\u005F\u2593\u005F\u005F\u005F\u005F"
                + "\u2593");
        System.out.println("\u005F\u005F\u2593\u2593\u005F\u005F\u005F"
                + "\u005F\u2593\u2593");
                
        //do loop around program so it runs at least once at the beginning
        do{
            //Sets randomNum1To5 to a random number 1-5
            randomNum1To5 = (int) (Math.random()*5)+1;
            System.out.println("The number is " + randomNum1To5);
            
            //if the user guess isn't equal to the random number
            while(inputtedGuess!=randomNum1To5){ 
            
                System.out.print("Please enter an integer from 1 to 5 "
                        + "inclusive: ");
                   //declares variable as user's inputted number
                   inputtedGuess = s.nextInt(); 
                //if inputted number's greater than random number
                if(inputtedGuess>randomNum1To5){ 
                    //add 1 to guessCounter
                    guessCounter++; 
                    System.out.println("That's TOO HIGH");
                }
                //if inputted number's less than random number
                else if(inputtedGuess<randomNum1To5){
                    //add 1 to guessCounter
                    guessCounter++;
                    System.out.println("That's TOO LOW");
                //if inputted number is the number itself    
                }else {
                  //add 1 to guessCounter, because the right guess is still one  
                  guessCounter++;
              }
            }
           //Declares that you won and displays the guessCounter after loop
           System.out.println("You WIN! It took you " + guessCounter + " tries "
                   + "to guess the number");
           
           System.out.print("Do you want to play again? (y/n): ");
           //clears out scanner gunk
           String gunk = s.nextLine();
           //sets yesNo as the user's char input
           yesNo = Character.toLowerCase(s.nextLine().charAt(0));
           //if yesNo is equal to y
           if(yesNo == 'y'){
               //Sets all variables to default value and playAgain to true
               playAgain = true; //this isn't necessary but for show
               inputtedGuess = 0;
               guessCounter = 0;
            //if yesNo is equal to n   
           }else if(yesNo == 'n'){
               //Sets playAgain variable to false to terminate the loop
               playAgain = false; 
           }
        //loop will run if playAgain is true   
        }while(playAgain == true);
        
        //ASCII Art of Patrick (to lazy to do body)
        System.out.println("\u005F\u005F\u005F\u005F\u2593");
        System.out.println("\u005F\u005F\u005F\u2593\u2592\u2593");
        System.out.println("\u005F\u005F\u2593\u2591\u2592\u2591\u2593");
        System.out.println("\u005F\u2593\u2591\u2593\u2591\u2593\u2591\u2593");
        System.out.println("\u2593\u2592\u2591\u2592\u2592\u2591\u2592\u2593");
        System.out.println("\u2593\u2592\u2593\u2592\u2592\u2593\u2592\u2593");
        System.out.println("\u2593\u2592\u2592\u2593\u2593\u2592\u2592\u2593");
        System.out.println("\u2593\u2592\u2592\u2592\u2592\u2592\u2592\u2593");
        System.out.println("\u2593\u2593\u2593\u2593\u2593\u2593\u2593\u2593");
        //Ending message
        System.out.println("Thanks for playing HiLo");
        
        //closes the scanner
        s.close();

    }
    
}
