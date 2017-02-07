package com.isa.Stack;

/**
 * Created by isa on 2017-02-06.
 */
public class ResizingArrayStackOfStrins {

    private int index = 0;
    private String[] s;

    // need to be changed, client doesn't know this!
    public ResizingArrayStackOfStrins(){
        s = new String[1];
    }

    // don't want to half the array when poping
    // efficient: half the array when the array is 1/4 full
    // invariant: the array is alway 25% ~ 100% full
    public String pop(){
        String item = s[--index];
        s[index] = null;

        if(index > 0 && index == s.length/4){
            resize(s.length/2);
        }

        return item;
    }

    // double the array when full
    public void push(String item){
        if(index == s.length){
            resize(2*s.length);
        }
        s[index++] = item;
    }

    // logarithmic
    private void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i = 0; i < index; i++){
            copy[i] = s[i];
        }
        s = copy;
    }

    public boolean isEmpty(){
        return index == 0;
    }

}
