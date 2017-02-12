package com.isa.Heap;

import java.util.NoSuchElementException;

import static java.lang.System.exit;

/**
 * Created by isa on 2017-02-12.
 */
public class PriorityQueue {

    MaxHeap mh;
    int[] arr;
    int heapSize;

    public PriorityQueue(int[] arr){
        mh = new MaxHeap(arr);
        this.arr = arr;
        this.heapSize = arr.length - 1;
    }


    // O(lgn)
    public void heapDelete(int i){
        // replace arr[i] with arr[heapsize]
        // if key is larger, bubble up
        // if key is smaller or same, bubble down

        if(arr[i] < arr[heapSize]){
            heapIncreaseKey(i, arr[heapSize]);
            heapSize -= 1;
        }else{
            arr[i] = arr[heapSize];
            heapSize -= 1;
            mh.maxHeapify(i);
        }
    }

    // O(lgn)
    public void heapInsert(int key){
        heapSize += 1;

        if(heapSize >= arr.length){
            mh.resize(arr.length*2);
            arr = mh.arr;
        }
        arr[heapSize] = Integer.MIN_VALUE;
        heapIncreaseKey(heapSize, key);  // runs O(lgn) times
    }

    // O(lgn)
    public void heapIncreaseKey(int index, int newKey){
        if(newKey < arr[index]){
            System.err.println("new key is smaller than current key");
            exit(0);
        }

        arr[index] = newKey;

        // key is increased, not might need to bubble up
        while(index > 1 && arr[mh.parent(index)] < arr[index]){   // run O(lgn) times
            mh.exch(index, mh.parent(index));
            index = mh.parent(index);   // once index is set to root(index = 1) or in position, stop
        }

        /*
            Optimize exch to one step by apply insertion sort technique

            while(index > 1 && arr[parent(index)] < arr[index]){   // run O(lgn) times
                arr[index] = arr[parent(index)]
                index = parent(index);   // once index is set to root(index = 1) or in position, stop
            }
            arr[i] = newKey
         */
    }

    // O(lgn)
    public int heapExtractMax(){
        if(heapSize < 1){
            throw new NoSuchElementException("Heap overflow");
        }

        int max = arr[1];

        arr[1] = arr[heapSize];
        heapSize -= 1;
        mh.maxHeapify(1);   // always change size first, then heapify!!, O(lgn)

        return max;
    }

    public int heapMaximum(){
        return arr[1];
    }

}
