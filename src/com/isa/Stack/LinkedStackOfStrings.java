package com.isa.Stack;

/**
 * Created by isa on 2017-02-06.
 */

// A linked-list implementation of stack
public class LinkedStackOfStrings {

    private Node first = null;

    // inner class: have extra 8 bytes of overhead
    // access modifier doesn't matter
    // 16 object overhead + 8 bytes String + 8 bytes Node
    private class Node{
        String item;
        Node next;
    }

    public String pop(){
        String firstItem = first.item;
        first = first.next;
        return firstItem;
    }

    public void push(String item){
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
