package com.isa.Interviews.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by isa on 2017-04-16.
 */
public class Coins {
    /*
        Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
        write code to calculate the number of ways of representing n cents.
     */

    public static int makeChange(int n, int[] coins) {
        int[][] memo = new int[n + 1][coins.length];
        return makeChange(n, coins, 0, memo);
    }

    public static int makeChange(int amount, int[] coins, int index, int[][] memo) {
        if (memo[amount][index] > 0) { // memo retrieve value
            return memo[amount][index];
        }

        if (index >= coins.length - 1) return 1; // one coin remaining -> one way to do it

        int coinAmount = coins[index];
        int ways = 0;
        for (int i = 0; i * coinAmount <= amount; i++) {
            // go to next coin, assuming i coins of coinAmount
            int amountRemaining = amount - i * coinAmount;
            ways += makeChange(amountRemaining, coins, index + 1, memo);
        }

        memo[amount][index] = ways;
        return ways;
    }

    // http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
    // faster than the solution shown above
    // bottom up solution
    public static int countWays(int coins[], int numCoins, int amount)
    {
        // Time complexity of this function: O(mn)
        // Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[amount+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < numCoins; i++)
            for (int j = coins[i]; j <= amount; j++)
                table[j] += table[j-coins[i]];

        return table[amount];
    }

    // wrong
    public static int getCoins(int[] coins, int amount, Map<Integer, Integer> memo){
        if(amount == 0){
            return 1;
        }

        if(amount < 0){
            return 0;
        }

        int count = 0;

        for(int c: coins){
            int remaining = amount - c;
            int res = 0;

            if(memo.containsKey(remaining)){
                res = memo.get(remaining);
            }else{
                res = getCoins(coins, remaining, memo);
                memo.put(remaining, res);
            }

            count += res;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        Map<Integer, Integer> memo = new HashMap<>();

        /*long startTime = System.nanoTime();
        //System.out.println(countWays(coins, coins.length, 1000)); // 0ms
        //System.out.println(makeChange(1000, coins));  // 3ms
        System.out.println(getCoins(coins, 1000, memo));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println(duration + "ms");*/

        System.out.println(countWays(coins, coins.length, 4));
    }
}
