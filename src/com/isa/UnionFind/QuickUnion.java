package com.isa.UnionFind;

import java.util.HashSet;

/**
 * Created by isa on 2017-02-04.
 */

// lazy approach - avoid doing work until we have to

public class QuickUnion {

    private int[] arr;

    // index is the node, arr[index] contains its parent in the forest
    // same number means root

    /**
     * For example
     *    i    0  1  2  3  4  5  6  7  8  9
     *  -------------------------------------
     * id[i]   0  9  6  5  4  2  6  1  0  5
     *
     *  roots of 3 and 7 are both 6
     */
    public QuickUnion(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
    }

    // to merge roots containing p and q, set the id of p's root to the id of q's root
    public void union(int p, int q){

        int proot = findRoot(p);
        int qroot = findRoot(q);

        arr[proot] = qroot;
    }

    // check if p and q have the same root
    public boolean connected(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    // component identifier for p
    public int find(int p){
        return findRoot(p);
    }

    // number of components
    public int count(){
        int diff = 0;

        HashSet<Integer> checkDuplicates = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            int temp = findRoot(i);
            if(!checkDuplicates.contains(temp)){
                checkDuplicates.add(temp);
                diff++;
            }
        }

        return diff;
    }

    private int findRoot(int i){
        while(i != arr[i]){
            i = arr[i];
        }
        return i;
    }

}
