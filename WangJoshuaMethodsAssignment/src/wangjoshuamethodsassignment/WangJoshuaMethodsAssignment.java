/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wangjoshuamethodsassignment;

/**
 *
 * @author 340889765
 */
public class WangJoshuaMethodsAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(volumeOfCylinder(23,9));
    }
    public static double surfaceAreaOfRectangular(double l, double w, double h){
        double surfaceArea = 2*(l*w+l*h+w*h);
        surfaceArea = Math.round(surfaceArea*100)/100.0;
        return surfaceArea;
    }
    public static double volumeOfRectangular(double l, double w, double h){
        double volume = l*w*h;
        volume = Math.round(volume*100)/100.0;
        return volume;
    }
    public static double surfaceAreaOfCylinder(double r, double h){
        double surfaceArea = 2*Math.PI*r*(r+h);
        surfaceArea = Math.round(surfaceArea*100)/100.0;
        return surfaceArea;
    }
    public static double volumeOfCylinder(double r, double h){
        double volume = Math.PI*r*r*h;
        volume = Math.round(volume*100)/100.0;
        return volume;
    }
    public static double fahrenheitToCelcius(double fahr){
        double celcius = (fahr-32)*5/9;
        celcius = Math.round(celcius*100)/100.0;
        return celcius;
    }
    
}
