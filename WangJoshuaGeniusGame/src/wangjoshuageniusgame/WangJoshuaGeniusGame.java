/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wangjoshuageniusgame;

/**
 *
 * @author 340889765
 */
import java.util.Scanner;
public class WangJoshuaGeniusGame {

    public static int updateBoard(char[]secretWord, char[]usersGuess, int numLetters, int correctCounter){
        for(int i = 0; i<numLetters;i++){
            if(secretWord[i]==usersGuess[i]){
                correctCounter++;
            }
        }
        return correctCounter;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        char [] secretWord = new char [10];
        char [] usersGuess = new char [10];
        int numLetters;
        int randomChar;
        int correctCounter = 0;
        int wrongCounter = 0;
        int roundCounter = 1;
        String blank = " ";
        String introLetters = "";
        String usersGuessString;
        
        System.out.printf("*****GENIUS*****\n");
        System.out.printf("How many letters in a guess? ");
        numLetters = s.nextInt();
        String gunk = s.nextLine();
        for(int i = 0; i<numLetters ; i++){
            randomChar = (int) (Math.random()*3)+1;
            if(randomChar == 1){
                secretWord[i] = 'r';
                System.out.printf("%c\n",secretWord[i]);
            }else if(randomChar == 2){
                secretWord[i] = 'g';
                System.out.printf("%c\n",secretWord[i]);
            }else if(randomChar == 3){
                secretWord[i] = 'b';
                System.out.printf("%c\n",secretWord[i]);
            }
        }
        for(int i = 0; i<numLetters ; i++){
            introLetters = introLetters +"| " + usersGuess[i] + " ";
        }
        while(correctCounter != 4){
            correctCounter = 0;
            System.out.printf("%50s%s|\n",blank,introLetters);
            System.out.printf("Round:%2d%2sPlease guess%2d characters rgb: ",roundCounter,blank,numLetters);
            usersGuessString = s.nextLine();
            for(int i = 0; i<numLetters;i++){
                usersGuess[i] = usersGuessString.charAt(i);
            }
            correctCounter = updateBoard(secretWord,usersGuess,numLetters,correctCounter);
            wrongCounter = numLetters-correctCounter;
            System.out.println(correctCounter);
            roundCounter++;
        }
    }
}
