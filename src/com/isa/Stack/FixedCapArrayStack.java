package com.isa.Stack;

/**
 * Created by isa on 2017-02-06.
 */
public class FixedCapArrayStack<Item> {

    private int index = 0;
    private Item[] s;

    // need to be changed, client doesn't know this!
    public FixedCapArrayStack(int capacity){
        s = (Item[])new Object[capacity];
    }

    public Item pop(){
        Item item = s[--index];
        s[index] = null;
        return item;
    }

    public void push(Item item){
        s[index++] = item;
    }

    public boolean isEmpty(){
        return index == 0;
    }
}
