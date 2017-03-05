package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-03-04.
 */
public class Fibonacci {

    // T(n) = T(n-1) + T(n-2) + O(1)  -->  O(n^2)
    public int fibNaive(int n){
        if(n <= 1){  // to avoid all cases smaller than 1
            return 1;
        }else{
            return fibNaive(n-1) + fibNaive(n-2);  // careful not to give index -1
        }
    }

    // O(n)
    public int fibTopDown(int n){
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 1;

        return fibTopDown(memo, n);
    }

    public int fibTopDown(int[] memo, int n){
        if(memo[n] > 0){
            return memo[n];
        }

        memo[n] = fibTopDown(memo, n-1) + fibTopDown(memo, n-2);

        return memo[n];
    }

    // O(n) solution
    public int fibBottomUp(int n){
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    // space optimization on O(n) bottom up solution
    public int fibBottomUpSpaceOptimized(int n){
        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++){
            int temp = memo[0] + memo[1];
            memo[0] = memo[1];
            memo[1] = temp;
        }

        return memo[1];
    }


    // ALTERNATIVE: use matrix multiplication

    // 1)
    // O(n)
    public int fib(int n)
    {
        int F[][] = new int[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(F, n-1);

        return F[0][0];
    }

    /* Helper function that multiplies 2 matrices F and M of size 2*2, and
    puts the multiplication result back to F[][] */
    public void multiply(int F[][], int M[][])
    {
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /* Helper function that calculates F[][] raise to the power n and puts the
    result in F[][]
    Note that this function is designed only for fib() and won't work as general
    power function */
    public void power(int F[][], int n)
    {
        int i;
        int M[][] = new int[][]{{1,1},{1,0}};

        // n - 1 times multiply the matrix to {{1,0},{0,1}}
        for (i = 2; i <= n; i++)
            multiply(F, M);
    }

    // 2) O(lgn) time, extra O(lgn) space for stack size for recursive calls
    // optimized on top of 1)
    public void powerOptimized(int F[][], int n){
        if(n == 0 || n == 1){
            return;
        }

        int M[][] = new int[][]{{1,1},{1,0}};

        powerOptimized(F, n/2);
        multiply(F, F);

        if(n % 2 != 0){
            multiply(F, M);
        }
    }

    // 3) O(lgn)
    /*
        Based on a formula:
            if n is odd, k = n/2, F(n) = F(k)*F(k) + F(k-1)*F(k-1)
            if n is even, k = (n+1)/2, F(n) = [2*F(k-1) + F(k)]*F(k)
     */

    public int fibSmart(int n){
        int[] f = new int[n+1];
        return fibSmart(f, n);
    }

    public int fibSmart(int[] memo, int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return (memo[n] = 1);
        }

        if(memo[n] > 0){
            return memo[n];
        }

        // see if n is odd or even
        int k = (n & 1) == 1 ? (n+1)/2 : n/2;

        // Applyting above formula [Note value n&1 is 1
        // if n is odd, else 0.
        memo[n] = (n & 1) == 1 ? (fib(k)*fib(k) + fib(k-1)*fib(k-1))
                : (2*fib(k-1) + fib(k))*fib(k);

        return memo[n];
    }
}
