package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-03-12.
 */
public class LongestPalindromeSeq {

    // still use the LCS problem

    public static String lps(String s){
        // reverse a string
        String reversed = new StringBuilder(s).reverse().toString();

        LCS.LCSLength(s, reversed);
        return "";
    }

    public static void main(String[] args){
        lps("character");
    }
}
