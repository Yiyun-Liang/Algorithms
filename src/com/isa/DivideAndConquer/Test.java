package com.isa.DivideAndConquer;

/**
 * Created by isa on 2017-01-29.
 */
public class Test {

    public static void main(String[] args){
        int[] test = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxSubArray maxSubArray = new MaxSubArray();

        MaxSubArray.Result res = maxSubArray.maxSubArray(test);
        System.out.println(res.maxSum);
        System.out.println(res.minIndex);
        System.out.println(res.maxIndex);
    }

}
