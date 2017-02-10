package com.isa.Queue.Algorithms;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by isa on 2017-02-09.
 */
public class KnuthShuffle {

    // this class should not be instantiated
    private KnuthShuffle() { }

    /**
     * Rearranges an array of objects in uniformly random order
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param arr the array to be shuffled
     */
    public static void shuffle(Object[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            // exclusive so i+1
            // choose index uniformly in [i, n-i]
            // ex. 0~100 -> (int)(Math.random() * 101);
            int j = i + (int) (Math.random() * (n - i));
            //int j = ThreadLocalRandom.current().nextInt(0, n-i);
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     * Reads in a sequence of strings from standard input, shuffles
     * them, and prints out the results.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // read in the data
        String[] a = {"a", "b", "c", "d", "e"};

        // shuffle the array
        KnuthShuffle.shuffle(a);

        // print results.
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

}
