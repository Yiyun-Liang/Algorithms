package com.isa.BinaryTree.RedBlackBST;

import com.sun.org.apache.regexp.internal.RE;

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
    Node nil; // where all the leaves point to

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

    // insert and fixup
    public void put(Node x){
        Node y = nil;
        Node z = root;

        // find right leaf position x and keep track of its parent in y
        while(x != nil){
            y = z;
            if(x.key < z.key){
                x = x.left;
            }else{
                x = x.right;
            }
        }

        x.parent = y;

        // set y's child
        if(y == nil){
            root = x;
        }else if(x.key < y.key){
            y.left = x;
        }else{
            y.right = x;
        }

        // new node's properties, it is a leaf
        x.left = nil;
        x.right = nil;
        x.color = RED;

        // fixup for red black tree properties
        insertFixup(x);
    }

    // delete and fixup
    public void delete(Node x){

    }

    /***************************************************************************
     *  Helper functions.
     ***************************************************************************/

    private void transplant(Node u, Node v){
        if(u.parent == nil){  // references the sentinel T.nil
            root = v;
        }else if(u == u.parent.left){
            u.parent.left = v;
        }else{
            u.parent.right = v;
        }
        v.parent = u.parent;        // unconditionally, even if v = T.nil
    }

    private void insertFixup(Node x){
        // cannot have two red node as parent and child
        while(x.parent.color == RED){
            // x's parent is a left child
            if(x.parent == x.parent.parent.left){
                Node y = x.parent.parent.right;

                // Case 1: if y is red, recolor
                if(y.color == RED){
                    x.parent.color = BLACK;
                    y.color = BLACK;
                    x.parent.parent.color = RED;
                    x = x.parent.parent;
                }else if(x == x.parent.right){
                    // Case 2: if y is black & x is a right child
                    x = x.parent;
                    leftRotate(x);
                }else{
                    // Case 3: y is black & x is a left child
                    x.parent.color = BLACK;
                    x.parent.parent.color = RED;
                    rightRotate(x.parent.parent);
                }
            }else{
                Node y = x.parent.parent.left;

                // Case 1: if y is red, recolor
                if(y.color == RED){
                    x.parent.color = BLACK;
                    y.color = BLACK;
                    x.parent.parent.color = RED;
                    x = x.parent.parent;
                }else if(x == x.parent.left){
                    // Case 2: if y is black & x is a right child
                    x = x.parent;
                    rightRotate(x);
                }else{
                    // Case 3: y is black & x is a left child
                    x.parent.color = BLACK;
                    x.parent.parent.color = RED;
                    leftRotate(x.parent.parent);
                }
            }
        }

        root.color = BLACK;
    }

    private void deleteFixup(Node x){

    }

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
