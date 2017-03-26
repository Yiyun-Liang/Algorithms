package com.isa.BinaryTree;

/**
 * Created by isa on 2017-02-06.
 */
public class Main {
    /*
        Definitions: height = levels - 1
            1) Full Binary Tree - every node other then the leaves has two children (levels are not necessarily filled)
                                - every node has 0 or 2 children
                                - num nodes: at least n = 2h + 1, at most n = 2^(h+1) - 1
            2) Complete Binary Tree - every level, except possibly the last, is completely filled,
                                      and all nodes are as far left as possible (all levels except the last are filled)
            3) Perfect Binary Tree - all interior nodes have two children and all leaves have the same depth or same level
                                   - height = floor(lgn)
                                   - num leaf nodes l = (n+1)/2
                                   - num non-leaf nodes = n - l = l - 1
                                   - num nodes in total n = 2l - 1 = 2^(h+1) - 1

            4) Binary Search Tree(BST) - sorted binary tree
                                       - for a node with key k,
                                         every key in the left subtree is less than k and
                                         every key in the right subtree is greater than k.

        ancestor: u is on the simple path from root to v, u is v's ancestor
        descendant: v is u's descendant
        predecessor: immediately smaller one
        successor: immediately bigger one
     */
}
