package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-04-25.
 */
public class LongestZigZagSubSeq {
    // http://www.geeksforgeeks.org/longest-zig-zag-subsequence/

    public static int max(int a, int b) {  return (a > b) ? a : b; }

    // Function to return longest Zig-Zag subsequence length
    public static int zzis(int arr[], int n){
        /*Z[i][0] = Length of the longest Zig-Zag subsequence
              ending at index i and last element is greater
              than its previous element
         Z[i][1] = Length of the longest Zig-Zag subsequence
              ending at index i and last element is smaller
              than its previous element   */
        int[][] Z = new int[n][2];

        /* Initialize all values from 1  */
        for (int i = 0; i < n; i++)
            Z[i][0] = Z[i][1] = 1;

        int res = 1; // Initialize result

        /* Compute values in bottom up manner */
        for (int i = 1; i < n; i++){
            // Consider all elements as previous of arr[i]
            for (int j = 0; j < i; j++){
                // If arr[i] is greater, then check with Z[j][1]
                if (arr[j] < arr[i] && Z[i][0] < Z[j][1] + 1)
                    Z[i][0] = Z[j][1] + 1;

                // If arr[i] is smaller, then check with Z[j][0]
                if( arr[j] > arr[i] && Z[i][1] < Z[j][0] + 1)
                    Z[i][1] = Z[j][0] + 1;
            }

        /* Pick maximum of both values at index i  */
            if (res < max(Z[i][0], Z[i][1]))
                res = max(Z[i][0], Z[i][1]);
        }

        return res;
    }

    /* Driver program */
    public static void main(String[] args){
        int arr[] = { 10, 22, 9, 33, 49, 50, 31, 60 };
        int n = arr.length;
        System.out.println("Length of Longest Zig-Zag subsequence is " + zzis(arr, n));
    }

}
