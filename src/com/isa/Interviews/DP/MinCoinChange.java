package com.isa.Interviews.DP;

/**
 * Created by isa on 2017-04-16.
 */
public class MinCoinChange {
    // http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
    // m is size of coins array (number of different coins)
    public static int minCoins(int coins[], int typesOfCoins, int amount)
    {
        // table[i] will be storing the minimum number of coins
        // required for i value.  So table[V] will have result
        int[] table = new int[amount+1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= amount; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to amount
        for (int i = 1; i <= amount; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < typesOfCoins; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i-coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
        }
        return table[amount];
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int coins[] =  {9, 6, 5, 1};
        int typesOfCoins = coins.length;
        int amount = 11;
        System.out.println("Minimum coins required is " +
                minCoins(coins, typesOfCoins, amount));
    }
}
