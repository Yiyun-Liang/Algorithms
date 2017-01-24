package com.isa.Sorting;

/**
 * Created by isa on 2017-01-23.
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i = 1; i<arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = key;
        }
    }
}
