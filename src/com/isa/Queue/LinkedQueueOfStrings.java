package com.isa.Queue;

/**
 * Created by isa on 2017-02-06.
 */
public class LinkedQueueOfStrings {

    private Node first = null;
    private Node last = null;

    // inner class: have extra 8 bytes of overhead
    // access modifier doesn't matter
    // 16 object overhead + 8 bytes String + 8 bytes Node
    private class Node{
        String item;
        Node next;
    }

    public String deque(){
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;  // special cases for empty queue
        return item;
    }

    public void enque(String item){
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;  // special cases for empty queue
        else old.next = last;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
