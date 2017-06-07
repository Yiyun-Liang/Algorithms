package com.isa.BinaryTree;

/**
 * Created by isa on 2017-02-04.
 */
public class LowestCommonAncestor {
    // in binary tree, use functions written below
    // in binary search tree, find a n1 < node.value < n2
    class Node {
        Node left;
        Node right;
        int value;
    }

    // traverse from the root node to find the two nodes

    /*
     * Time complexity: O(n)
     * Space complexity: O(lgn) for stack
     */
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        // base case for trees
        if(root==null)
            return null;

        if(root==p || root==q)
            return root;

        Node l = lowestCommonAncestor(root.left, p, q);
        Node r = lowestCommonAncestor(root.right, p, q);

        if(l!=null && r!=null){
            return root;
        }else if(l==null && r==null){
            return null;
        }else{
            return l==null?r:l;
        }
    }

    // traverse up from the two nodes
    // 1. traverse from one of the nodes, store in hashmap,
    //    then traverse up from the other node and check against the table
    //    TIME: O(n), SPACE: O(n)
    // 2. bring both nodes to the same level, then traverse up together
    //    TIME: O(n), SPACE: O(1)

}
