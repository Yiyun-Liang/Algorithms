package com.isa.Sorting.quadraticOrNlgn;

/**
 * Created by isa on 2017-02-13.
 */
public class QuickSort {

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int lower, int upper){
        if(lower < upper){
            int mid = lower + (upper - lower)/2;
            int q = partition(arr, lower, upper);
            sort(arr, lower, q-1);
            sort(arr, q+1, upper);
        }
    }

    /*
        Bad partition takes O(n^2) - (n-1) and 0 causes T(n) = T(n-1) + O(n) = O(n^2)
        Good partition takes O(nlgn) - T(n) = 2T(n/2) + O(n) = O(nlgn)
     */
    public static int partition(int[] arr, int p, int r){
        int pivot = arr[r];
        int i = p-1;

        for(int j = p; j < r; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, r);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
