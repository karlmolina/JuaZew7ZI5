/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esof322hw2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ESOF322 HW 1 Client to choose math software
 * @author h89q624
 */
public class Client {
    /**
     * Main method that allows you to select the math software twice
     * @param args 
     */
    public static void main(String[] args) {
        int[] numbers = {9, 3, 6, 8, 7};
        Scanner in = new Scanner(System.in);
        MathSoftware mathSoftware = null;
        System.out.println("You must sort these numbers: " + Arrays.toString(numbers));
        System.out.println("Which math software would you like to use to sort them?");
        System.out.println("Mathematica (1), MyMath (2), or MTool (3)?");
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
                return;
        }
        
        System.out.println("Executing " + mathSoftware + "'s default sorting algorithm...");
        System.out.println("Your result is: " + Arrays.toString(mathSoftware.mathSort(numbers)));
        
        numbers = new int[] {5, 3, 1, 7, 2};
        System.out.println("\nYou must now sort these numbers: " + Arrays.toString(numbers));
        System.out.println("Which new sorting algorithm would you like to use?");
        System.out.println("InsertionSort (1), MergeSort (2), or BubbleSort (3)?");
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
                return;
        }
        
        System.out.println("Executing new sorting algorithm...");
        
        System.out.println("Your result is: " + Arrays.toString(mathSoftware.mathSort(numbers)));
    }
}
