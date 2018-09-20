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
        System.out.println("Mathematica (1), MTool (2), or MyMath (3)?");
        
        //input chooses which software to use
        switch (in.nextInt()) {
            case 1:
                mathSoftware = new Mathematica();
                break;
            case 2:
                mathSoftware = new MTool();
                break;
            case 3:
                mathSoftware = new MyMath();
                break;
            default:
                System.out.println("You have entered an invalid number. Program terminated.");
                in.close();
                return;
        }
        
        System.out.println("Executing " + mathSoftware + "'s default sorting algorithm...");
        mathSoftware.mathSort(numbers);
        System.out.println("Your result is: " + Arrays.toString(numbers));
        
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
        mathSoftware.mathSort(numbers);
        System.out.println("Your result is: " + Arrays.toString(numbers));
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
        System.out.println("Setting your math software's (" + this + ") sorting algorithm to " + sortStrategy);
        this.sortStrategy = sortStrategy;
    }
    
    public void mathSort(int[] input) {
        System.out.println("Sorting the numbers using " + sortStrategy);
        sortStrategy.sort(input);
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
    
    public void sort(int[] input);
}

/**
 * The class that represents insertion sort.
 * Implements ISortStrategy with insertion sort.
 * Implementation from https://www.geeksforgeeks.org/insertion-sort/
 */
class InsertionSort implements ISortStrategy {
	
	/**
	 * Implementation of Insertion Sort taken from 
	 * https://www.geeksforgeeks.org/insertion-sort/
	 */
    @Override
    public void sort(int[] arr) {
        System.out.println("Insertion Sort executed.");
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
    
    @Override
    public String toString() {
        return "Insertion Sort";
    }
}

/**
 * The class that represents merge sort.
 * Implements ISortStrategy with merge sort.
 * Implementation from https://www.geeksforgeeks.org/merge-sort/
 */
class MergeSort implements ISortStrategy {
    
	/**
	 * Sort function that uses the help merge sort functions
	 */
	@Override
	public void sort(int[] input) {
		System.out.println("Merge Sort executed.");
		sort(input, 0, input.length-1);
	}
	
	/**
	 * Sort helper function
	 * Implementation of merge sort
	 * taken from https://www.geeksforgeeks.org/merge-sort/
	 */
    private void sort(int[] arr, int l, int r) {
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }
    
    /**
     * Merge sort helper function
     * taken from https://www.geeksforgeeks.org/merge-sort/
     * Merges two subarrays of arr[]. 
     * First subarray is arr[l..m] 
     * Second subarray is arr[m+1..r] 
     */
    private void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
    
    @Override
    public String toString() {
        return "Merge Sort";
    }
}

/**
 * The class that represents bubble sort.
 * Implements ISortStrategy with bubble sort.
 * Implementation taken from https://www.geeksforgeeks.org/bubble-sort/
 */
class BubbleSort implements ISortStrategy{
    
	/**
	 * Implemenation of Bubble Sort
	 * taken from https://www.geeksforgeeks.org/bubble-sort/
	 */
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble Sort executed.");
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    
    @Override
    public String toString() {
        return "Bubble Sort";
    }
}