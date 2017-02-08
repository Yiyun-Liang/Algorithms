package com.isa.Stack;

import java.util.Stack;

/**
 * Created by isa on 2017-02-07.
 */
public class DijkstraTwoStackAlgo {

    public int arithmatic(String input){
        int result = 0;

        Stack<Double> vals = new Stack<>();
        Stack<String> ops = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            int c = input.charAt(i);

            switch(c){
                case '(':
                    break;
                case ')':
                    String op = ops.pop();

                    if(op.equals("+")) vals.push(vals.pop() + vals.pop());
                    else if(op.equals("*")) vals.push(vals.pop() * vals.pop());

                    break;
                case '+':
                case '*':
                    //ops.push(Character.toString(c));
                    break;
                default:
                    vals.push((double)(c - '0'));
                    // vals.push((double) Character.digit(c, 10));
                    break;
            }

        }

        return result;
    }
}
