package com.isa.BinaryTree;

/**
 * Created by isa on 2017-02-04.
 */
public class SmallestSuccessor {

    /*
        Time complexity: O(n), where n is the height of the tree
        Space complexity: O(1)
     */

    public Node inorderSuccessor(Node root, Node n){
        Node succ;

        if(n.right != null){
            return minValue(n.right);
        }

        succ = null;

        while(root != null){
            if(n.value < root.value){
                succ = root;
                root = root.left;
            }else if(n.value > root.value){
                root = root.right;
            }else{
                break;
            }
        }

        return succ;
    }

    public Node minValue(Node n){
        Node current = n;

        while(current.left != null){
            current = current.left;
        }

        return current;
    }
}
