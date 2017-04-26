package com.isa.Interviews.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by isa on 2017-04-24.
 */
public class PairsWithSum {
    /*
        Design an algorithm to find all pairs of integers within an array which sum to a specified value.
     */

    public class Pair{
        int left;
        int right;

        Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    // O(n)
    public ArrayList<Pair> pairs(int[] arr, int sum){
        HashMap<Integer, Integer> unpairedNum = new HashMap<>();  // not hashset because there may be duplicated ints in arr
        ArrayList<Pair> results = new ArrayList<>();

        for(int x: arr){  // use foreach loop is ok
            int complement = sum - x;

            if(unpairedNum.getOrDefault(complement, 0) > 0){
                results.add(new Pair(x, complement));
                adjustCounterBy(unpairedNum, complement, -1);  // decrement complement
            }else{
                adjustCounterBy(unpairedNum, x, 1);  // increment count
            }
        }

        return results;
    }

    public void adjustCounterBy(HashMap<Integer, Integer> map, int key, int delta){
        map.put(key, map.getOrDefault(key, 0) + delta);  // very neat: use getOrDefault here
    }

    /*
        Alternate solution:
            Sort the array and have two pointers moving from front anc back
     */
}
