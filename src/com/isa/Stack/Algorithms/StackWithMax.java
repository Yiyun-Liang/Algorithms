package com.isa.Stack.Algorithms;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by isa on 2017-02-08.
 */

// Create a data structure that efficiently supports the stack operations
// (push and pop) and also a return-the-maximum operation. Assume the
// elements are real numbers so that you can compare them.
public class StackWithMax {

    Stack<Double> nums = new Stack<>();
    Stack<Double> maxs = new Stack<>();

    public double getMax(){
        return maxs.peek();
    }

    public void push(double num){
        if(nums.empty()){
            nums.push(num);
            maxs.push(num);
        }else{
            if(num >= maxs.peek()){
                maxs.push(num);
            }
            nums.push(num);
        }

    }

    public double pop(){
        if((nums.peek()).equals(maxs.peek())){
            maxs.pop();
        }

        return nums.pop();
    }

}
