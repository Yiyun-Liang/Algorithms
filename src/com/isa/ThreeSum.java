package com.isa;

import java.util.Arrays;

/**
 * Created by isa on 2017-02-05.
 */
public class ThreeSum {

    /*
        Brute Force: three loops -> O(n^3)
        Approach 2: sort first, then fix the first element and find in the rest of the sorted array
                    this is a O(n^2) solution
     */

    public int threeSum(int[] arr, int sum){
        int leftPtr = 0;
        int rightPtr = 0;
        int count = 0;

        // sort first
        Arrays.sort(arr);

        // leave three elements at the end
        for(int i = 0; i < arr.length-2; i++){
            leftPtr = i+1;
            rightPtr = arr.length - 1;

            while(leftPtr < rightPtr){
                if(arr[leftPtr] + arr[rightPtr] + arr[i] > sum){
                    rightPtr--;
                }else if(arr[leftPtr] + arr[rightPtr] + arr[i] < sum){
                    leftPtr++;
                }else{
                    count++;
                }
            }
        }

        return count;
    }
}
