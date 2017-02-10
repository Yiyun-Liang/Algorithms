package com.isa.Queue;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-08.
 */

// A randomized queue is similar to a stack or queue,
// except that the item removed is chosen uniformly at random
// from items in the data structure.
// Create a generic data type RandomizedQueue.

    // Requirements
// The order of two or more iterators to the same randomized queue must be
// mutually independent; each iterator must maintain its own random order.

// Your randomized queue implementation must support each randomized queue operation
// (besides creating an iterator) in constant amortized time. That is, any sequence of
// m randomized queue operations (starting from an empty queue) should take at most cm
// steps in the worst case, for some constant c. A randomized queue containing n items
// must use at most 48n + 192 bytes of memory. Additionally, your iterator implementation
// must support operations next() and hasNext() in constant worst-case time; and construction
// in linear time; you may (and will need to) use a linear amount of extra memory per iterator.
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n;

    // construct an empty randomized queue
    public RandomizedQueue(){
        n = 0;
    }

    // is the queue empty?
    public boolean isEmpty(){
        return n == 0;
    }

    // return the number of items on the queue
    public int size(){
        return n;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null){
            throw new NullPointerException();
        }


    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
    }

    // return (but do not remove) a random item
    public Item sample(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return n != 0;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            return sample();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}
