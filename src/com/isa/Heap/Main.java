package com.isa.Heap;

/**
 * Created by isa on 2017-02-12.
 */
public class Main {
    /*
        Properties:
            max-heap: the value of a node is at most the value of its parent
            min-heap: parent node always smaller then its children nodes

        In the form of an array, parent always at left of its children (zero-based array or one-based)
            1) Parent(i) return or floor(i/2)
            2) Left(i) return 2i + 1 or 2i
            3) Right(i) return 2i + 2 or 2i + 1
            4) Root nodes are at floor(n/2) + 1, floor(n/2) + 2 .... n

        Time complexity:
            All basic operations run in worst-case O(lgn) time.
            To build a max heap from an unordered array takes O(n).
            Heapify takes O(lgn), which maintains heap properties.

     */

    public static void main(String[] args){
        int[] arr = {0, 15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};

        MaxHeap mh = new MaxHeap(arr);
        mh.heapInsert(10);

        for(int i: mh.arr){
            System.out.println(i);
        }
    }
}
