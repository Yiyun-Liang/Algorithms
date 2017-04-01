package com.isa.Interviews.TreesAndGraphs;

/**
 * Created by isa on 2017-04-01.
 */
public class MinmalTree {
    /*
        Given a sorted (increasing order) array with unique integer elements,
        write an algorithm to create a binary search tree with minimal height.
     */

    static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    public static Node createMinimalBST(int[] arr, int low, int high){
        // or if(low > high) return null;

        if(low <= high){
            // binary search
            int mid = low + (high-low)/2;

            Node n = new Node(arr[mid]);

            n.left = createMinimalBST(arr, low, mid-1);  // !!! REMEMBER: binary search, mid has already been evaluated!!!
            n.right = createMinimalBST(arr, mid+1, high);

            return n;
        }

        return null;
    }

    public static void traverseTree(Node n){
        if(n != null){
            traverseTree(n.left);
            System.out.println(n.key);
            traverseTree(n.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Node n = createMinimalBST(arr, 0, arr.length-1);
        System.out.println("root: " + n.key);
        traverseTree(n);
    }
}
