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
        MaxHeap mh = new MaxHeap(heapSize);
        mh.buildAHeap(arr);

        for(int i = heapSize; i >= 2; i--){    // n-1 calls
            mh.exch(arr, 1, i);
            mh.decreaseHeapSizeByOne();
            mh.maxHeapify(arr, 1);             // O(lgn)
        }
    }
}
