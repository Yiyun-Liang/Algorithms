package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-02-26.
 */
public class Main {

    public static void main(String[] args){
        int[] prices = {0,1,5,8,9,10,17,17,20,24,30};
        RodCutting rdc = new RodCutting();

        //rdc.printRodCuttingSolution(prices, 10);
        //rdc.printRodCuttingMaxProfit(prices, 10);

        Fibonacci fib = new Fibonacci();
        int s = fib.fibBottomUp(7);
        //System.out.println(s);

        // means matrices 30x35, 35x15, 15x5, 5x10, 10x20, 20x25 -> 15125 scalar multiplications
        int[] matrix = {30, 35, 15, 5, 10, 20, 25};
        int[] matrix2 = {10, 100, 5, 50};  //this should return 7500
        int[] matrix3 = {5, 10, 3, 12, 5, 50, 6};
        int c = MatrixChainParens.matrixChainOrder(matrix3);
        System.out.println(c);

        // test matrix chain multiplication
        int[][] T1 = {{1, 1}, {1, 0}};
        int[][] S = MatrixChainParens.matrixMultiply(T1, T1);
        MatrixChainParens.printMatrix(S);

        // practice on 2D array
        int[][] A = {{1, 1}, {1, 0}, {2, 3}};
        int[][] B = {};
        //System.out.println(A[1][1]); // 0, A[row][col]
        //System.out.println(A.length);  // 3 number of int[]
        //System.out.println(A[0].length); // length of one int[[ in the array of int[]
    }
}
