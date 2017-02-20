package com.isa.BinaryTree.BinarySearchTree;

import com.isa.BinaryTree.BinarySearchTree.BST.*;
import com.isa.BinaryTree.BinarySearchTree.BasicOperations.*;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

/**
 * Created by isa on 2017-02-19.
 */
public class InsertionAndDeletion {

    /*
        These operations causes the dynamic set represented by BST to change
     */


    /*
        Takes in a node n whose value = v, left = null, right = null

        only add a leaf node, not like inserting to the middle of the tree
        takes O(h) time
     */
    void treeInsert(BST tree, Node n){
        Node temp = null;   // trailing pointer, parent of root
        Node root = tree.root;

        while(root != null){
            temp = root;

            if(root.value > n.value){
                root = root.left;
            }else if(root.value < n.value){
                root = root.right;
            }
        }

        n.parent = temp;

        if(temp == null){
            // tree is empty
            tree.root = n;
        }else if(temp.value > n.value){
            temp.left = n;
        }else{
            temp.right = n;
        }
    }

    /*
        Not so straight forward...
        Takes O(h) time
     */
    void treeDelete(BST tree, Node n){
        if(n.left == null){
            transplant(tree, n, n.right);
        }else if(n.right == null){
            transplant(tree, n, n.left);
        }else{
            // n have two children, find n's successor y, can only replace n with its successor after deletion
            // y is guaranteed to be in the right subtree of n, otherwise dealed already previously
            // 1) y is n's right child
            // 2) y is in n's right subtree, but is not z's child
            // in either case, y is guaranteed to have no left children
            Node y = BasicOperations.findMin(n.right);
            if(y.parent != n){
                // case 2
                transplant(tree, y, y.right);
                y.right = n.right;
                y.right.parent = y;
            }
            // case 1, and case 2 also needs to update left child
            transplant(tree, n, y);
            y.left = n.left;
            y.left.parent = y;
        }
    }

    /*
        Helper function for treeDelete, takes O(1) constant time
        Replaces one subtree as a child of its parent with another subtree
        eg. replace subtree rooted at node u with subtree rooted at node v
     */
    void transplant(BST tree, Node u, Node v){

        if(u.parent == null){
            tree.root = v;
        }else if(u == u.parent.left){
            u.parent.left = v;
        }else{
            u.parent.right = v;
        }

        // null nodes does not have parent, children in trees, prev or next in linked list
        if(v != null){
            v.parent = u.parent;
        }
    }
}
