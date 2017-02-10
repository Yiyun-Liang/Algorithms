package com.isa.Queue.Algorithms;

import com.isa.Queue.RandomizedQueue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by isa on 2017-02-09.
 */
public class Permutation {

    public static void main(String[] args){
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        int num = StdIn.readInt();

        while (!StdIn.isEmpty()) {
            String c = StdIn.readString();
            randomizedQueue.enqueue(c);
        }

        int i = 0;
        while(i < num){
            StdOut.println(randomizedQueue.dequeue());
            i++;
        }
    }

}
