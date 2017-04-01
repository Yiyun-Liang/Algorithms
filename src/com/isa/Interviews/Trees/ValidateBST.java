package com.isa.Interviews.Trees;

import com.isa.Interviews.Trees.MinimalBST.*;

/**
 * Created by isa on 2017-04-01.
 */
public class ValidateBST {
    /*
        Implement a function to check if a binary tree is a binary search tree.
     */

    // initial values:
    // min = 0
    // max = Integer.MAX_VALUE
    public static boolean isBST(Node root, int min, int max){

        if(root == null){
            return true;
        }

        int key = root.key;

        if(key < min || key > max){
            return false;
        }

        return isBST(root.left, min, key) && isBST(root.right, key, max);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Node node = MinimalBST.createMinimalBST(array, 0, array.length-1);

        node.left.key = 5; // lead to false
        System.out.println(isBST(node, 0, Integer.MAX_VALUE));

    }
}
