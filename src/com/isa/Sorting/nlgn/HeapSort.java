package com.isa.Sorting.nlgn;

import com.isa.Heap.MaxHeap;

/**
 * Created by isa on 2017-01-27.
 */
public class HeapSort {

    /*
        Time complexity: O(nlgn) same for worst, average, best
        Space complexity: O(1) because in-place sort
     */

    public static void sort(int[] arr){
        int heapSize = arr.length - 1;
        MaxHeap mh = new MaxHeap(arr);
        // mh.buildAHeap(arr); is involved in the constructor of maxHeap

        for(int i = heapSize; i >= 2; i--){    // n-1 calls
            mh.exch(1, i);
            mh.decreaseHeapSizeByOne();
            mh.maxHeapify(1);             // O(lgn)
        }
    }
}
