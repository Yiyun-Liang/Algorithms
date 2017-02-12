package com.isa.Heap;

/**
 * Created by isa on 2017-02-12.
 */
public class MaxHeap {

    int heapSize = 0;

    public MaxHeap(int heapSize){
        this.heapSize = heapSize;  // number of elements in the heap (one-based array, usually arr.length-1)
    }

    /**
     * Return an array that follows heap properties
     * @param arr A random ordered array that has valid numbers in [1, len-1]
     */
    // O(nlgn) -> O(n)
    public void buildAHeap(int[] arr){
        int nonLeaf = heapSize/2;  // floor(len/2)

        for(int i = nonLeaf; i >= 1; i--){   // runs n/2 times
            maxHeapify(arr, i);              // O(lgn)
        }
    }

    /*
        subtrees of i are heap
        bubble down
        root starts from arr[1]

        Recurrence: T(n) <= T(2n/3) + O(1)  // the children's subtree has size at most 2n/3
        Time complexity(worst-case): O(lgn)
     */
    public void maxHeapify(int[] arr, int i){
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
            exch(arr, max, i);
            maxHeapify(arr, max);
        }
    }

    public void exch(int[] arr, int a, int b){
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
}
