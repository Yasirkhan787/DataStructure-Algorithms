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
}
