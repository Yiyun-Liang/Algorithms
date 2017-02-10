package com.isa.Queue;

import com.isa.Queue.Algorithms.KnuthShuffle;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import edu.princeton.cs.algs4.*;


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

// for array implementation, if order is not important, can always move the
// last element to the empty position in the middle if something is removed from the middle of the array
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n;
    private Item[] items;

    // construct an empty randomized queue
    public RandomizedQueue(){
        items = (Item[]) new Object[2];
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

    // logarithmic
    private void resize(int capacity){
        assert capacity >= 0;

        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0; i < n; i++){
            copy[i] = items[i];
        }
        items = copy;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null){
            throw new NullPointerException();
        }

        if(n == items.length){
            resize(items.length*2);
        }

        items[n++] = item;

        //if(n == items.length){
        //    n = 0;   // wrap around, changed to n when resizing is done
        //}
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        // [0, n)
        int rand = StdRandom.uniform(n);
        Item item = items[rand];
        items[rand] = items[--n];
        items[n] = null;

        if(n == items.length/4){
            resize(items.length/2);
        }

        return item;
    }

    // return (but do not remove) a random item
    public Item sample(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        // [0, n)
        int rand = StdRandom.uniform(n);

        return items[rand];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomIterator();
    }

    // Fisher–Yates shuffle
    // Time complexity: O(n)
    // in-place shuffle
    private class RandomIterator implements Iterator<Item> {

        private int i = 0;
        private Item[] randomized;

        RandomIterator(){
            randomized = (Item[]) new Object[n];
            for (int j = 0; j < n; j++) {
                randomized[j] = items[j];
            }
            KnuthShuffle.shuffle(randomized);
        }

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            // never return an item that has been return before
            int rand = (int) (Math.random() * (n-i));
            Item item = randomized[rand];
            randomized[rand] = randomized[n-(++i)];
            randomized[n-i] = null;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}
