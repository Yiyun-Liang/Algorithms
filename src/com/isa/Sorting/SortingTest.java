package com.isa.Sorting;

/**
 * Created by isa on 2017-01-23.
 */
public class SortingTest {

    public static void main(String[] args) {
        int[] unsortedArr = {14, 15, 3, 7, 21, 5};

        InsertionSort.insertionSort(unsortedArr);

        for(int i: unsortedArr){
            System.out.println(i);
        }
    }
}
