package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-05-28.
 */
public class LargestSubsetSum {
    // [1,...,k]

    static long sum(int k) {
        long sum = 0;

        for (long i = 1; i <= k; i++) {
            if (k % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(4));
    }
}
