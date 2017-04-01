package com.isa.Interviews.Trees;

/**
 * Created by isa on 2017-04-01.
 */
public class CheckBalance {
    /*
        Implement a function to check if a binary tree is balanced.
        For the purposes of this question, a balanced tree is defined
        to be a tree such that the heights of the two subtrees of
        any node never differ by more than one.
     */

    // binary tree node, only  have left and right!!!
    class Node{
        int key;
        Node left;
        Node right;
    }

    // brute force
    public static int getHeight(Node node){
        if(node == null){
            return 0;
        }

        return getHeight(node.left) + getHeight(node.right) + 1;
    }

    public static boolean checkBalance(Node root){
        if(root == null){
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);

        if(Math.abs(heightDiff) <= 1){
            return checkBalance(root.left) && checkBalance(root.right);
        }else{
            return false;
        }
    }

    // better solution
    // basically do not compute other heights once we found a unbalanced subtree(height -infinity)
    public static int checkHeight(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if(leftHeight == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(node.right);
        if(rightHeight == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
