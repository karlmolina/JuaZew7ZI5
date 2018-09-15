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
public abstract class MathSoftware {
    
    protected ISortStrategy sortStrategy;
    
    public void setSortStrategy(ISortStrategy sortStrategy) {
        System.out.println("Setting your math software's sorting algorithm to " + sortStrategy);
        this.sortStrategy = sortStrategy;
    }
    
    public int[] mathSort(int[] input) {
        System.out.println("Sorting the numbers using " + sortStrategy);
        return sortStrategy.sort(input);
    }
}
