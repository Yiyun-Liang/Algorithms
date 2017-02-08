package com.isa.Stack;

import java.util.Iterator;

/**
 * Created by isa on 2017-02-06.
 */

// A linked-list implementation of stack
public class LinkedStackOfStrings<Item>{

    private Node first = null;

    // inner class: have extra 8 bytes of overhead
    // access modifier doesn't matter
    // 16 object overhead + 8 bytes String + 8 bytes Node
    private class Node{
        Item item;
        Node next;
    }

    public Item pop(){
        Item firstItem = first.item;
        first = first.next;
        return firstItem;
    }

    public void push(Item item){
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
