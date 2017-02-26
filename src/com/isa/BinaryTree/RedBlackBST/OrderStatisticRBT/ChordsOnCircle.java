package com.isa.BinaryTree.RedBlackBST.OrderStatisticRBT;

import java.util.Arrays;

/**
 * Created by isa on 2017-02-26.
 */
public class ChordsOnCircle {

    /*
        Consider n chords on a circle, each defined by its endpoints
        this is an O(nlgn)-time algorithm to determine the
        number of pairs of chords that intersects inside the circle,
        assume no two chords share the same endpoints

        eg. if all chords are diameters, then nC2 pairs
     */

    OrderStatisticRBT ost = new OrderStatisticRBT();

    // define chord by radian
    class Chord{
        int startRadian;
        int endRadian;
    }

    public int getIntersectedPairs(Chord[] chords){
        int pairs = 0;

        // put both start and end radians in an array
        int[] radians = {};

        // first sort this array in O(nlgn) by start radians
        Arrays.sort(radians);

        // iterate through chords by start radian
        for(int i = 0; i < radians.length; i++){
            if(isStartRadian(radians[i])){
                ost.insert(radians[i]);
            }else{
                // find how many chords have start radian < this start radian and end radian > this end radian
                // delete start radian from the ost
            }
        }

        return pairs;
    }

    private boolean isStartRadian(int i){
        return true;
    }
}
