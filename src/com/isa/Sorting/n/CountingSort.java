package com.isa.Sorting.n;

/**
 * Created by isa on 2017-02-15.
 */
public class CountingSort {

    // numbers need to be in range [0, range]
    public static void sort(int[] arr, int range){
        int[] brr = new int[arr.length];
        sort(arr, brr, range);
        arr = brr;
    }

    // O(k+n)
    public static void sort(int[] arr, int[] brr, int k){
        // initialize to zeros
        int[] crr = new int[k+1];

        // contains the number of elements equal to i
        for(int j = 0; j < arr.length; j++){
            crr[arr[j]] += 1;
        }

        // contains the number of elements less than or equal to i
        for(int i = 1; i <= k; i++){
            crr[i] = crr[i] + crr[i-1];
        }

        // move to right position in final array brr, is stable
        for(int j = arr.length-1; j >= 0; j--){
            brr[crr[arr[j]]] = arr[j];
            crr[arr[j]] -= 1;
        }
    }
}
