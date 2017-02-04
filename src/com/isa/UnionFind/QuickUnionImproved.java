package com.isa.UnionFind;

import java.util.HashSet;

/**
 * Created by isa on 2017-02-04.
 */
public class QuickUnionImproved {
    private int[] arr;
    // count number of objects in the tree rooted at index i
    private int[] size;

    public QuickUnionImproved(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
    }

    // to merge roots containing p and q, set the id of the smaller tree's root to the id of the larger tree's root
    public void union(int p, int q){

        int proot = findRoot(p);
        int qroot = findRoot(q);

        if(proot == qroot){
            return;
        }

        if(size[proot] < size[qroot]){
            arr[proot] = qroot;

            // update size array
            size[qroot] += size[proot];
        }else{
            arr[qroot] = proot;
            size[proot] += size[qroot];
        }
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
            // this is a one pass solution, can be done in two passes
            arr[i] = arr[arr[i]]; // path compression, only one extra line of code, halving path to root, keep tree almost flat
            i = arr[i];
        }
        return i;
    }
}
