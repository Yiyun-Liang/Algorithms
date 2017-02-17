package com.isa.LinkedList;

/**
 * Created by isa on 2017-02-16.
 */
public class ReverseSinglyLL {

    class Node{
        int val;
        Node next;
    }

    // reverse a singly linked list in O(n), non-recursive
    // no more than constant space beyond the needed list itself
    void reverse(Node head){
        Node a = head.next;
        Node b = head;

        while(a != null){
            Node temp = a.next;
            a.next = b;
            b = a;
            a = temp;
        }
        head.next = a; // set next pointer of the original head to null
        head = b;       // set head to the original tail node

    }
}
