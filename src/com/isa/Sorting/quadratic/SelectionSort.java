package com.isa.Sorting.quadratic;

/**
 * Created by isa on 2017-02-11.
 */
public class SelectionSort {

    /*
        Time Complexity: O(n^2) = (n-1)+(n-2)+...+1+0 = n^2/2
                        No matter what input we give, always quadratic time....
     */

    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
