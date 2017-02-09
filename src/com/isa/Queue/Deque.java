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
// A deque containing n items must use at most 48n + 192 bytes of memory.
// and use space proportional to the number of items currently in the deque.
public class Deque<Item> implements Iterable<Item> {

    private Item[] q;
    private int first, last;
    private int size;

    // construct an empty deque
    public Deque(){
        q = (Item[]) new Object[2];
        first = 0;
        last = 0;
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

        q[--first] = item;
    }

    // add the item to the end
    public void addLast(Item item){
        if(item == null){
            throw new NullPointerException();
        }

        q[last++] = item;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Item item = q[first];
        // loitering?
        q[first] = null;
        first++;
        return item;
    }

    // remove and return the item from the end
    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Item item = q[last];
        q[last] = null;
        last--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return q[first] != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            return q[first++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
