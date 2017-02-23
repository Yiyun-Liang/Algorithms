package com.isa.BinaryTree.RedBlackBST;

/**
 * Created by isa on 2017-02-23.
 */
public class OrderStatisticRBT {

    Node root;
    Node nil;

    // augmented data structure
    // base: Red-Black Tree
    class Node{
        int key;
        Node left;
        Node right;
        Node parent;
        int size; // how many nodes are rooted at this node
    }

    // select the ith smallest element in the rbt
    // passed node n is initially the root node
    public Node select(Node n, int i){
        int r = n.left.size + 1;   // root node rank
        if(r == i){
            return n;
        }else if(r > i){
            return select(n.left, i);
        }else{
            return select(n.right, i-r);
        }
    }

    // get the rank of the node
    // rank is the position of the node in a in-order tree walk
    public int rank(Node n){
        int rank = n.left.size + 1;  // if left is nil, assume nil has size 0
        Node t = n;

        while(t != root){
            if(t == t.parent.right) {
                rank += t.parent.left.size + 1;
            }
            t = t.parent;
        }

        return rank;
    }
}
