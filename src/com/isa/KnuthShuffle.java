package com.isa;

/**
 * Created by isa on 2017-02-09.
 */

// linear time shuffling, uniformly random permutation
// randomly give one permutation of a sequence (likelihood of each permutation to occur is equal)
// eg. poker game
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
            // int j = i + (int) (Math.random() * (n - i));
            // random number in [0, i]
            int j = (int) (Math.random() * (i + 1));
            //int j = ThreadLocalRandom.current().nextInt(0, n-i);
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    // useful method
    public int rand(int lower, int upper){
        return lower + Math.random()*(upper-lower+1);
    }
    
    public static void shuffleRecursive(Object[] arr, int n){
        if(n==0) return arr;
        
        shuffleRecursive(arr, n-1);
        int k = rand(0, n);
        
        //swap
        Object temp = arr[k];
        arr[k] = arr[n];
        arr[n] = temp;
        
        return arr;
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
