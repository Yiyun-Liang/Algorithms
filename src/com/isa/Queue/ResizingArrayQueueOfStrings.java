package com.isa.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-06.
 */
public class ResizingArrayQueueOfStrings<Item> implements Iterable<Item> {

    private int n;
    private Item[] s;
    private int first, last;

    // need to be changed, client doesn't know this!
    public ResizingArrayQueueOfStrings(){
        s = (Item[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }


    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");

        Item item = s[first];
        s[first] = null;  // to avoid loitering
        first++;
        n--;

        // wrap around, avoid out of index
        if(first == s.length) first = 0;

        // shrink size of array if necessary
        if(n > 0 && n == s.length/4){
            resize(s.length/2);
        }

        return item;
    }

    public void enqueue(Item item){
        if(n == s.length){
            resize(2*s.length);
        }
        s[last++] = item;

        // wrap-around
        if(last == s.length) last = 0;
        n++;
    }

    // logarithmic
    private void resize(int capacity){
        assert capacity >= 0;

        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0; i < n; i++){
            copy[i] = s[(first+i) % s.length];
        }
        s = copy;
        first = 0;
        last = n;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = s[(i + first) % s.length];
            i++;
            return item;
        }
    }
}
