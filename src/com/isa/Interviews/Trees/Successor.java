package com.isa.Interviews.Trees;

/**
 * Created by isa on 2017-04-01.
 */
public class Successor {
    /*
        Write an algorithm to find the "next" node (i.e., in-order successor) of a given node
        in a binary search tree. You may assume that each node has a link to its parent.
     */

    static class Node{
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key){
            this.key = key;
        }
    }

    public static Node successor(Node node){
        if(node == null) return null;

        if(node.parent == null || node.right != null){
            return findMin(node.right);
        }

        Node t = node;  // do not touch original node
        Node p = t.parent;

        // Go up until we're on left instead of right
        while(p != null && p.left != t){
            t = p;
            p = p.parent;
        }

        return p;
    }

    public static Node findMin(Node node){

        if(node == null){
            return null;
        }

        while(node.left != null){
            node = node.left;
        }

        return node;
    }
}
