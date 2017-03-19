package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-03-18.
 */
public class ZeroOneKnapSack {

    /*
        Problem:

        A thief wants to steal things from a store, each item i in the store has a value vi and a weight wi
        the thief can only take a weight of W of items, so what does he need to take in order to maximize his profit
     */

    // O(nW) time where n is number of items and W is weight of knapsack
    // bottom up solution
    // weight sorted in increasing order?
    public static int dynamic_selector(int[] values, int[] weights, int n, int W){
        int[][] c = new int[n+1][W+1];  // n items, achieve weight W

        for(int w = 0; w <= W; w++){
            c[0][w] = 0;
        }

        for(int i = 1; i <= n; i++){
            c[i][0] = 0;
            for(int w = 1; w <= W; w++){
                if(weights[i-1] <= W){
                    if(values[i-1] + c[i-1][w-weights[i-1]] > c[i-1][w]){
                        c[i][w] = values[i] + c[i-1][w-weights[i-1]];
                    }else{
                        c[i][w] = c[i-1][w];
                    }
                }else{
                    c[i][w] = c[i-1][w];
                }
            }
        }

        return c[n][W];
    }
}
