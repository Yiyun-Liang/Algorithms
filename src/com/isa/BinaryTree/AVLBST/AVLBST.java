package com.isa.BinaryTree.AVLBST;

/**
 * Created by isa on 2017-02-26.
 */
public class AVLBST {

    /*
        A height balanced binary search tree,
        !!! for each node x, the heights of the left and right substrees of x differ by at most 1

        Need to maintain an extra attribute in each node, height
     */

    Node root;

    class Node{
        int key;
        Node left;
        Node right;
        Node parent;

        int height;
    }

    /*
        An AVL tree with n nodes has height O(lgn)
        An AVL tree with height h has at least Fh nodes, where Fh is the hth Fibonacci number

             0  0  1  2  3  4
        Fib: 1, 1, 2, 3, 5, 8
     */

    // bst rooted at n is balanced but with heights
    // of left and right subtrees differ by at most 2 after insertion
    public void balance(Node n){
        while(Math.abs(n.left.height-n.right.height) > 1){
            if((n.left.height-n.right.height) > 0){
                rightRotate(n);
            }else{
                leftRotate(n);
            }
            balance(n.left);
            balance(n.right);
        }
    }

    public void leftRotate(Node n){
        Node r = n.right;
        n.right = r.left;

        if(r.left != null){
            r.left.parent = n;
        }
        r.parent = n.parent;

        // set n's parent to point to r now
        if(n.parent == null){
            root = r;
        }else if(n == n.parent.left){
            n.parent.left = r;
        }else{
            n.parent.right = r;
        }

        r.left = n;
        n.parent = r;
    }

    public void rightRotate(Node n){

    }
}
