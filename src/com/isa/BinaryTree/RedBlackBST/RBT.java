package com.isa.BinaryTree.RedBlackBST;

/**
 * Created by isa on 2017-02-20.
 */
public class RBT {

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    Node root;

    class Node {
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
}
