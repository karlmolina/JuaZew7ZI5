/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esof322hw2;

import java.util.Arrays;

/**
 *
 * @author h89q624
 */
public class BubbleSort implements ISortStrategy{
    
    @Override
    public int[] sort(int[] input) {
        System.out.println("Bubble Sort executed.");
        Arrays.sort(input);
        return input;
    }
    
    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
