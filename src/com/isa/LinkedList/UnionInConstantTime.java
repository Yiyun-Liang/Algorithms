package com.isa.LinkedList;

/**
 * Created by isa on 2017-02-16.
 */
public class UnionInConstantTime {
    // use circular doubly linked lists
    Node root;

    class Node{
        int val;
        Node prev;
        Node next;
    }

    UnionInConstantTime(){
        root = null;
    }

    // union this list and the list passed in in O(1) time
    void union(Node root2){
        root.prev.next = root2;
        root2.prev = root.prev;

        root.prev = root2.prev;
        root2.prev.next = root;
    }
}
