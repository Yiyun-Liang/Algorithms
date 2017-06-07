package com.isa.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by isa on 2017-05-28.
 */
public class LongestSameRangeSubSeq {

    static int subSeqLength(int[] arr) {
        int[] currentLength = new int[arr.length];
        int[][] minMax = new int[arr.length][2];

        Arrays.fill(currentLength, 1);
        currentLength[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            minMax[i][0] = arr[i];
            minMax[i][1] = arr[i];
        }
        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (withinRange(arr[i], minMax[j][0], minMax[j][1]) || withinRange(arr[i], arr[j], arr[j])) {
                    currentLength[i]++;
                    minMax[i][0] = Math.min(minMax[j][0], arr[i]);
                    minMax[i][1] = Math.max(minMax[j][1], arr[i]);
                }
            }

            if (res < currentLength[i]) {
                res = currentLength[i];
            }
        }

        for (int l: currentLength) {
            System.out.print(l);
        }
        System.out.println();

        return res;
    }

    static boolean withinRange(int value, int min, int max) {
        if (value == min || Math.abs(value - min) == 1 || value == max || Math.abs(value - max) == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8,5,4,8,4};
        int res = subSeqLength(arr);
        System.out.println(res);
    }
}
