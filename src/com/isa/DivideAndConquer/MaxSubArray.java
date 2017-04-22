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

    public Result maxSubArray(int[] arr){
        return maxSubArray(arr, 0, arr.length - 1);
    }

    /*
        Recurrance:
            T(1) = 1 -> one element
            T(n) = 2T(n/2) + T(n) for n>1 -> T(n) is the max crossing sub array part

        Same as merge sort
            Time complexity: O(nlogn)
            Space complexity: O(logn)
     */
    public Result maxSubArray(int[] arr, int lower, int upper){
        Result left;
        Result right;
        Result crossing = new Result();

        if(lower == upper){                 // base case: only one element
            crossing.maxSum = arr[lower];
            crossing.minIndex = lower;
            crossing.maxSum = upper;
            return crossing;
        }else{
            int mid = lower + (upper-lower)/2;
            left = maxSubArray(arr, lower, mid);
            right = maxSubArray(arr, mid+1, upper);
            crossing = maxCrossingSubArray(arr, lower, mid, upper);

            if(left.maxSum >= right.maxSum && left.maxSum >= crossing.maxSum){
                return left;
            }else if(right.maxSum >= left.maxSum && right.maxSum >= crossing.maxSum){
                return right;
            }else{
                return crossing;
            }
        }
    }


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

    /*
        O(n) solution to max subarray problem
     */
    // Approach 1: also kadane’s algorithm ?
    // does not handle the case where all numbers in the array are negative

    public int max(int[] arr){
        int maxSum = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > maxSum){
                maxSum = sum;
            }else if(sum < 0){
                sum = 0;
            }
        }

        return maxSum;
    }

    // Approach 2: Standard Kadane’s Algorithm
    // find max or min absolute sum of a subarray of an array of integers in O(n)
    // to find min, change sign of each element in the array and then run Kadane’s Algorithm to find max sum, then invert sign of the max sum found
    // also handles the case when all numbers in the array are negative

    public int maxSub(int[] arr){
        int maxEndingHere = arr[0], maxSoFar = arr[0];
        int[] sum = new int[arr.length];
        sum[0] = maxSoFar; // memo
        for(int i = 1; i < arr.length; i++){
            maxEndingHere = Math.max(maxEndingHere+arr[i], arr[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            sum[i] = maxSoFar;
        }
        return maxSoFar;
    }

    /*
        Another similar problem:
        http://www.geeksforgeeks.org/maximum-absolute-difference-between-sum-of-two-contiguous-sub-arrays/
     */
}
