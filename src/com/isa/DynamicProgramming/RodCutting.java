package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-02-27.
 */
public class RodCutting {
    /*
        split problems into subproblems and memoize the solution

        Use to-down memoization or bottom-up dp technique to get polynomial time solution rather than exponential
     */

    // O(2^n) time, considered all 2^(n-1) ways of cutting the rod
    // n is the length of the rod being the first part, also the length of the rod
    public int rodCuttingNaive(int price[], int n){
        if(n == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE; // can probably be 0 since all prices are positive
        for(int i = 1; i <= n; i++){
            max = Math.max(max, price[i]+rodCuttingNaive(price, n-i));
        }

        return max;
    }

    // O(n^2) time
    // add memoization table on top of the naive solution
    // memo has n+1 size
    public int rodCuttingTopDown(int price[], int[] memo, int n){
        if(memo[n] > 0){
            return memo[n];
        }

        int max = Integer.MIN_VALUE;

        if(n == 0){
            max = 0;
        }else{
            // max = negative infinity
            for(int i = 1; i <= n; i++){
                max = Math.max(max, price[i]+rodCuttingNaive(price, n-i));
            }
        }

        memo[n] = max;

        return max;
    }

    // O(n^2) time
    // solve subproblems in order from smallest to biggest, so that
    // when the bigger problems come, all the sub smaller problems that this solution for bigger problem needed
    // is already solved and saved in a table
    public int rodCuttingBottomUp(int price[], int n){
        int[] memo = new int[n+1];

        for(int j = 1; j<= n; j++){
            int q = Integer.MIN_VALUE;

            for(int i = 1; i <= j; i++){
                q = Math.max(q, price[i]+memo[j-i]);
            }
            memo[j] = q;
        }

        return memo[n];
    }

}
