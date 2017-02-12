package com.isa.Heap;

/**
 * Created by isa on 2017-02-12.
 */
public class Main {
    /*
        Properties:
            max-heap: the value of a node is at most the value of its parent
            min-heap: parent node always smaller then its children nodes

        In the form of an array, parent always at left of its children
            1) Parent(i) return floor(i/2)
            2) Left(i) return i*2
            3) Right(i) return i*2 + 1

        Time complexity:
            All basic operations run in worst-case O(lgn) time.
            To build a max heap from an unordered array takes O(n).
            Heapify takes O(lgn), which maintains heap properties.

     */
}
