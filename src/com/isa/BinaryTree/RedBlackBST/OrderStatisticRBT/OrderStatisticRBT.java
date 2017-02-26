package com.isa.BinaryTree.RedBlackBST.OrderStatisticRBT;

/**
 * Created by isa on 2017-02-23.
 */
public class OrderStatisticRBT {

    Node root;
    Node nil;

    // augmented data structure
    // base: Red-Black Tree
    // for augmented structures, MAKE SURE we can MAINTAIN these newly-added attributed efficiently
    class Node{
        int key;
        Node left;
        Node right;
        Node parent;
        int size; // how many nodes are rooted at this node
    }

    public void insert(int key){
        // 1) update size of every node on the path from root to this leaf
        // 2) when rotating to reserve rbt properties, leftRotate(Node x)
        //    - y.size = x.size
        //    - x.size = y.left.size + x.left.size + 1
    }

    public void delete(Node n){
        // 1) traverse from n to root, all nodes on this path gets size - 1
        // 2) same as insert for rotation
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

    public Node selectIterative(int i){
        Node r = root;
        while(r != null && (r.left.size + 1) != i){
            int size = r.left.size + 1;
            if(size > i){
                r = r.left;
            }else{
                r = r.right;
                i -= size;
            }
        }

        return r;
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

    // take an input of a key
    // return the rank of this key in this tree
    public int keyRank(Node root, int key){
        int size = root.left.size + 1;

        if(key == root.key){
            return size;
        }else if(key < root.key){
            return keyRank(root.left, key);
        }else{
            return size + keyRank(root.right, key);
        }
    }

    // given a node, and an int i
    // return the ith successor of this node n
    public Node ithSuccessor(Node n, int i){
        int rank = rank(n);
        return select(root, rank + i);
    }
}
