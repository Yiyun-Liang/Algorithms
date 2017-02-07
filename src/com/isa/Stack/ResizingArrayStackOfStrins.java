package com.isa.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-06.
 */
public class ResizingArrayStackOfStrins<Item> implements Iterator<Item> {

    private int n;
    private Item[] s;

    // need to be changed, client doesn't know this!
    public ResizingArrayStackOfStrins(){
        s = (Item[]) new Object[2];
        n = 0;
    }

    // don't want to half the array when poping
    // efficient: half the array when the array is 1/4 full
    // invariant: the array is alway 25% ~ 100% full
    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack overflow");
        Item item = s[--n];
        s[n] = null;    // to avoid loitering

        if(n > 0 && n == s.length/4){
            resize(s.length/2);
        }

        return item;
    }

    // double the array when full
    public void push(Item item){
        if(n == s.length){
            resize(2*s.length);
        }
        s[n++] = item;
    }

    // logarithmic
    private void resize(int capacity){
        assert capacity >= n;

        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0; i < n; i++){
            copy[i] = s[i];
        }
        s = copy;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return s[n-1];
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        return null;
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return s[i--];
        }
    }

}
