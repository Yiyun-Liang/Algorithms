package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-03-08.
 */
public class OptimalBST {
    /*
        Problem:

        Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1]
        of frequency counts, where freq[i] is the number of searches to keys[i].
        Construct a binary search tree of all keys such that the total cost of all
        the searches is as small as possible.
     */

    // http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/

    /*
        Naive solution has overlapping subproblems, exponential running time
        - foreach r from 0 to n-1
        - cost[i,j] = cost[i,r-1]+cost[r+1,j]+sum
     */

    // bottom up dp that stores cost[i][j], O(n^3) running time
    public static double OptimalBST(double[] probs, double[] dummyProbs, int n){
        // Create an auxiliary 2D matrix to store results of subproblems
        /* cost[row][col] = cost[i][j] = Optimal cost of binary search tree that can be
           formed from keys[i] to keys[j].
           cost[0][n-1] will store the resultant cost */
        double[][] cost = new double[n][n]; // 0 ~ n-1
        double[][] sum = new double[n][n];

        // initialize sum
        for(int i = 0; i < n; i++){
            cost[i][i] = probs[i] + dummyProbs[i] + probs[i+1];
            sum[i][i] = probs[i] + dummyProbs[i] + probs[i+1];
        }

        for(int l = 2; l <= n; l++){   // chain length we are dealing with in this cycle
            // i and j are set so that all iterations give chain length l
            for(int i = 0; i <= n-l+1; i++){   // i is row number in cost[][]
                int j = i+l-1;  // Get column number j from row number i and chain length l
                cost[i][j] = Integer.MAX_VALUE;
                sum[i][j] = sum[i][j-1] + probs[j] + dummyProbs[j];

                for(int r = i; r <= j; r++){   // Try making all keys in interval keys[i..j] as root
                    double c = cost[i][r-1] + cost[r+1][j] + sum[i][j];     // c = cost when keys[r] becomes root of this subtree

                    if(c < cost[i][j]){
                        cost[i][j] = c;
                    }
                }
            }
        }

        return cost[0][n-1];
    }
}
