package com.isa.Stack;

/**
 * Created by isa on 2017-02-06.
 */
public class FixedCapArrayStackOfStrings {

    private int index = 0;
    private String[] s;

    // need to be changed, client doesn't know this!
    public FixedCapArrayStackOfStrings(int capacity){
        s = new String[capacity];
    }

    public String pop(){
        String item = s[--index];
        s[index] = null;
        return item;
    }

    public void push(String item){
        s[index++] = item;
    }

    public boolean isEmpty(){
        return index == 0;
    }
}
