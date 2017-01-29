package com.isa;

public class Main {

    public static void main(String[] args) {
        int[] sortedArr = {1,5,6,7,9,12};
        int res = BinarySearch.binarySearchIterative(sortedArr, 7);
        System.out.println(res);
    }
}
