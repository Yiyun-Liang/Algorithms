package com.isa.BinaryTree.RedBlackBST.OrderStatisticRBT;

/**
 * Created by isa on 2017-02-26.
 */
public class Inversions {
    /*
        Use an OSTree, count the number of inversions in an array(size n) in O(nlgn) time
        same as time complexity of counting inversions using a merge sort
     */

    OrderStatisticRBT ost = new OrderStatisticRBT();
    int inversions = 0;

    public void countInversions(int[] arr){
        for(int i = 0; i < arr.length; i++){
            ost.insert(arr[i]);
            // get this inserted node, then get its rank
            // inversion += (ost.root.size - rank)
        }
    }
}
