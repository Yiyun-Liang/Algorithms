package com.isa.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by isa on 2017-03-05.
 */
public class LongestIncreasingSeq {
    // apply a similar technique as LCS problem

    // get the longest monotonically increasing subsequence of a sequence of n numbers
    // first we sort the sequence to get num'
    // then we find the LCS of the two

    // in O(n^2) time
    public static int longest(int[] num){
        int[] sorted = new int[num.length];
        for(int i = 0; i < num.length; i++){
            sorted[i] = num[i];
        }

        Arrays.sort(sorted);

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < sorted.length; i++){
            sb.append(sorted[i]);
        }

        StringBuffer sb2 = new StringBuffer();
        for(int i = 0; i < num.length; i++){
            sb2.append(num[i]);
        }

        int[][] lcs = LCS.LCSLength(sb2.toString(), sb.toString());
        return lcs[num.length][num.length];
    }


    // in O(nlgn) time
    public static int longMono(int[] num){
        int[] B = new int[num.length];
        for(int i = 0; i < num.length; i++){
            B[i] = Integer.MIN_VALUE;
        }

        int[] C = new int[num.length];

        for(int i = 0; i < num.length; i++){
            if()
        }
    }

    public static void main(String[] args){
        int[] num = {1, 3, 5, 0, 1, 3, 5, 8, 3, 8, 9, 1, 5, 7, 9};  // 01358899
        System.out.println(longest(num));
    }
}
