package com.isa.BinaryTree.RedBlackBST.OrderStatisticRBT;

/**
 * Created by isa on 2017-02-26.
 */
public class JosephusPermutation {
    // a (n,m) josephus permutation is like n people in a circle  (m <= n)
    // removing every mth person until all n people are removed

    // eg. (7, 3) josephus permutation of integers 1, 2, 3, 4, 5, 6, 7
    //     returns 3, 6, 2, 7, 5, 1, 4

    class Node{
        int key;
        Node next; // last node points to first node in this circular linkedlist
    }

    // O(nlgn) time solution
    public void betterPermutation(int[] arr, int m){
        int n = arr.length;
        OrderStatisticRBT ost = new OrderStatisticRBT();

        // construct a ost for the input arr
        for(int i = 0; i < n; i++){
            // if insert takes a node, then create a node here, then pass to insert
            ost.insert(arr[i]);
        }

        for(int i = 0; i < n; i++){
            // this also works if m is not a constant
            // for example, m changes according to i, etc
            OrderStatisticRBT.Node mthNode = ost.select(ost.root, m);
            System.out.println(mthNode.key);
            ost.delete(mthNode);
        }
    }

    // O(n) solution using a circular singly linkedlist
    public void permutation(int[] arr, int m){
        // construct a circular linkedlist for this array
        // assume head is now Node n
        Node head = new Node();
        int n = arr.length;

        for(int j = 0; j < n; j++){
            // move to mth node
            for(int i = 0; i < m; i++, head = head.next);

            // print the key
            System.out.println(head.key);

            // remove this node
            // since usually doubly linkedlists delete in O(1)
            // this is a singly linkedlist, we copy the next node's key to the current node, thus taking O(1)
            head.key = head.next.key;
            head.next = head.next.next;
        }
    }
}
