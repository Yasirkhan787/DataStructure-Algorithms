package array.arrayQuestions;

public class Array {

    /*
        Problem 1: Third largest element in an array of distinct elements
        Given an array of n integers, the task is to find the third largest element. All the elements
        in the array are distinct integers.
        Examples :
        Input: arr[] = {1, 14, 2, 16, 10, 20}
        Output: 14
        Explanation: Largest element is 20, second largest element is 16 and third largest element is 14
        Input: arr[] = {19, -10, 20, 14, 2, 16, 10}
        Output: 16
        Explanation: Largest element is 20, second largest element is 19 and third largest element is 16
     */

    /*
        Problem 2: Maximum product of a triplet (subsequence of size 3) in array
        Given an integer array, find a maximum product of a triplet in the array.
        Examples:
        Input:  arr[ ] = [10, 3, 5, 6, 20]
        Output: 1200
        Explanation: Multiplication of 10, 6 and 20
        Input:  arr[ ] =  [-10, -3, -5, -6, -20]
        Output: -90
        Input: arr[ ] =  [1, -4, 3, -6, 7, 0]
        Output: 168
     */

    /*
        Problem 3: Maximum consecutive one’s (or zeros) in a binary array
        Given a binary array arr[] consisting of only 0s and 1s, find the length
        of the longest contiguous sequence of either 1s or 0s in the array.
        Examples :
        Input: arr[] = [0, 1, 0, 1, 1, 1, 1]
        Output: 4
        Explanation: The maximum number of consecutive 1’s in the array is 4 from index 3-6.
        Input: arr[] = [0, 0, 1, 0, 1, 0]
        Output: 2
        Explanation: The maximum number of consecutive 0’s in the array is 2 from index 0-1.
        Input: arr[] = [0, 0, 0, 0]
        Output: 4
        Explanation: The maximum number of consecutive 0’s in the array is 4.
     */
    public int maxConsectiveBits(int[] array) {

        // Base case
        if (array.length == 0)
            return 0;

        int count = 1;        // Keeps track of current sequence length
        int maxCount = 0;     // Stores the maximum length found so far

        // Start from the second element and compare with the previous
        for (int i = 1; i < array.length; i++) {
             /*
                You can check if two consecutive bits are the same using either:
                - if (array[i] == array[i - 1])            // more readable
                - if ((array[i] ^ array[i - 1]) == 0)      // XOR approach

                Why XOR works:
                0 ^ 0 = 0
                1 ^ 1 = 0
                So, if XOR result is 0 → both bits are equal
             */
            if (array[i] == array[i - 1]) {
                // Same as previous element → continue the streak
                count++;
            } else {
                // Streak breaks → update maxCount if current streak is longer
                maxCount = Math.max(maxCount, count);
                count = 1; // Reset count for the new streak
            }
        }

        // Handle the case where the longest streak is at the end of the array
        maxCount = Math.max(maxCount, count);

        return maxCount;
    }

    /*
        Problem 4: Move all zeros to end of array
        Given an array of integers arr[], the task is to move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.

        Examples:

        Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
        Output: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]
        Explanation: There are three 0s that are moved to the end.

        Input: arr[] = [10, 20, 30]
        Output: arr[] = [10, 20, 30]
        Explanation: No change in array as there are no 0s.

        Input: arr[] = [0, 0]
        Output: arr[] = [0, 0]
        Explanation: No change in array as there are all 0s.
     */
    public void pushZerosToEnd(int[] arr) {

        int count = 0;

        for (int i = 0; i<arr.length; i++){
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr [count];
                arr[count] = temp;
                count++;
            }
        }
    }
    /*
        Problem 5: Reverse an Array in groups of given size
        Given an array arr[] and an integer k, find the array after reversing every subarray of consecutive k elements in place. If the last subarray has fewer than k elements, reverse it as it is. Modify the array in place, do not return anything.

        Examples:

        Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8], k = 3
        Output: [3, 2, 1, 6, 5, 4, 8, 7]
        Explanation: Elements is reversed: [1, 2, 3] → [3, 2, 1], [4, 5, 6] → [6, 5, 4], and the last group [7, 8](size < 3) is reversed as [8, 7].

        Input: arr[] = [1, 2, 3, 4, 5], k = 3
        Output: [3, 2, 1, 5, 4]
        Explanation: First group consists of elements 1, 2, 3. Second group consists of 4, 5.

        Input: arr[] = [5, 6, 8, 9], k = 5
        Output: [9, 8, 6, 5]
        Explanation: Since k is greater than array size, the entire array is reversed.
     */
    public void reverseInGroups(int[] arr, int k){

        for (int i = 0; i< arr.length; i += k){

            int left = i;
            int right = Math.min((i + k) - 1, (arr.length) - 1);

            while (left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right]  = temp;
                left++;
                right--;
            }
        }
    }
}
