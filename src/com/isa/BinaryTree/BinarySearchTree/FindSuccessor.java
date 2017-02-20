package com.isa.BinaryTree.BinarySearchTree;

/**
 * Created by isa on 2017-02-04.
 */
public class FindSuccessor {
    class Node {
        Node left;
        Node right;
        int value;
    }

    /*
        Time complexity: O(n), where n is the height of the tree
        Space complexity: O(1)
     */

    // this can be used if input is a single key rather than a node pointer
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


        /*
            Alternative with a parent pointer:
            {
                if(n.right != null){
                    return minValue(n.right);
                }

                // go up until n is the left child of succ
                Node succ = n.p;
                while(succ != null && n == succ.right){
                    n = succ;
                    succ = succ.p;
                }
            }
         */
    }


    public Node minValue(Node n){
        Node current = n;

        while(current.left != null){
            current = current.left;
        }

        return current;
    }
}
