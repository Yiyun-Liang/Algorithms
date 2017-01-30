package com.isa.DivideAndConquer;

/**
 * Created by isa on 2017-01-29.
 */
public class MaxSubArray {

    public class Result {
        int minIndex;
        int maxIndex;
        int maxSum;
    }

    /*
        Recurrance:
            T(1) = 1 -> one element
            T(n) = 2T(n/2) + T(n) for n>1 -> T(n) is the max crossing sub array part

        Same as merge sort
            Time complexity: O(nlogn)
            Space complexity: O(logn)
     */

    public Result maxCrossingSubArray(int[] arr, int lower, int mid, int upper){
        // return multiple values as an object
        Result res = new Result();

        // max sum from lower to mid
        int leftSum = 0;
        int leftMax = Integer.MIN_VALUE;
        for(int i = mid; i >= lower; i--){
            leftSum = leftSum + arr[i];
            if(leftSum > leftMax){
                res.minIndex = i;
                leftMax = leftSum;
            }
        }

        // max sum from mid+1 to upper (MID+1 !!!)
        int rightSum = 0;
        int rightMax = Integer.MIN_VALUE;
        for(int i = mid+1; i <= upper; i++){
            rightSum = rightSum + arr[i];
            if(rightSum > rightMax){
                res.maxIndex = i;
                rightMax = rightSum;
            }
        }

        // max sum by combing max sum on the left and on the right
        res.maxSum = leftMax + rightMax;

        return res;
    }

}
