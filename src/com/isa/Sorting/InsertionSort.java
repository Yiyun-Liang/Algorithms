package com.isa.Sorting;

/**
 * Created by isa on 2017-01-23.
 */
public class InsertionSort {
    /*
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
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
