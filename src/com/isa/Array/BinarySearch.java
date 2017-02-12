package com.isa.Array;

/**
 * Created by isa on 2017-01-29.
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int target){
        return binarySearch(arr, 0, arr.length-1, target);
    }

    /*
        RECURSIVE
            Time complexity: O(logn) -> diving in half
            Space complexity: O(logn) for stack space or O(1) for tail recursion optimization
        ITERATIVE
            Time complexity: O(logn)
            Space complexity: O(1)
     */

    public static int binarySearch(int[] arr, int lower, int upper, int target){
        if(lower > upper){
            return -1;
        }

        int mid = lower + (upper - lower)/2;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            return binarySearch(arr, lower, mid-1, target);
        }else{
            return binarySearch(arr, mid+1, upper, target);
        }
    }

    public static int binarySearchIterative(int[] arr, int target){
        int lower = 0;
        int upper = arr.length-1;
        int mid = 0;

        while(lower <= upper){
            mid = lower + (upper-lower)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                upper = mid-1;
            }else{
                lower = mid+1;
            }
        }

        return -1;
    }
}
