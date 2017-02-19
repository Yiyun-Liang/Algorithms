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
        NNode parent;
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

    /*
        Non-recursively traverse a n-node tree with O(1) space
     */

    void traverseNNodeTreeNR(NNode root){
        NNode prev = null;

        while(root != null){
            if (prev == root.parent){
                System.out.println(root.value);
                root = (root.left != null) ? root.left :
                        (root.rightSibling != null) ? root.rightSibling : root.parent;
            }else if(prev == root.left && root.rightSibling != null){
                prev = root;
                root = root.rightSibling;
            }else{
                prev = root;
                root = root.parent;
            }
        }
    }

    /*
        The left-child, right-sibling representation of an arbitrary
        rooted tree uses three pointers in each node: left-child,
        right-sibling, and parent. From any node, its parent can be
        reached and identified in constant time and all its children
        can be reached and identified in time linear in the number of
        children. Show how to use only two pointers and one boolean
        value in each node so that the parent of a node or all of its
        children can be reached and identified in time linear in the number of children.
     */

    /*
        Remove parent pointer, add a boolean value for each node,
        indicating whether the node is the last right sibling, if true,
        then it's right sibling pointer will point to its parent.
     */
}
