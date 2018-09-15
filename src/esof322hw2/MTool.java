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
public class MTool extends MathSoftware {
    
    public MTool() {
        System.out.println("Creating new instance of the MTool software");
        sortStrategy = new MergeSort();
    }
    
    @Override
    public String toString() {
        return "MTool";
    }
}
