package array.arrayImplementation;

import java.util.Arrays;
import java.util.Scanner;

public class Array {


    Scanner sc = new Scanner(System.in);
    int N = 0;        // Number of elements in an Array
    int S = 0;        // Size of an Array
    int LB = 0;      // Indexing start from 0 (Lowest bound)
    int K = 0;        // Position for inserting element
    int item = 0;    // Element that is inserted or deleted from array
    int[] array;      // Array Declaration

    public Array() {

        // Taking input array size from user
        System.out.println("Enter the size of an Array");
        S = sc.nextInt();
        array = new int[S];
        arrayMenu();
    }

    // Array Menu
    public void arrayMenu() {

        int choice = 0;   //

        while (true) {
            System.out.println("\nSelect What you want to do in  an Array \n 1.Traverse \n 2.Insertion \n 3.Deletion \n 4.Searching \n 5.Sorting \n 6.Merging \n 7.Return To Main Menu");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    traverse(array);
                    break;
                case 2:
                    insertion(array);
                    break;
                case 3:
                    deletion(array);
                    break;
                case 4:
                    searching(array);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // 1. Traversing
    public void traverse(int[] array) {
        // If the number of element in Array is zero then the following statement is execute
        if (N == 0) {
            System.out.println("Array Is Empty");
            return;
        }

        System.out.println("1. Sequential (Linear) Traversal \n2. Reverse Traversal \n3. Return");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                linearTraverse(array);
                break;
            case 2:
                reverseTraverse(array);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option!");
        }

    }

    // Linear Traversing on an array
    public void linearTraverse(int[] array) {

        System.out.print("The Element In Array are: [");
        for (int i = LB; i <= (N + LB) - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.print("]");
    }

    // Reverse Traversing on an array
    public void reverseTraverse(int[] array) {

        System.out.print("The Element In Array are: [");
        for (int i = (N + LB) - 1; i >= LB; i--) {
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
        // Input the position from user
        System.out.println("Enter the position where u want to insert element: ");
        K = sc.nextInt();

        // Checking the position is valid or not
        if (K < LB || K > (N + LB)) {
            System.out.println("Invalid Position for Insertion...");
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
        System.out.println(item + " is Successfuly Inserted....");
    }

    // 3. Deletion in array
    public void deletion(int[] array) {

        // Checking if array is empty or not
        if (N == 0){
            System.out.println("Array is empty! Deletion in not possible...");
            return;
        }
        // Input the position from user
        System.out.println("Enter the position where u want to delete element: ");
        K = sc.nextInt();
        // Checking the position is valid or not
        if (K < LB || K > (N + LB) - 1) {
            System.out.println("Invalid Position for Insertion...");
            return;
        }
        item = array[K];
        for (int i = K; i < N + LB; i++){
            array[i] = array[i + 1];
        }
        N--;
        System.out.println(item + " Is Sucessfuly Deleted...");
    }

    // Searching in an Array
    public void searching(int[] array){
        // Check if array is empty
        if (N == 0) {
            System.out.println("Array Is Empty No searching Possible");
            return;
        }

        // Getting element to search in an array
        System.out.println("Enter the element which u want to search: ");
        item = sc.nextInt();

        // Menu for selecting search type
        System.out.println("1. Sequential (Linear) search \n2. Binary Search \n3. Return");
        int option = sc.nextInt();
        switch (option) {
            case 1: // Linear Search
                System.out.println("1. Single Linear search \n2. Multi-Linear search \n3. Return");
                int opt = sc.nextInt();
                switch (opt) {
                    case 1: // Single Linear Search
                        singleLinearSearch(array, item);
                        break;
                    case 2: // Multi-Linear Search (find all occurrences)
                        multiLinearSearch(array, item);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 2: // Binary Search
                System.out.println("1. Single Binary Search \n2. Multi-Binary Search \n3. Return");
                int op = sc.nextInt();
                // NOTE: Binary Search only works on sorted arrays
                Arrays.sort(array); // Sort the array before binary search
                switch (op) {
                    case 1: // Single Binary Search
                        singleBinarySearch(array, item);
                        break;
                    case 2: // Multi-Binary Search (find all occurrences of a repeated number)
                        multiBinarySearch(array, item);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option!");
        }
    }

    // Single Linear Search
    public void singleLinearSearch(int[] array, int item){
        for(int i = LB; i< N+LB; i++){
            if( array[i] == item){
                System.out.println(item + " found at index " + i);
                return;
            }
        }
        System.out.println("Not found...");
    }

    // Multi-Linear Search
    public void multiLinearSearch(int[] array, int item){
        int count = 0;
        for(int i = LB; i< N+LB; i++){
            if( array[i] == item){
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println(item + "Not Found");
            return;
        }
        else
        {
            System.out.println(item + "Found " + count + " Times");
        }
    }

    // Single Binary Search
    public void singleBinarySearch(int[] array, int item){
        int low = LB;
        int high = N+LB-1;
        int mid;
        while(low<=high){
            mid = (low + high) / 2;
            if (array[mid] == item ){
                System.out.println(item +  "Found At " + mid +" Index");
                return;
            } else if (array[mid]<item) {
                low = mid + 1;
            } else{
                high = mid - 1;
            }
            System.out.println(item + "Not Found");
        }
    }

    // Multi-Binary Search
    public void multiBinarySearch(int[] array, int item){
        int low = LB;
        int high = N + LB - 1;
        int mid;
        int count = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (array[mid] == item) {
                count++;  // Count the mid item itself

                // Count to the left
                int i = mid - 1;
                while (i >= low && array[i] == item) {
                    count++;
                    i--;
                }

                // Count to the right
                i = mid + 1;
                while (i <= high && array[i] == item) {
                    count++;
                    i++;
                }

                System.out.println(item + " Found " + count + " Times");
                return;
            }
            else if (array[mid] < item) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        // Print this only once if not found
        System.out.println(item + " Not Found");
    }
}


