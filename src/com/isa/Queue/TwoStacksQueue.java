package com.isa.Queue;

import com.isa.Stack.ResizingArrayStack;

import java.util.NoSuchElementException;

/**
 * Created by isa on 2017-02-08.
 */

// Implement a queue with two stacks so that each queue operations
// takes a constant amortized number of stack operations.
public class TwoStacksQueue<Item> {

    ResizingArrayStack<Item> head;
    ResizingArrayStack<Item> tail;

    public TwoStacksQueue(){
        head = new ResizingArrayStack<>();
        tail = new ResizingArrayStack<>();
    }

    public Item deque(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if(head.isEmpty()){
            shift();
        }

        return head.pop();
    }

    public void enque(Item item){
        tail.push(item);
    }

    public Item peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if(head.isEmpty()){
            shift();
        }

        return head.peek();
    }

    public boolean isEmpty(){
        return head.isEmpty() && tail.isEmpty();
    }

    public int size(){
        return head.size() + tail.size();
    }

    private void shift(){
        while(!tail.isEmpty()){
            head.push(tail.pop());
        }
    }
}
