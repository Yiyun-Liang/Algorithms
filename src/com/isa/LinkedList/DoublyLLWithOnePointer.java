package com.isa.LinkedList;

/**
 * Created by isa on 2017-02-16.
 */
public class DoublyLLWithOnePointer {

    Node head;

    class Node{
        int val;
        int np;  // represent both next and prev = next[x] XOR prev[x]
    }

    DoublyLLWithOnePointer(int headVal){
        head.val = headVal;
    }

    /*
        Since A XOR (A XOR C) = C, once we know one value(head), we know the rest
     */
    void print(){
        int current = head.np;
        int prev = 0;  // means null
        int next;

        while(current != 0){
            next = prev ^ current;
            prev = current;
            current = next;

            System.out.println(current);
        }
    }


}
