package com.isa.BinaryTree.PersistantBST;

/**
 * Created by isa on 2017-02-26.
 */
public class PersistantBST {

    Node root;

    class Node{
        int key;
        Node left;
        Node right;
        Node parent;
    }

    // keep a copy of the old version of the binary search tree
    // does not change old tree, but return a new tree with updated node
    // O(h) time and space, where h is height of the tree
    // if we want to also update parent pointers, then we would need O(n) time and space when root is changed
    /*
        To ensure O(lgn) deletion and insertion with a red-black tree,
        We can have a stack to store node pointer from root to leaf
     */
    public Node PBSTInsertIterative(int key){
        Node r = root;
        Node ret = null;

        if(r == null){
            ret = makeNewNode(key);
        }

        while(r != null){
            ret = copyNode(r);
            if(key < r.key){
                r = r.left;
                ret.left = copyNode(r);
            }else{
                r = r.right;
                ret.right = copyNode(r);
            }
        }

        Node z = makeNewNode(key);
        if(key < ret.key){
            ret.left = z;
        }else{
            ret.right = z;
        }

        return ret;
    }

    public Node RBSTInsertRecursive(Node root, int key){
        Node ret = null;

        if(root == null){
            ret = makeNewNode(key);
        }else{
            ret = copyNode(root);

            if(key < root.key){
                ret.left = RBSTInsertRecursive(root.left, key);
            }else{
                ret.right = RBSTInsertRecursive(root.right, key);
            }
        }

        return ret;
    }

    public Node makeNewNode(int key){
        Node n = new Node();
        n.key = key;
        n.left = null;
        n.right = null;

        return n;
    }

    public Node copyNode(Node n){
        Node ret = makeNewNode(n.key);
        ret.left = n.left;
        ret.right = n.right;

        return ret;
    }

}
