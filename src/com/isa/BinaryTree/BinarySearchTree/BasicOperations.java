package com.isa.BinaryTree.BinarySearchTree;

import java.util.Stack;
import com.isa.BinaryTree.BinarySearchTree.BST.*;

/**
 * Created by isa on 2017-02-18.
 */
public class BasicOperations {

    /*
        Binary Search Tree Property:
            Let x be a node in a BST. If y is a node in the left subtree of x,
            then y.key <= x.key. If y is a node in the right subtree of x, then
            y.key >= x.key.
     */

    /*
        In order recursive traversal in O(n)
     */

    static void inOrderRecursive(Node root){
        if(root != null){
            inOrderRecursive(root.left);
            System.out.println(root.value);
            inOrderRecursive(root.right);
        }
    }

    /*
        In order non-recursive traversal with a stack in O(n)
     */

    static void inOrderIterative(Node root){

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

    /*
        Another way to do a inorder tree walk is to
        call findMin first and then call findSuccessor (n-1) times
     */


    /*
        Search for a key in O(lgn) or O(h) where h is height of the tree
     */
    Node searchRecursive(Node root, int key){
        // return same thing, some combine both into one statement
        if(root == null || root.value == key){
            return root;
        }

        if(root.value > key){
            return searchRecursive(root.left, key);
        }else{
            return searchRecursive(root.right, key);
        }
    }

    /*
        Usually, to change a recursive program to a iterative way, change to use a while loop
        On most computers, this is more efficient
     */
    Node searchIterative(Node root, int key){
        while(root != null && root.value != key){
            //if(root.value == key){
                //return root;
            //}else
            if(root.value > key){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }


    /*
        Both find min and find max takes O(h) time
     */
    static Node findMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    static Node findMax(Node root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }


    static Node findPredecessor(Node n){
        if(n.left != null){
            findMax(n.left);
        }

        Node pred = n.parent;
        while(pred != null && n == pred.left){
            n = pred;
            pred = n.parent;
        }

        return pred;
    }

    static Node findSuccessor(Node n){
        if(n.right != null){
            return findMin(n.right);
        }

        // go up until n is the left child of succ
        Node succ = n.parent;
        while(succ != null && n == succ.right){
            n = succ;
            succ = succ.parent;
        }

        return succ;
    }
}
