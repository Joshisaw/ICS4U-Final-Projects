/*
 * menu for taking off planes and having them arrive
 */
package mywangjoshuaairplanesimulatorgui;

/**
 *
 * @author 340889765
 */
//import libraries
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.Timer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WangJoshuaAirplaneSimulatorGUI extends javax.swing.JFrame {
    //declares all variables
    public static Queue<Integer> landing = new LinkedList<Integer>();
    public static Queue<Integer> takeOff = new LinkedList<Integer>();
    static Timer t;
    static int curTime = 4;
    static int curTakeOffTime = 2;
    static int counter = 0;
    static boolean startPressed = false;
    
    //declares text files
    static File takeoffFile = new File("takeoffs.txt");
    static File arrivalsFile = new File("arrivals.txt");
    
    /**
     * Creates new form WangJoshuaAirplaneSimulatorGUI
     */
    public WangJoshuaAirplaneSimulatorGUI() throws FileNotFoundException{
        initComponents();
        readFileOne();
        readFileTwo();
        //declares and starts timer
        t = new Timer(600, new TimerListener());
        t.start();
    }
    
    public void readFileOne() throws FileNotFoundException{
        //declares scanner with take off file
        Scanner fileReader = new Scanner(takeoffFile);
        int placeHolder;
        //for loop that adds to takeOff text files
        for(int i = 0; i<4 ; i++){
            placeHolder = fileReader.nextInt();
            takeOff.add(placeHolder);
        }
        //updates queue
        takeOff = updateQueues(takeOff,2);
    }
    
    public void readFileTwo() throws FileNotFoundException{
        //declares scanner with arrivals file
        Scanner fileReaderTwo = new Scanner(arrivalsFile);
        int placeHolder;
        //for loop that adds to arrivals files
        for(int i = 0; i<4 ; i++){
            placeHolder = fileReaderTwo.nextInt();
            landing.add(placeHolder);
        }
        //updates queue
        landing = updateQueues(landing,1);
    }
    
    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
           //if start has been pressed
            if(startPressed){
                //if both queues are empty
                if(landing.isEmpty() && takeOff.isEmpty()){
                    //don't generate plane
                    DrawingArea.setBooleanPlane(false);
                //if both queues aren't empty
                }else{
                    //plane can be generated
                    DrawingArea.setBooleanPlane(true);
                }
                //if queue isn't empty and counter isn't 2
                //landing
                if(!landing.isEmpty() && counter != 2){
                    //returns time and boolean values for animation
                    DrawingArea.setTime(curTime);
                    DrawingArea.setTakeOff(false);
                    DrawingArea.setArrivals(true);
                    //if time is 0
                    if(curTime == 0){
                        //display land message
                        jLabel6.setText("Plane has landed");
                    }else{
                        //display message with time
                        jLabel6.setText("Flight " + landing.peek() + " is landing in " + curTime);
                    }
                    //subtracts from cur time
                    curTime--;
                    //if cur time is less than 0
                    if(curTime<0){
                        //resets cur time
                        curTime = 4;
                        //remove from queue
                        landing.remove();
                        //update text field
                        landing = updateQueues(landing,1);
                        //if other queue is empty
                        if(takeOff.isEmpty()){
                            //sets counter to 0 to continue running
                            counter = 0;
                        //otherwise increase counter
                        }else{
                            counter++;
                        }
                    }
                //if takeoff queue isn't empty and counter is 2
                }else if(!takeOff.isEmpty() && counter == 2){
                    //returns time and boolean values for airplane animation
                    DrawingArea.setTime(curTakeOffTime);
                    DrawingArea.setTakeOff(true);
                    DrawingArea.setArrivals(false);
                    //if cur time is 0
                    if(curTakeOffTime == 0){
                        //display take off message
                        jLabel6.setText("Plane has taken off");
                    //otherwise display message that shows time
                    }else{
                        jLabel6.setText("Flight " + takeOff.peek() + " is takin"
                                + "g off in " + curTakeOffTime);
                    }
                    //subtract from cur time counter
                    curTakeOffTime--;
                    //if cur time is less than 0
                    if(curTakeOffTime<0){
                        //reset cur time
                        curTakeOffTime = 2;
                        //remove from queue
                        takeOff.remove();
                        //update field
                        takeOff = updateQueues(takeOff,2);
                        //if landing is empty
                        if(landing.isEmpty()){
                            //set counter to 2 so it runs again
                            counter = 2;
                        //else run the other command
                        }else{
                            counter = 0;
                        }
                    }
                //if takeOff isn't empty, landing is empty and counter isn't 2
                }else if(!takeOff.isEmpty() && landing.isEmpty() && counter!=2){
                    //switch to 2
                    counter = 2;
                //if takeOff is empty and landing isn't empty and counter is 2
                }else if(takeOff.isEmpty() && !landing.isEmpty() && counter==2){
                    //switch counter to zero
                    counter = 0;
                }
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        drawingArea1 = new mywangjoshuaairplanesimulatorgui.DrawingArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Arriving Flight:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Takeoff Flight:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Arriving");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Takeoffs");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Press \"start\" to begin simulation.");

        jLabel7.setText("Announcer:");

        startButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        startButton.setText("Start");
        startButton.setFocusable(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout drawingArea1Layout = new javax.swing.GroupLayout(drawingArea1);
        drawingArea1.setLayout(drawingArea1Layout);
        drawingArea1Layout.setHorizontalGroup(
            drawingArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        drawingArea1Layout.setVerticalGroup(
            drawingArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(startButton)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawingArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(drawingArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(startButton)
                        .addGap(121, 121, 121)))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Airplane Simulator - Joshua Wang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //quit button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //exits program
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    //if button has been pressed
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        //set start pressed to true and return to drawing area
        startPressed = true;
        DrawingArea.setBoolean(startPressed);
    }//GEN-LAST:event_startButtonActionPerformed

    //if enter has been pressed with text field 1
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        //get key value
        int key = evt.getKeyCode();
        //if enter has been pressed
        if(key == 10){
            //try
            try{
                //get jTextField and parse to int
                int queueSpot = Integer.parseInt(jTextField1.getText());
                //set error message to empty
                jLabel8.setText("");
                //if it is greater than 0
                if(queueSpot>0){
                    //add to queue
                    landing.add(queueSpot);
                //otherwise display error message
                }else{
                    jLabel8.setText("Incorrect value, try again");
                }
                //clear text field
                jTextField1.setText("");
            //if incorrect format
            }catch(NumberFormatException e){
                //display error message and clear text field
                jLabel8.setText("Incorrect value, try again");
                jTextField1.setText("");
            }
            //update queue
            landing = updateQueues(landing,1);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    //if enter has been pressed with j text field 2
    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        //get key pressed and converts to value
        int key = evt.getKeyCode();
        //if enter has been pressed
        if(key == 10){
            //try
            try{
                //gets jtextfield 2 value and parse to an int
                int queueSpot = Integer.parseInt(jTextField2.getText());
                //clears error message
                jLabel9.setText("");
                //if int is greater than 0
                if(queueSpot>0){
                    //add to queue
                    takeOff.add(queueSpot);
                //else display error message
                }else{
                    jLabel9.setText("Incorrect value, try again");
                }
                //clears text field 2
                jTextField2.setText("");
            //if wrong value is parsed and has error
            }catch(NumberFormatException e){
                //display error message and clear text field
                jLabel9.setText("Incorrect value, try again");
                jTextField2.setText("");
            }
            //update queue
            takeOff = updateQueues(takeOff,2);
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WangJoshuaAirplaneSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WangJoshuaAirplaneSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WangJoshuaAirplaneSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WangJoshuaAirplaneSimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new WangJoshuaAirplaneSimulatorGUI().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(WangJoshuaAirplaneSimulatorGUI.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    //updates queues and updates text area
    public Queue updateQueues(Queue inputQueue, int textAreaCode){
        //creates a backup queue
        Queue<Integer> backup = new LinkedList<Integer>();
        //creates output string
        String outputCode = "";
        //loops is input queue isn't empty
        while(!inputQueue.isEmpty()){
            //adds to backup queue
            backup.add((int)inputQueue.peek());
            //remove and add to output code
            outputCode = outputCode + inputQueue.remove() + "\n";
        }
        //switch case
        switch(textAreaCode){
            //if it is 1
            case 1:
                //add to arriving text area
                jTextArea1.setText(outputCode);
            break;
            //if it is 2
            case 2:
                //add to take off text area
                jTextArea2.setText(outputCode);
            break;
        }
        //returns backup queue to original
        return backup;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mywangjoshuaairplanesimulatorgui.DrawingArea drawingArea1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
