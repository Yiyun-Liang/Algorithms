package com.isa.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-06.
 */

// A linked-list implementation of stack
public class LinkedStackOfStrings<Item> implements Iterable<Item>{

    private Node first = null;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

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
