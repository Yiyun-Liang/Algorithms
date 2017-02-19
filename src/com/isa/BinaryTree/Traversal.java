package com.isa.BinaryTree;

import java.util.Stack;

/**
 * Created by isa on 2017-02-18.
 */
public class Traversal {

    /*
        In order recursive traversal
     */

    void inOrderRecursive(Node root){
        if(root != null){
            inOrderRecursive(root.left);
            System.out.println(root.value);
            inOrderRecursive(root.right);
        }
    }

    /*
        In order non-recursive traversal with a stack
     */

    void inOrder(Node root){

        Stack<Node> st = new Stack<>();

        while(root != null || !st.empty()){
            // stop having the left most node also on the stack
            while(root != null){
                st.push(root);
                root = root.left;
            }

            Node temp = st.pop();  // left most node in the first iteration
            System.out.println(temp.value);
            root = temp.right;
        }
    }

    class NNode{
        int value;
        NNode left;
        NNode rightSibling;
    }

    /*
        Recursively traverse a n-node tree
     */

    void traverseNNodeTree(NNode root){
        if(root != null){
            System.out.println(root.value);
        }
        if(root.left != null){
            traverseNNodeTree(root.left);
        }
        if(root.rightSibling != null){
            traverseNNodeTree(root.rightSibling);
        }
    }
}
