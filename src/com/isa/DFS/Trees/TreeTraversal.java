package com.isa.DFS;

/**
 * Created by isa on 2017-10-21.
 */
public class TreeTraversal {
    private static class Node {
        int val;
        Node left;
        Node right;
    }

    private static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    private static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }
}
