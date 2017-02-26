package com.isa.BinaryTree.RedBlackBST;

/**
 * Created by isa on 2017-02-26.
 */
public class MinGap {

    // based on red-black tree

    Node root;

    class Node{
        int key;
        Node left;
        Node right;
        Node parent;

        int minGap;  // leaf nodes has minGap = infinity
                     // otherwise, minGap =
                     //     min(n.left.minGap, n.right.minGap, (n.key - findMax(n.left)), (findMin(n.right) - n.key))
    }

    // given an array, get the magnitude of the difference of the two closest numbers in the array
    public int minGap(int[] arr){
        int minGap = 0;

        for(int i = 0; i < arr.length; i++){
            // all inserted into this tree
        }

        minGap = root.minGap;

        return minGap;
    }

    private Node findMin(Node n){
        return n;
    }

    private Node findMax(Node n){
        return n;
    }
}
