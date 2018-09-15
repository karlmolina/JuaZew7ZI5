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
public class MyMath extends MathSoftware {
    
    public MyMath() {
        System.out.println("Creating a new instance of the MyMath software");
        sortStrategy = new BubbleSort();
    }
    
    @Override
    public String toString() {
        return "MyMath";
    }
}
