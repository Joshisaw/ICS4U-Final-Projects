/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wangjoshuacaesercipher;

/**
 *
 * @author 340889765
 */
import java.util.*;
public class WangJoshuaCaeserCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String [] commonStrings = {"th","he","te","er","in","nt","de","an","re"
            ,"in","nt","on","em","is","at","ed","nd","me","ng","to","as"};
        String [] common = {"be","and","of","in","to","have","it","that","for"
                ,"you","he","with","on","do","at","with","th","is","er"};
        boolean loopRepeat = true;
        while(loopRepeat){
            System.out.print("Encode(e) Decode(d) BruteForce(b) Quit(q): ");
            String userInput = s.nextLine();
            switch(userInput){
                case "e":
                    System.out.print("Phrase to encode: ");
                    String encodePhrase = s.nextLine();
                    while(encodePhrase.equals("")){
                        System.out.println("**That's empty**");
                        System.out.print("Phrase to encode: ");
                        encodePhrase = s.nextLine();
                    }
                    System.out.print("Shift right by: ");
                    int shiftCounter1 = s.nextInt();
                    while(shiftCounter1<0||shiftCounter1>25){
                        System.out.println("**Please enter a value 0-25 inclusive**");
                        System.out.print("Shift left by: ");
                        shiftCounter1 = s.nextInt();
                    }
                    String gunk1 = s.nextLine();
                    String encodedPhrase = encodeDecode(encodePhrase,shiftCounter1,userInput);
                    System.out.println("Encoded Phrase: "+encodedPhrase);
                break;
                case "d":
                    System.out.print("Phrase to decode: ");
                    String decodePhrase = s.nextLine();
                    while(decodePhrase.equals("")){
                        System.out.println("**That's empty**");
                        System.out.print("Phrase to decode: ");
                        decodePhrase = s.nextLine();
                    }
                    System.out.print("Shift left by: ");
                    int shiftCounter2 = s.nextInt();
                    while(shiftCounter2<0||shiftCounter2>25){
                        System.out.println("**Please enter a value 0-25 inclusive**");
                        System.out.print("Shift left by: ");
                        shiftCounter2 = s.nextInt();
                    }
                    String gunk2 = s.nextLine();
                    String decodedPhrase = encodeDecode(decodePhrase,shiftCounter2,userInput);
                    System.out.println("Decoded Phrase: "+decodedPhrase);
                break;
                case "b":
                    System.out.print("Phrase to Brute Force: ");
                    String bruteForcePhrase = s.nextLine();
                    String [] bruteForceArray = bruteForce(bruteForcePhrase);
                    int winningPhrase = bruteForceAnalysis(bruteForceArray,common);
                    System.out.println(winningPhrase);
                break;
                case "q":
                    System.out.println("\nThanks for playing!!!");
                    loopRepeat = false;
                break;
                default:
                    System.out.println("**That's not a valid command! "
                            + "Please enter e, d, b or q**");
                break;
            }
        }
    }
    
    public static String encodeDecode(String s, int i, String c){
        String encodedDecodedPhrase = "";
        switch(c){
            case "e":
            for(int x = 0;x<s.length();x++){
                int ascii = (int)s.charAt(x);
                if(ascii>=97 && ascii<=122){
                    ascii = ascii + i;
                    while(ascii>122){
                        ascii = ascii - 123;
                        ascii = 97 + ascii;
                    }
                    encodedDecodedPhrase = encodedDecodedPhrase + (char)ascii;
                }else if(ascii>=65 && ascii<=90){
                    ascii = ascii + i;
                    while(ascii>90){
                        ascii = ascii - 91;
                        ascii = 65 + ascii;
                    }
                    encodedDecodedPhrase = encodedDecodedPhrase + (char)ascii;
                }else{
                    encodedDecodedPhrase = encodedDecodedPhrase + (char)ascii;
                }
            }
            break;
            case "d":
                for(int x = 0;x<s.length();x++){
                    int ascii = (int)s.charAt(x);
                    if(ascii>=97 && ascii<=122){
                        ascii = ascii - i;
                        while(ascii<97){
                            ascii = 97 - ascii;
                            ascii = 123 - ascii;
                        }
                        encodedDecodedPhrase = encodedDecodedPhrase + (char)ascii;
                    }else if(ascii>=65 && ascii<=90){
                        ascii = ascii - i;
                        while(ascii<65){
                            ascii = 65 - ascii;
                            ascii = 91 - ascii;
                        }
                        encodedDecodedPhrase = encodedDecodedPhrase + (char)ascii;
                    }else{
                        encodedDecodedPhrase = encodedDecodedPhrase + (char)ascii;
                    }
                }
            break;
        }
        return encodedDecodedPhrase;
    }
    
    public static String[] bruteForce(String s){
        String [] decodedArray = new String[26];
        for(int i = 0;i<decodedArray.length;i++){
            decodedArray[i] = encodeDecode(s,(i+1),"d");
            System.out.println("For shift "+(i+1)+", decoded is: "+decodedArray[i]);
        }
        return decodedArray;
    }
    
    public static int bruteForceAnalysis(String [] s, String [] commonStrings){
        int returnValue = 0;
        int maxValue = 0;
        int arrayLength = commonStrings.length;
        int posIndex;
        for(int i = 0;i<26;i++){
            int pointCounter = 0;
            posIndex = 0;
            s[i] = s[i].toLowerCase();
            for(int x = 0;x<arrayLength;x++){
                //System.out.println(x);
                int indexFind = s[i].indexOf(commonStrings[x],posIndex);
                System.out.println(indexFind);
                while(indexFind>-1){
                    pointCounter++;
                    posIndex = indexFind+1;
                    indexFind = s[i].indexOf(commonStrings[x],posIndex);
                }
            }
            if(pointCounter>maxValue){
                returnValue = i+1;
                maxValue = pointCounter;
            }
            //System.out.println(pointCounter);
        }
        return returnValue;
    }
}
