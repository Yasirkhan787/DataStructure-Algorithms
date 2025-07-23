package array.arrayConcepts;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        // Declaring and Allocating memory (or initializing an array with a fixed size).
        int[] numbers = new int[5];

        // Declaring and initializing an array with values(directly initializing).
        String[] fruits = {"Apple", "Banana", "Mango"};

        // Initializing array using indexes.
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;

        // Initializing array using for loop.
        int[] integerArray = new int[5];
        for(int i=0; i<integerArray.length; i++){
            integerArray[i] = i*10;
        }

        // Taking user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array values: ");
        for (int i=0; i<integerArray.length; i++){
            System.out.println((i+1) + "value: ");
            integerArray[i] = sc.nextInt();
        }
    }

}


