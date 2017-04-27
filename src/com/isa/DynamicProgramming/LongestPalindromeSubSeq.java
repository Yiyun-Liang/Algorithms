package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-03-12.
 */
public class LongestPalindromeSubSeq {

    // still use the LCS problem

    public static String lps(String s){
        // reverse a string
        String reversed = new StringBuilder(s).reverse().toString();

        LCS.LCSLength(s, reversed);
        return "";
    }

    /*
        Another approach O(n^3)

        split the string at 0 ~ n-1, position i, then use lcs for each subproblems
     */

    public static void main(String[] args){
        lps("character");
    }
}
