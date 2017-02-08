package com.isa.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-07.
 */
public class Bag<Item> implements Iterable<Item>{

    private int n;
    private Node<Item> first;

    // linked list structure
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    // (linked list) stack without pop, or queue without dequeue
    // removing items is not supported
    // purpose: collect items and iterate through collected items
    public Bag(){
        first = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

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
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }
}
