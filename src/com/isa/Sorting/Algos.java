package com.isa.Sorting;

/**
 * Created by isa on 2017-02-11.
 */
public class Algos {
    // Def: subquadratic: Subquadratic designates an algorithm whose complexity is ~o(n^2),
    //          using the little-o notation. This means that the complexity grows much slower than n^2.
    //          It could be anything from linear to almost quadratic.

    /*
        Intersection of two sets. Given two arrays 𝚊[] and 𝚋[],
        each containing n distinct 2D points in the plane, design
        a subquadratic algorithm to count the number of points
        that are contained both in array 𝚊[] and array 𝚋[].
     */

    // sort, hashtable, shellsort (or any other subquadratic sort).
    public static int intersections(int[] a, int[] b){
        int same = 0;

        return same;
    }

    /*
        Permutation. Given two integer arrays of size n, design a
        subquadratic algorithm to determine whether one is a permutation
        of the other. That is, do they contain exactly the same entries
        but, possibly, in a different order.
     */

    // sort
    public static boolean perutation(int[] a, int[] b){
        return true;
    }

    /*
        Dutch national flag. Given an array of n buckets, each containing a red,
        white, or blue pebble, sort them by color. The allowed operations are:

        swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
        color(i): color of pebble in bucket i.
        The performance requirements are as follows:

        At most n calls to color().
        At most n calls to swap().
        Constant extra space.
     */

    public static void DutchFlag(){

    }
}
