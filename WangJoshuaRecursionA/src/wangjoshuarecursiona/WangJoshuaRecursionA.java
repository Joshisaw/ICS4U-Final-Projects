/*
 * Method which generates meatballs which bounce using given values
 */
package wangjoshuarecursiona;

/**
 *
 * @author 340889765
 */

//import libraries
import java.util.Scanner;
import java.util.StringTokenizer;
public class WangJoshuaRecursionA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declare counter
        boolean loopCounter = true;
        //declare scanner
        Scanner s = new Scanner(System.in);
        //declares types to verify
        char [] typeHolderOne = {'i','d','d'};
        char [] typeHolderTwo = {'d','d','d'};
        
        //prints start message
        System.out.println("Welcome to MEATBALL Bouncer");
        //if loopCounter is true
        while(loopCounter){
            //print the menu
            printMenu();
            //accept user input
            String userInput = s.nextLine();
            switch(userInput){
                //if userInput is 1
                case "1":
                    //ask user for values
                    System.out.println("Please enter number of bounces (int), "
                            + "current height of the ball\n(double)"
                            + ", and decay factor (double) all seperated by commas: ");
                    String caseOneInput = s.nextLine();
                    //run tokenizer and generator for values
                    stringTokenizerOne(caseOneInput,typeHolderOne);
                break;
                //if userInput is 2
                case "2":
                    //ask user for values
                    System.out.println("Please enter current height of the ball "
                            + "(double), decay factor\n(double)"
                            + ", and threshold (double) all seperated by commas: ");
                    String caseTwoInput = s.nextLine();
                    //run tokenizer and generator for values
                    stringTokenizerTwo(caseTwoInput,typeHolderTwo);
                break;
                //if userInput is 3
                case "3":
                    //set loop to false
                    loopCounter = false;
                    //print exit prompt
                    System.out.println("\nThank you for playing!");
                break;
                //if any other value
                default:
                    //print error message
                    System.out.println("**Please enter a valid input**");
                break;
            }
        }

    }
    //method which prints menu
    public static void printMenu(){
        System.out.print("\n1. Simulate n times\n2. Simulate to threshold"
            + "\n3. Exit\nWhat do you wish to do(1,2,3): ");
    }
    
    //recursive method which generates values for ball bouncing
    public static double bounceOne(int curBounce, int numberOfBounce, double curHeight, double decayFactor){
        //if current bounce is greater than number of bounce
        if(curBounce>numberOfBounce){
            //return final decayed height (base case)
            return curHeight - curHeight * decayFactor;
        }else{
            //decay current height
            curHeight = curHeight - decayFactor*curHeight;
            //print out values
            System.out.println(curHeight + "\t\t" + curBounce);
            //recursive method where curBounce has ++
            return bounceOne(curBounce+1, numberOfBounce, curHeight, decayFactor);
        }
    }
    
    //tokenizer which accepts values and verifies
    public static double stringTokenizerOne(String userInput, char i[]){
        //declare all values
        boolean contVerify;
        int counter = 0;
        int curBounce = 1;
        int numberOfBounce = 0;
        double curHeight = 0;
        double decayFactor = 0;
        String curElement;
        //tokenizer with , as delimeter
        StringTokenizer st = new StringTokenizer(userInput, ",");
        //while more elements
        while(st.hasMoreElements()){
            switch (counter) {
                //if counter is 0
                case 0:
                    //find next element
                    curElement = st.nextElement().toString();
                    //verify if curElement is the right type
                    contVerify = typeVerify(curElement,i[counter]);
                    //if contVerify is true
                    if(contVerify){
                        //parse the next element and put into variable
                        numberOfBounce = Integer.parseInt(curElement);
                        //add 1 to counter
                        counter++;
                    //if not verified
                    }else{
                        //end switch case
                        counter = 999;
                    }   
                    break;
                //if counter is 1
                case 1:
                    //find next element
                    curElement = st.nextElement().toString();
                    //verify if curElement is the right type
                    contVerify = typeVerify(curElement,i[counter]);
                    //if contVerify is true
                    if(contVerify){
                        //parse the next element and put into variable
                        curHeight = Double.parseDouble(curElement);
                        //add 1 to counter
                        counter++;
                    //if not verified
                    }else{
                        //end switch case
                        counter = 999;
                    }   
                    break;
                //if counter is 2
                case 2:
                    //find next element
                    curElement = st.nextElement().toString();
                    //verify if curElement is the right type
                    contVerify = typeVerify(curElement,i[counter]);
                    //if contVerify is true
                    if(contVerify){
                        //set decayFactor to variable
                        decayFactor = Double.parseDouble(curElement);
                        //add 1 to counter
                        counter++;
                    //if not verified
                    }else{
                        //end switch case
                        counter = 999;
                    }   
                    break;
                //if any other value
                default:
                    //go to next value
                    curElement = st.nextElement().toString();
                    //end switch case
                    counter = 999;
                    break;
            }
        }
        //if counter isn't 3
        if(counter!=3){
            //print error message
            System.out.println("\n**ERROR, enter values properly**");
            //return 0
            return 0;
        //otherwise
        }else{
            //print top menu and run bounceOne
            System.out.println("Current Height\tAfter Bounce");
            return bounceOne(curBounce,numberOfBounce,curHeight,decayFactor);
        }
    }
    
    //method for second option for bounce
    public static double bounceTwo(double curHeight, int curBounce, double decayFactor, double threshold){
        //if curHeight is less than threshold
        if(curHeight<threshold){
            //return decayed height
            return curHeight - curHeight * decayFactor;
        }else{
            //decay current height
            curHeight = curHeight - curHeight * decayFactor;
            //print out menu
            System.out.println(curHeight + "\t\t" + curBounce);
            //recursive method to re run method
            return bounceTwo(curHeight,curBounce+1,decayFactor,threshold);
        }
    }
    
    //tokenizer that verifies and runs command for second bounce method
    public static double stringTokenizerTwo(String userInput, char[]i){
        //declare all variable
        boolean contVerify;
        int counter = 0;
        int curBounce = 1;
        double threshold = 0;
        double curHeight = 0;
        double decayFactor = 0;
        String curElement;
        //tokenizer with , delimeter
        StringTokenizer st = new StringTokenizer(userInput, ",");
        //while more elements
        while(st.hasMoreElements()){
            //store next element within variable
            curElement = st.nextElement().toString();
            switch (counter) {
                //if counter is 0
                case 0:
                    //verify type and return boolean
                    contVerify = typeVerify(curElement,i[counter]);
                    //if contVerify is true
                    if(contVerify){
                        //parse as double and store in variables
                        curHeight = Double.parseDouble(curElement);
                        //add 1 to counter
                        counter++;
                    //if not verified
                    }else{
                        //end switch case
                        counter = 999;
                    }   
                    break;
                //if counter is 1
                case 1:
                    //verify type and return boolean
                    contVerify = typeVerify(curElement,i[counter]);
                    //if contVerify is true
                    if(contVerify){
                        //set decayFactor as [arsed double
                        decayFactor = Double.parseDouble(curElement);
                        //add 1 to counter
                        counter++;
                    //if not verified
                    }else{
                        //end switch case
                        counter = 999;
                    }   
                    break;
                //if counter is 2
                case 2:
                    //verify type and return boolean
                    contVerify = typeVerify(curElement,i[counter]);
                    //if contVerify is true
                    if(contVerify){
                        //set threshold as parsed curElement
                        threshold = Double.parseDouble(curElement);
                        //add 1 to counter
                        counter++;
                    }else{
                        //end switch case
                        counter = 999;
                    }   
                    break;
                //if counter is anything else
                default:
                    //end switch case
                    counter = 999;
                    break;
            }
        }
        //if counter isn't 3
        if(counter!=3){
            //display error message
            System.out.println("\n**ERROR, enter values properly**");
            //return 0
            return 0;
        }else{
            //print top title
            System.out.println("Current Height\tAfter Bounce");
            //run bounceTwo method with variables
            return bounceTwo(curHeight,curBounce,decayFactor,threshold);
        }
    }
    
    //method that verifies type of element
    public static boolean typeVerify(String curElement, char i){
        //boolean declare
        boolean returnVal = false;
        //try catch statement just in case error
        try{
            switch(i){
                //if integer in char array
                case 'i':
                    //parse integer and store within variable
                    int intParse = Integer.parseInt(curElement);
                    //set return val to true
                    returnVal = true;
                break;
                //if double in char array
                case 'd':
                    //parse double and store within variable
                    double doubleParse = Double.parseDouble(curElement);
                    //set return val to true
                    returnVal = true;
                break;
            }
        //if error is NumberFormatException (wrong format)
        }catch(NumberFormatException e){
            //set returnVal to false
            returnVal = false;
        }
        //return boolean
        return returnVal;
    }
    
    
    
}
