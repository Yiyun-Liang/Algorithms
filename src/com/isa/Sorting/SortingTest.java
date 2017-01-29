package com.isa.Sorting;

import com.sun.scenario.effect.Merge;

/**
 * Created by isa on 2017-01-23.
 */
public class SortingTest {

    public static void main(String[] args) {
        // 3,5,7,12,15,21
        int[] unsortedArr = {14, 15, 3, 7, 21, 5};

        //InsertionSort.insertionSort(unsortedArr);
        MergeSort.mergeSort(unsortedArr, 0, 5);

        for(int i: unsortedArr){
            System.out.println(i);
        }

        System.out.println(MergeSort.inversions);
    }
}
