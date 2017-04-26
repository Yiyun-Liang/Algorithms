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
    
    // Another O(n^2) solution not using lcs, memoized version
    public static void incSeq(int[] num){
        int n = num.length;
        int[] lis = new int[n];  // length of the longest seq ending with num[i]
        
        for(int i = 0; i < n; i++){
            lis[i] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(num[i] > num[j] && lis[i] < lis[j]+1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            if(lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        
        return maxLen;
    }


    // in O(nlgn) time
    public static void longMono(int[] num){
        int[] B = new int[num.length];  // contains the last value of
        // a longest monotonically increasing subsequence of length i, tail table
        /*for(int i = 0; i < num.length; i++){
            B[i] = Integer.MIN_VALUE;
        }*/
        B[0] = num[0];

        // contains the monotonically increasing subsequence of length
        // i with smallest last element seen so far
        // an array of empty lists
        int[] C = new int[num.length];

        int L = 1;

        for(int i = 0; i < num.length; i++){
            if(num[i] < B[0]){
                B[0] = num[i];  // new smallest value
                //C[0].head.key = A[i]
            }else{
                int j = 0;
                B[j+1] = num[i];
                C[j+1] = C[j];
                //C[j+1].insert(num[i])
                if(j+1 > L){
                    L++;
                }
            }
        }

        System.out.println(C[L]);
    }
    
     // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    // a different implementation of the O(nlng) solution
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }

    public static void main(String[] args){
        int[] num = {1, 3, 5, 0, 1, 3, 5, 8, 3, 8, 9, 1, 5, 7, 9};  // 01358899
        System.out.println(longest(num));
    }
}
