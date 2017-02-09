package com.isa.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-08.
 */
// A double-ended queue or deque (pronounced "deck") is a generalization of a stack
// and a queue that supports adding and removing items from either the front or
// the back of the data structure. Create a generic data type Deque.

// Performance requirement: each deque operation must have constant worst-case time (including iterator)
// A deque containing n items must use at most !!! 48n + 192 !!! bytes of memory.
// and use space proportional to the number of items currently in the deque.
public class LinkedDeque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node{
        Item item;
        Node prev;
        Node next;
    }

    // construct an empty deque
    public LinkedDeque(){
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item == null){
            throw new NullPointerException();
        }

        Node newNode = new Node();
        newNode.item = item;

        if(size == 0){
            first = newNode;
            last = newNode;
        }else{
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }

        size++;
    }

    // add the item to the end
    public void addLast(Item item){
        if(item == null){
            throw new NullPointerException();
        }

        Node newNode = new Node();
        newNode.item = item;

        if(size == 0){
            first = newNode;
            last = newNode;
        }else{
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node oldFirst = first;
        Item item = oldFirst.item;

        first = first.next;

        if(size == 1){
            last = null;
        }else{
            first.prev = null;
        }
        oldFirst = null;

        size--;

        return item;
    }

    // remove and return the item from the end
    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node oldLast = last;
        Item item = oldLast.item;
        last = last.prev;

        if(size == 1){
            first = null;
        }else{
            last.next = null;
        }
        oldLast = null;

        size--;

        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
