package com.isa.UnionFind;

import java.util.HashSet;

/**
 * Created by isa on 2017-02-04.
 */

public class QuickFind implements UF {

    /**
     * maintains the invariant that p and q are connected if and only if id[p] is equal to id[q].
     * In other words, all sites in a component must have the same value in id[].
     */

    private int[] arr;

    public QuickFind(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
    }

    // add connection between p and q (range 0 to n-1)
    public void union(int p, int q){
        int qid = arr[q];
        int toChange = arr[p];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == toChange){
                arr[i] = qid;
            }
        }
    }

    // are p and q in the same component
    public boolean connected(int p, int q){
        return arr[p] == arr[q];
    }

    // component identifier for p
    public int find(int p){
        return arr[p];
    }

    // number of components
    public int count(){
        int diff = 0;

        HashSet<Integer> checkDuplicates = new HashSet<Integer>();
        for(int i: arr){
            if(!checkDuplicates.contains(i)){
                checkDuplicates.add(i);
                diff++;
            }
        }

        return diff;
    }
}
