package com.isa.Sorting;

/**
 * Created by isa on 2017-02-11.
 */
public class ShellSort {

    /*
        Unlike insertion sort, which is inefficient because we only move one element at a time
        shell sort moves entries several positions at a time by h-sorting the array

        This is one of the oldest sorting method implemented by Shell in 1959
     */

    /*
         Why insertion sort, eg. increments 7,3,1
            - for bigger increments, smaller subarray
            - for smaller increments, already partially sorted

         Why shell sort is efficient
            Proposition: a g-sorted array is still g-sorted after h-sorting it

         Which increments to use?
            - powers of 2? NO - did not sort odd elements until 1
            - 3x+1? OK, easy to compute
     */

    public static void sort(int[] arr){
        int n = arr.length;

        int h = 1;
        while(h < n/3){
            h = 3*h + 1;
        }

        while(h >= 1){
            for(int i = h; i < n; i++){
                for(int j = i; j >= h && less(arr[j], arr[j-h]); j -= h){
                    swap(arr, j, j-h);
                }
            }
            h = h/3;
        }
    }

    public static boolean less(int a, int b){
        return a < b;
    }

    public static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
