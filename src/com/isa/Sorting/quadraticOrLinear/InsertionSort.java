package com.isa.Sorting.quadraticOrLinear;

/**
 * Created by isa on 2017-01-23.
 */
public class InsertionSort {
    /*
     * Time complexity: O(n^2)
     *          - uses n^2/4 compares and n^2/4 swaps on average
     * Space complexity: O(1)
     *
     * Def: partially sorted - number of inversions is <= cN
     *      - for partially sorted arrays, insertion sort runs in linear time
     *      - number of compares = inversions or swaps + (n-1)
     *      - (n-1) compares except the first element, if sorted then only (n-1) compares
     */

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = key;
        }
    }

    // ? not working
    public static int insertionSortRecursive(int[] arr, int maxIndex){
        if(maxIndex <= 1){
            return maxIndex;
        }

        maxIndex = insertionSortRecursive(arr, maxIndex-1);

        int key = arr[maxIndex];
        int i = maxIndex - 1;
        while(i >= 0 && arr[i] > key){
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = key;
        return maxIndex + 1;
    }
}
