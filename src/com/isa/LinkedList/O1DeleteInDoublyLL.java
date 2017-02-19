package com.isa.LinkedList;

/**
 * Created by isa on 2017-02-19.
 */
public class O1DeleteInDoublyLL {
    Node head = null;

    class Node{
        int value;
        Node prev;
        Node next;
    }

    void deleteNode(Node toBeDeleted){

        // check base case
        if(head == null || toBeDeleted == null){
            return;
        }

        // check if this is head node
        if(head == toBeDeleted){
            head = toBeDeleted.next;
        }

        // if not the head node
        if(toBeDeleted.prev != null){
            toBeDeleted.prev.next = toBeDeleted.next;
        }

        // if not the tail node
        if(toBeDeleted.next != null){
            toBeDeleted.next.prev = toBeDeleted.prev;
        }
    }
}
