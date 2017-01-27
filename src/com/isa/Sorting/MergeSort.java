package com.isa.Sorting;

import java.util.Arrays;

/**
 * Created by isa on 2017-01-25.
 */
public class MergeSort {
     /*
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     *
     */

    public static void mergeSort(int[] arr, int lower, int upper){
        if(lower < upper) {
            int mid = lower + (upper - lower)/2;

            mergeSort(arr, lower, mid);
            mergeSort(arr, mid+1, upper);
            merge(arr, lower, mid, upper);
        }
    }

    public static void merge(int[] arr, int lower, int mid, int upper){
        int[] left = new int[mid-lower+1];
        int[] right = new int[upper-mid+1];
        int lenL = left.length;
        int lenR = right.length;

        int l = 0;
        int r = 0;
        int m = 0;
        while(l < lenL && r < lenR){
            if(left[l] <= right[r]){
                arr[m] = left[l];
                l++;
            }else{
                arr[m] = right[r];
                r++;
            }
            m++;
        }

        while(l < lenL){
            arr[m] = left[l];
            l++;
            m++;
        }

        while(r < lenR){
            arr[m] = right[r];
            r++;
            m++;
        }
    }

    public static void merge(int[] left, int[] right, int[] arr){
        int lenL = left.length;
        int lenR = right.length;

        int l = 0;
        int r = 0;
        int m = 0;
        while(l < lenL && r < lenR){
            if(left[l] <= right[r]){
                arr[m] = left[l];
                l++;
            }else{
                arr[m] = right[r];
                r++;
            }
            m++;
        }

        while(l < lenL){
            arr[m] = left[l];
            l++;
            m++;
        }

        while(r < lenR){
            arr[m] = right[r];
            r++;
            m++;
        }
    }
}
