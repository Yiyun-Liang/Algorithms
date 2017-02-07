package com.isa.Queue;

import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-06.
 */
public class ResizingArrayQueueOfStrings {

    private int n;
    private String[] s;
    private int first, last;

    // need to be changed, client doesn't know this!
    public ResizingArrayQueueOfStrings(){
        s = new String[2];
        n = 0;
        first = 0;
        last = 0;
    }


    public String deque(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");

        String item = s[--first];
        s[first] = null;  // to avoid loitering

        // wrap around
        if(first == s.length) first = 0;

        // shrink size of array if necessary
        if(n > 0 && n == s.length/4){
            resize(s.length/2);
        }

        return item;
    }

    public void enque(String item){
        if(n == s.length){
            resize(2*s.length);
        }
        s[last++] = item;
        if(last == s.length) last = 0;
        n++;
    }

    // logarithmic
    private void resize(int capacity){
        assert capacity >= 0;

        String[] copy = new String[capacity];
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
}
