package com.isa.Sorting.quadraticOrNlgn;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by isa on 2017-02-13.
 */
public class QuickSort {

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int lower, int upper){
        if(lower < upper){
            int q = partition(arr, lower, upper);
            sort(arr, lower, q-1);
            sort(arr, q+1, upper);  // tail recursion
        }
    }

    public static void sortTailRecurOptimized(int[] arr, int lower, int upper){
        while(lower < upper){
            int q = partition(arr, lower, upper);

            if(upper-q >= q-lower){
                sortTailRecurOptimized(arr, lower, q-1);
                lower = q+1;
            }else{
                sortTailRecurOptimized(arr, q+1, upper);
                upper = q-1;
            }
        }
    }

    public static void quickSortIterative(int arr[], int l, int h) {
        // Create an auxiliary stack
        int[] stack = new int[h-l+1];

        // initialize top of stack
        int top = -1;

        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];

            // Set pivot element at its correct position
            // in sorted array
            int p = partition(arr, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p-1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p+1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

    /*
        Allow all element to have same probability to be the pivot,
        so that the chance of getting good partition is optimized
     */
    public static int randomized_partition(int[] arr, int p, int r){
        int q = p + (int) Math.random()*(r-p+1);
        swap(arr, q, r);
        return partition(arr, p, r);
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

    public static void main(String[] args) {

    }
}
