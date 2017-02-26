package com.isa.BinaryTree.Treap;

/**
 * Created by isa on 2017-02-26.
 */
public class Treap {
    /*
        Binary search tree + min heap

        Since a bst may be horribly unbalanced,
            1) One way to solve this is to randomize the nodes to be inserted
            What if we only have one node at a time?
            2) Another way is to have a treap that includes an attribute priority
               the priority is randomly assigned to the node to be inserted
               Then the expected running time is O(lgn)
     */

    Node root;

    class Node{
        int key;
        Node left;
        Node right;
        Node parent;

        int priority;
    }

    public void insert(Node n){
        // first run normal binary tree insertion
        while(n != root && n.priority < n.parent.priority){
            if(n == n.parent.left){
                rightRotate(n.parent);
            }else{
                leftRotate(n.parent);
            }
        }
    }

    public void leftRotate(Node n){

    }

    public void rightRotate(Node n){

    }
}
