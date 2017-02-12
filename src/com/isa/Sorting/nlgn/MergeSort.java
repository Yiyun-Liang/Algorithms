package com.isa.Sorting.nlgn;

import java.util.Arrays;

/**
 * Created by isa on 2017-01-25.
 */
public class MergeSort {

    public static int inversions = 0;
     /*
     * Time complexity: O(nlogn)
     *  - log(n) levels(dividing) and each level needs n operations(merging)
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

    public static int merge(int[] arr, int lower, int mid, int upper){

        int[] temp = new int[arr.length];

        for (int i = lower; i <= upper; i++) {
            temp[i] = arr[i];
        }

        int i = lower;
        int j = mid + 1;
        int k = lower;

        while (i <= mid && j <= upper) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
                inversions+= mid-i+1;
            }
            k++;
        }

        // the first array is guaranteed to be longer than the second one
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }

        return inversions;
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
