package com.isa.Interviews.Trees;

/**
 * Created by isa on 2017-04-01.
 */
public class CheckSubtree {
    /*
        T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
        algorithm to determine if T2 is a subtree of T1.
     */

    class Node{
        int key;
        Node left;
        Node right;
    }

    // Solution 1
    // in order traversal both trees and store in stringbuilders
    // then check if bigger.indexOf(smaller) != -1

    public static boolean isSubtree(Node bigger, Node smaller){
        if(smaller == null){
            return true;
        }

        if(bigger == null){
            return false;
        }

        if(bigger.key == smaller.key){
            return matchTree(bigger, smaller);
        }else{
            return isSubtree(bigger.left, smaller) || isSubtree(bigger.right, smaller);
        }
    }

    public static boolean matchTree(Node bigger, Node smaller){
        if(bigger == null && smaller == null){
            return true;
        }else if(bigger == null || smaller == null){
            return false;
        }else if(bigger.key != smaller.key){
            return false;
        }else{
            return matchTree(bigger.left, smaller.left) && matchTree(bigger.right, smaller.right);
        }
    }
}
