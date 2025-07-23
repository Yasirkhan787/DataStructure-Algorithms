package arrayImplemenation;

import java.util.Scanner;

public class Array {


    Scanner sc = new Scanner(System.in);
    int N = 0;        // Number of elements in an Array
    int S = 0;        // Size of an Array
    int LB =  0;      // Indexing start from 0 (Lowest bound)
    int K = 0;        // Position for inserting element
    int item = 0;    // Element that is inserted or deleted from array
    int[] array;      // Array Declaration

    public Array(){

        // Taking input array size from user
        System.out.println("Enter the size of an Array");
        S= sc.nextInt();
        array = new int[S];
//        array[0] = 10;
//        array[1] = 30;
//        array[2] = 20;
//
//        N =3;

        arrayMenu();
    }

    // Array Menu
    public void arrayMenu(){

        int choice = 0;   //

        while(true)
        {
            System.out.println("\nSelect What you want to do in  an Array \n 1.Traverse \n 2.Insertion \n 3.Deletion \n 4.Searching \n 5.Sorting \n 6.Merging \n 7.Return To Main Menu");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 :
                    traverse(array);
                    break;
                case 2:
                    insertion(array);
                    break;
                case 3:
                    return;
            }
        }
    }

    public void traverse(int[] numbers){
        //If the number of element in Array is zero then the following statement is execute
        if(N == 0) {
            System.out.println("Array Is Empty");
            return;
        }

        System.out.println("1. Sequential (Linear) Traversal \n2. Reverse Traversal \n3. Return");
        int option = sc.nextInt();
        switch (option){
            case 1:
                linearTraverse(array);
                break;
            case 2:
                reverseTraverse(array);
                break;
            case 3:
                return;
        }

    }

    // 1. Traversing
    // Linear Traversing on an array
    public void linearTraverse(int[] array){

        System.out.print("The Element In Array are: [");
        for (int i = LB; i < array.length; i++){
            System.out.print(array[i] + "\t");
        }
        System.out.print("]");
    }
    // Reverse Traversing on an array
    public void reverseTraverse(int[] array){

        System.out.print("The Element In Array are: [");
        for (int i = array.length; i >= LB; i--){
            System.out.print(array[i] + "\t");
        }
        System.out.print("]");
    }

    // 2. Insertion in array
    public void insertion(int[] array) {

        // Checking if array is full or not
        if (N == S) {
            System.out.println("Array is full! insertion in not possible");
            return;
        }
        System.out.println("Enter the position where u want to insert element: ");
        K = sc.nextInt();

        // Checking the position is valid or not
        if (K < LB && K > N + LB - 1) {
            System.out.println("Invalid Position...");
            return;
        }
        // Input the value from user
        System.out.println("Enter the element that you want to insert: ");
        item = sc.nextInt();

        for (int i = (N + LB) - 1; i >= K; i--) {
            array[i + 1] = array[i];
        }
        array[K] = item;
        N++;
    }

    // 3. Deletion in array
}


/*
    // Insertion at first
    if (N == 0){
        sout("Enter the item")
        array[0] = item
    }
 */