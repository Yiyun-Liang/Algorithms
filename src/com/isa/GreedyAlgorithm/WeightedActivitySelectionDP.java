package com.isa.GreedyAlgorithm;

/**
 * Created by isa on 2017-03-18.
 */
public class WeightedActivitySelectionDP {

    // O(n) : T(n) = T(n-1) + O(1)
    // m is the memo table
    // w is weight value
    // q[j] = largest index i < j such that job i is compatible with j, computed first with binary search\
    // return weight
    // in total O(nlgn) due to binary search
    public static int top_down_selector(int[] m, int[] w, int[] q, int j){
        if(j == 0){
            m[0] = 0;
        }else if(m[j] == 0){
            m[j] = Math.max(w[j]+top_down_selector(m, w, q, q[j]), top_down_selector(m, w, q, j-1));
        }

        return m[j];
    }

    // O(n)
    public static int bottom_up_selector(int[] m, int[] w, int[] q){
        for(int j = 0; j < w.length; j++){
            m[j] = Math.max(w[j]+m[q[j]], m[j-1]);
        }

        return m[w.length-1];
    }

    public static void print_solution(int[] m, int[] w, int[] q, int j){
        if(j == 0){
            // print nothing
        }else if(w[j]+m[q[j]] > m[j-1]){
            System.out.println(j);
        }else{
            print_solution(m, w, q, j-1);
        }
    }
}
