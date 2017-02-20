package com.isa.BinaryTree.RedBlackBST;

/**
 * Created by isa on 2017-02-20.
 */
public class RedBlackBST {

    /*
        red-black tree properties:
            1) every node is either black or red
            2) the root is black
            3) every leaf(null) is black
            4) if a node is red, then both its children are black
            5) for each node, all simple paths from the node to descendent
               leaves contain the same number of black nodes
     */

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    Node root;

    private class Node {
        Node left;
        Node right;
        Node parent; // may or may not have this
        boolean color;
        int key;

        public Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    /***************************************************************************
     *  Red-black tree insertion.
     ***************************************************************************/

    public void put(){

    }

    /***************************************************************************
     *  Helper functions.
     ***************************************************************************/

    // O(1) time
    // assumes x.right != null
    private void leftRotate(Node x){
        //assert (x != null) && isRed(x.right);

        Node y = x.right;
        x.right = y.left;  // turn y's left subtree to x's right subtree

        if(y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;

        // set x's parent to point to y now
        if(x.parent == null){
            root = y;
        }else if(x == x.parent.left){
            x.parent.left = y;
        }else{
            x.parent.right = y;
        }

        y.left = x;
        //y.color = x.left.color;
        //y.left.color = RED;
        x.parent = y;
    }

    // make a left-leaning link lean to the right
    private void rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        y.right = x;

        if(y.right != null){
            y.right.parent = x;
        }

        y.parent = x.parent;

        if(x.parent == null){
            root = y;
        }else if(x.parent.left == x){
            x.parent.left = y;
        }else{
            x.parent.right = y;
        }
        
        x.parent = y;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public boolean isEmpty() {
        return root == null;
    }
}
