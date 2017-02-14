package com.isa.Sorting;

import com.isa.Sorting.nlgn.HeapSort;
import com.isa.Sorting.nlgn2.ShellSort;
import com.isa.Sorting.quadraticOrNlgn.QuickSort;

/**
 * Created by isa on 2017-01-23.
 */
public class Main {

    public static void main(String[] args) {
        // 3,5,7,12,15,21
        int[] unsortedArr = {14, 15, 3, 7, 21, 5};
        int[] unsortedArrForHeapSort = {0, 14, 15, 3, 7, 21, 5};

        //InsertionSort.insertionSort(unsortedArr);
        //MergeSort.mergeSort(unsortedArr, 0, 5);
        //SelectionSort.sort(unsortedArr);
        //ShellSort.sort(unsortedArr);
        //HeapSort.sort(unsortedArrForHeapSort);
        QuickSort.sort(unsortedArr);

        for(int i: unsortedArr){
            System.out.println(i);
        }

        //System.out.println(MergeSort.inversions);
    }
}
