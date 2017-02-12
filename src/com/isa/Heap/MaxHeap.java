package com.isa.Heap;

import java.util.NoSuchElementException;

import static java.lang.System.exit;

/**
 * Created by isa on 2017-02-12.
 */
public class MaxHeap {

    int heapSize = 0;
    int[] arr;

    public MaxHeap(int[] arr){
        this.heapSize = arr.length - 1;  // number of elements in the heap (one-based array, usually arr.length-1)
        this.arr = arr;
        buildAHeap();
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
            maxHeapify(i);
        }
    }

    // O(lgn)
    public void heapInsert(int key){
        heapSize += 1;

        if(heapSize >= arr.length){
            resize(arr.length*2);
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
        while(index > 1 && arr[parent(index)] < arr[index]){   // run O(lgn) times
            exch(index, parent(index));
            index = parent(index);   // once index is set to root(index = 1) or in position, stop
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
        maxHeapify(1);   // always change size first, then heapify!!, O(lgn)

        return max;
    }

    public int heapMaximum(){
        return arr[1];
    }

    /**
     * Return an array that follows heap properties
     * take A random ordered array that has valid numbers in [1, len-1]
     */
    // O(nlgn) -> O(n)
    public void buildAHeap(){
        int nonLeaf = heapSize/2;  // floor(len/2)

        for(int i = nonLeaf; i >= 1; i--){   // runs n/2 times
            maxHeapify(i);              // O(lgn)
        }
    }

    /*
        subtrees of i are heap
        bubble down
        root starts from arr[1]

        Recurrence: T(n) <= T(2n/3) + O(1)  // the children's subtree has size at most 2n/3
        Time complexity(worst-case): O(lgn)
     */
    public void maxHeapify(int i){
        int left = left(i);
        int right = right(i);

        int max = -1;

        if(left <= heapSize && arr[left] > arr[i]){
            max = left;
        }else{
            max = i;
        }

        if(right <= heapSize && arr[right] > arr[max]){
            max = right;
        }

        if(max != i){
            exch(max, i);
            maxHeapify(max);
        }
    }

    public void exch(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int parent(int i){
        return (int) Math.floor(i/2);
    }

    public int left(int i){
        return i*2;
    }

    public int right(int i){
        return i*2 + 1;
    }

    public void decreaseHeapSizeByOne(){
        this.heapSize -= 1;
    }

    // logarithmic
    private void resize(int capacity){
        assert capacity >= 0;

        int[] copy = new int[capacity];
        for(int i = 0; i < arr.length; i++){
            copy[i] = arr[i];
        }
        arr = copy;
    }
}
