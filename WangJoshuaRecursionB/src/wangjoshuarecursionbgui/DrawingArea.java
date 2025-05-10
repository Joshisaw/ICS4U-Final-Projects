/*
Area that draws all of the components (background, images, sound etc)
 */
package wangjoshuarecursionbgui;

/**
 *
 * @author 340889765
 */
//all libraries imported
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class DrawingArea extends javax.swing.JPanel {
    
    //declares images
    Image background, character, wall;
    
    //declares all GUI variables
    private static int counter = -1;
    private static boolean startCounter = false;
    static Timer t1;
    private static ArrayList<Integer> coordinates = new ArrayList<Integer>();
    private static int objectX = 0;
    private static int objectY = 470;
    private static int wallLength = 700;
    private static double distanceFactor = 0.5;
    private static int speedOfBall = 50;
    
    //part 8
    //declares all sound variables
    static String bounceEffect = "BounceSound.wav";
    static String yaySound = "Yay.wav";
    static SoundPlayer soundPlayer = new SoundPlayer();

    /**
     * Creates new form DrawingArea
     */
    public DrawingArea() {
        initComponents();
        
        //part 7
        //gets image from file
        background = Toolkit.getDefaultToolkit().getImage("PixelBackground.png");
        character = Toolkit.getDefaultToolkit().getImage("Tigger.png");
        wall = Toolkit.getDefaultToolkit().getImage("theWall.png");
        
        //starts timer
        t1 = new Timer(speedOfBall, new DrawingArea.TimerListener());
        t1.start();
        setFocusable(true);
    }
    /**
     * constantly paints panel
     * @param g Graphics
     */
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //part 7
        //generate background and wall
        g.drawImage(background, 0, 0, this);
        g.drawImage(wall, wallLength, 0, this);
        //if startCounter is true
        if(startCounter){
            try{
                //increase counter to read through ArrayList
                counter++;
                objectX = coordinates.get(counter);
                counter++;
                objectY = coordinates.get(counter);
                //part 7
                //generates Tigger
                g.drawImage(character, objectX, objectY, this);
            //if array out of bound (at end of distance)
            }catch(Exception ae){
                //sets x and y as last coordinates in ArrayList
                objectX = coordinates.get(coordinates.size()-2);
                objectY = coordinates.get(coordinates.size()-1);
                //part 8
                //plays end sound
                soundPlayer.play(yaySound);
                //sets startCounter to false
                startCounter = false;
            }
        //if hasn't started
        }else{
            //just draw image in place
            g.drawImage(character, objectX, objectY, this);
        }
    }
    
    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            //repaints frame
            repaint();
        }
    }
    
    /**
     * part 8
     * Setter that sets wall distance to variable
     * @param wallDistance int of wall distance
     */
    public static void setWall(int wallDistance){
        wallLength = wallDistance;
    }
    
    /**
     * This method starts the launching of the object
     */
    public static void startObject(){
        //part 5
        //generates coordinates
        coordinateGenerator(wallLength,0,0,coordinates);
        //sets counter to true
        startCounter = true;
        //sets new timer counter to delay or make faster
        t1.setDelay(speedOfBall);
        //part 8
        //plays bounce sound
        soundPlayer.play(bounceEffect);
        
        //part 6
        //for loop that prints out parabola with stars
        System.out.println("\nParabola:");
        //based on coordinates size and all odd numbers
        for(int i = 1;i<coordinates.size();i=i+2){
            //scaled down height
            int parabolaHeight = (480-coordinates.get(i))/10;
            //another for loop that prints out stars
            for(int s = 0;s<parabolaHeight;s++){
                System.out.print("*");
            }
            //prints out space
            System.out.println();
        }
    }
    
    //resets all values
    public static void resetValues(){
        //clear ArrayList and resets counter
        coordinates.clear();
        counter = -1;
    }
    
    /**
     * part 8
     * setter to get decay factor from slider
     * @param decayFactor int which is factor to change height of ball
     */
    public static void setDecayFactor(int decayFactor){
        distanceFactor = decayFactor*0.01;
    }
    
    /**
     * part 8
     * Setter that gets speedFactor from sliders
     * @param speedFactor int is the speed of the timer
     */
    public static void setSpeed(int speedFactor){
        speedOfBall = speedFactor;
    }
    
    //part a
    //method that returns array list of coordinates
    public static ArrayList<Integer> coordinateGenerator(int distanceX, int xIntercept1, int xIntercept2, ArrayList<Integer> coordinates){
        //declares variables for method
        int newYPoint;
        int newDistanceX = 470;
        //if distance is less than 1 (base case)
        if(distanceX<1){
            //return coordinates
            return coordinates;
        //otherwise
        }else{
            //part 8
            //finds new distance based on % distance jumped
            distanceX = (int)((wallLength-xIntercept1)*distanceFactor);
            //set x value 2 as 1st
            xIntercept2 = xIntercept1;
            //add distanceX to x value 1
            xIntercept1 = xIntercept1+distanceX;
            //for loop that generates x values
            for(int s = xIntercept2;s<xIntercept1;s=s+10){
                //part 2
                //adds x value
                coordinates.add(s);
                //generates y value
                newYPoint = (int)(-0.01*(s-xIntercept1)*(s-xIntercept2));
                newYPoint = newDistanceX - newYPoint;
                //part 2
                coordinates.add(newYPoint);
            }
            //part 3
            //recursive method return
            return coordinateGenerator(distanceX,xIntercept1,xIntercept2, coordinates);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
