package com.isa.Interviews.Trees;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by isa on 2017-04-01.
 */
public class CommonAncestor {
    /*
        Design an algorithm and write code to find the first common
        ancestor of two nodes in a binary tree. Avoid storing additional
        nodes in a data structure.

        NOTE: This is not necessarily a binary search tree.
     */

    // binary tree node
    class Node{
        int key;
        Node left;
        Node right;

        Node parent;
    }

    // Solution 0: one traversal and no extra space
    // assumes that both keys are present in the tree
    // to skip this limitation, keep two global boolean values v1, v2
    Node findLCA(Node node, int n1, int n2)
    {
        // Base case, always check this for tree functions
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.key == n1 || node.key == n2)  // split these to also update v1, v2 to true
            return node;

        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }


    // Solution 1: O(n) three tree traversals + three additional arrays
    // not a binary search tree, need to trace up
    // if it is a binary search tree, can go from root to node in O(lgn)
    public static Node commonAncestor(Node a, Node b){
        if(a == b){
            return a;
        }

        LinkedList<Node> ap = pathToRoot(a);
        LinkedList<Node> bp = pathToRoot(b);

        LinkedList<Node> compare = new LinkedList<>(ap);
        compare.retainAll(bp);  // remove from ap all nodes that are not in bp

        if(compare.size() == 0){
            return null;
        }else{
            return compare.get(0);
        }
    }

    public static LinkedList<Node> pathToRoot(Node n){
        LinkedList<Node> list = new LinkedList<>();
        list.add(n);

        while(n.parent != null){
            list.add(n.parent);
            n = n.parent;
        }

        return list;
    }


    // Solution 2: more than two traversals, no extra arrays
    public static Node commonAncestor(Node root, Node a, Node b){
        int delta = depth(a) - depth(b);
        Node swallower = delta > 0 ? b : a;
        Node deeper = delta > 0 ? a : b;

        while(delta > 0 && deeper != null){
            deeper = deeper.parent;
            delta--;
        }

        while(swallower != deeper && swallower != null && deeper != null){
            swallower = swallower.parent;
            deeper = deeper.parent;
        }

        return swallower == null || deeper == null ? null : swallower;
    }

    public static int depth(Node n){
        int depth = 0;

        while(n.parent != null){
            n = n.parent;
            depth++;
        }

        return depth;
    }
}
