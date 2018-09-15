/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esof322hw2;

/**
 *
 * @author h89q624
 */
public class Mathematica extends MathSoftware {
    
    public Mathematica() {
        System.out.println("Creating a new instance of the Mathematica software");
        sortStrategy = new InsertionSort();
    }
    
    @Override
    public String toString() {
        return "Mathematica";
    }
}
