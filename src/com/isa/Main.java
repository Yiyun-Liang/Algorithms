package com.isa;

import com.isa.Array.BinarySearch;

public class Main {

    public static void main(String[] args) {
        int[] sortedArr = {1,5,6,7,9,12};
        int res = BinarySearch.binarySearchIterative(sortedArr, 7);
        System.out.println(res);

        int[][] arr = {{1,2},{3,4},{5,6}};
        System.out.println(arr.length); // 3
    }
}
