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

    public static void mergeSort(int[] arr, int lower, int upper) {
        if(lower < upper) {
            int mid = lower + (upper - lower)/2; // avoids overflow for large upper and lower

            mergeSort(arr, lower, mid);
            mergeSort(arr, mid+1, upper);
            merge(arr, lower, mid, upper);
        }
    }

    public static void merge(int[] arr, int lower, int mid, int upper) {

        int leftLen = mid - lower + 1;
        int rightLen = upper - mid;
        int[] L = new int[leftLen];
        int[] R = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            L[i] = arr[lower + i];
        }
        for (int j = 0; j < rightLen; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = lower;

        while (i < leftLen && j < rightLen) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
                inversions+= mid-i+1;
            }
            k++;
        }

        // the first array is guaranteed to be longer than the second one
        while (i < leftLen) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < rightLen) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // bottom up technique
    public static void mergeSortIterative(int[] arr, int n) {
        for (int currentSize = 1; currentSize < n; currentSize *= 2) {
            for (int leftStart = 0; leftStart < n-1; leftStart += 2*currentSize) {
                merge(arr, leftStart, leftStart+currentSize-1, Math.min(leftStart+2*currentSize-1, n-1));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,6,3,6,1,3,8,0,3};
        //mergeSort(arr, 0, arr.length-1);
        mergeSortIterative(arr, arr.length);
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(inversions);
    }
}
