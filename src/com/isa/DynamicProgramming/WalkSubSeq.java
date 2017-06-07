package com.isa.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by isa on 2017-05-28.
 */
public class WalkSubSeq {

    static int numWays(String s, int n, int x, int y) {
        char[] direction = s.toCharArray();
        int numLeftNeeded = 0;
        int numRightNeeded = 0;
        int maxLeft = x;
        int maxRight = (n-x);

        if (x < y) {
            numRightNeeded += (y-x);
        } else if (x > y) {
            numLeftNeeded += (x-y);
        }

        int[][][] memo = new int[direction.length][direction.length][2];
        for (int i = 0; i < direction.length; i++){
            for (int j = 0; j < direction.length; j++){
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }

        return numRightNeeded == 0 ?
                numWays(direction, numLeftNeeded, true, maxLeft, maxRight, direction.length-1, memo, "") :
                numWays(direction, numRightNeeded, false, maxLeft, maxRight, direction.length-1, memo, "");
    }

    static int numWays(char[] direction, int steps, boolean isLeft,
                       int maxLeft, int maxRight, int index, int[][][] memo, String test) {
        int totalWays = 0;
        if (index < 0) {
            return 0;
        }

        if (steps >= 0 && memo[index][steps][0] != -1) {
            return memo[index][steps][0];
        } else if (steps < 0 && memo[index][Math.abs(steps)][1] != -1) {
            return memo[index][Math.abs(steps)][1];
        }

        if (steps == 0 && maxLeft >= 0 && maxRight >= 0) {
            System.out.println(test);
            totalWays += 1;
        }

        if (index == 0 && maxLeft >= 0 && maxRight >= 0 &&
                direction[index] == 'l' && isLeft && steps == 1) {
            System.out.println(test);
            totalWays += 1;
        } else if (index == 0 && maxLeft >= 0 && maxRight >= 0 &&
                direction[index] == 'r' && !isLeft && steps == 1) {
            System.out.println(test);
            totalWays += 1;
        }

        if (direction[index] == 'l') {
            totalWays += (isLeft) ?
                    numWays(direction, steps-1, isLeft, maxLeft-1, maxRight+1, index-1, memo, 'l' + test) :
                    numWays(direction, steps+1, isLeft, maxLeft-1, maxRight+1, index-1, memo, 'l' + test);
            totalWays += numWays(direction, steps, isLeft, maxLeft, maxRight, index-1, memo, test);
        } else {
            totalWays += (isLeft) ?
                    numWays(direction, steps+1, isLeft, maxLeft+1, maxRight-1, index-1, memo, 'r' + test) :
                    numWays(direction, steps-1, isLeft, maxLeft+1, maxRight-1, index-1, memo, 'r' + test);
            totalWays += numWays(direction, steps, isLeft, maxLeft, maxRight, index-1, memo, test);
        }

        if (steps >= 0) {
            memo[index][steps][0] = totalWays;
        } else {
            memo[index][Math.abs(steps)][1] = totalWays;
        }
        return totalWays;
    }

    public static void main(String[] args) {
        String s = "rrlrlr";
        int res = numWays(s, 6, 1, 2);
        System.out.println(res);
    }
}
