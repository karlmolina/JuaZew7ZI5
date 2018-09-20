package esof322hw2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ESOF322 HW 2 Client to choose math software
 * @author Karl Molina, Dana Parker
 */
public class Client {
    /**
     * Main method that lets you select a math software to sort numbers
     * with a default sort strategy
     * then keep that same math software but change the sort strategy
     * @param args
     */
    public static void main(String[] args) {
    	//numbers to sort
        int[] numbers = {9, 3, 6, 8, 7};
        Scanner in = new Scanner(System.in);
        
        //mathSoftware that holds the sorting strategies
        MathSoftware mathSoftware = null;
        System.out.println("You must sort these numbers: " + Arrays.toString(numbers));
        System.out.println("Which math software would you like to use to sort them?");
        System.out.println("Mathematica (1), MyMath (2), or MTool (3)?");
        
        //input chooses which software to use
        switch (in.nextInt()) {
            case 1:
                mathSoftware = new Mathematica();
                break;
            case 2:
                mathSoftware = new MyMath();
                break;
            case 3:
                mathSoftware = new MTool();
                break;
            default:
                System.out.println("You have entered an invalid number. Program terminated.");
                in.close();
                return;
        }
        
        System.out.println("Executing " + mathSoftware + "'s default sorting algorithm...");
        System.out.println("Your result is: " + Arrays.toString(mathSoftware.mathSort(numbers)));
        
        //new numbers to sort
        numbers = new int[] {5, 3, 1, 7, 2};
        System.out.println("\nYou must now sort these numbers: " + Arrays.toString(numbers));
        System.out.println("Which new sorting algorithm would you like to use?");
        System.out.println("InsertionSort (1), MergeSort (2), or BubbleSort (3)?");
        
        //input chooses which sort strategy to switch to
        switch (in.nextInt()) {
            case 1:
                mathSoftware.setSortStrategy(new InsertionSort());
                break;
            case 2:
                mathSoftware.setSortStrategy(new MergeSort());
                break;
            case 3:
                mathSoftware.setSortStrategy(new BubbleSort());
                break;
            default:
                System.out.println("You have entered an invalid number. Program terminated.");
                in.close();
                return;
        }
        in.close();
        
        System.out.println("Executing new sorting algorithm...");
        System.out.println("Your result is: " + Arrays.toString(mathSoftware.mathSort(numbers)));
    }
}

/**
 * Superclass from which Mathematica, MTool, and MyMath extends.
 * Defines setSortStrategy(), and mathSort().
 * Contains an instance of ISortStrategy.
 */
abstract class MathSoftware {
	
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

/**
 * A math software that has the default sort strategy of insertion sort.
 */
class Mathematica extends MathSoftware {
    
    public Mathematica() {
        System.out.println("Creating a new instance of the Mathematica software");
        sortStrategy = new InsertionSort();
    }
    
    @Override
    public String toString() {
        return "Mathematica";
    }
}

/**
 * A math software that has the default sort strategy of merge sort.
 */
class MTool extends MathSoftware {
    
    public MTool() {
        System.out.println("Creating new instance of the MTool software");
        sortStrategy = new MergeSort();
    }
    
    @Override
    public String toString() {
        return "MTool";
    }
}

/**
 * A math software that has the default sort strategy of bubble sort.
 */
class MyMath extends MathSoftware {
    
    public MyMath() {
        System.out.println("Creating a new instance of the MyMath software");
        sortStrategy = new BubbleSort();
    }
    
    @Override
    public String toString() {
        return "MyMath";
    }
}

/**
 * Interface that defines the method sort().
 */
interface ISortStrategy {
    
    public int[] sort(int[] input);
}

/**
 * The class that represents insertion sort.
 * Implements ISortStrategy with insertion sort.
 */
class InsertionSort implements ISortStrategy {

    @Override
    public int[] sort(int[] input) {
        System.out.println("Insertion Sort executed.");
        Arrays.sort(input);
        return input;
    }
    
    @Override
    public String toString() {
        return "Insertion Sort";
    }
}

/**
 * The class that represents merge sort.
 * Implements ISortStrategy with merge sort.
 */
class MergeSort implements ISortStrategy {
    
    @Override
    public int[] sort(int[] input) {
        System.out.println("Merge Sort executed.");
        Arrays.sort(input);
        return input;
    }
    
    @Override
    public String toString() {
        return "Merge Sort";
    }
}

/**
 * The class that represents bubble sort.
 * Implements ISortStrategy with bubble sort.
 */
class BubbleSort implements ISortStrategy{
    
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