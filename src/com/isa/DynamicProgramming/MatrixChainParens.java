package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-03-03.
 */
public class MatrixChainParens {
    static int[][] m; // m[i][j] stores cost/number of mults to be done for multiplying matrix Ai to Aj
    static int[][] s; // s[i][j] stores k for how to partition the chain of matrices to get optimal cost

    public static int matrixChainOrder(int[] matrices){
        int n = matrices.length - 1;  // because matrices stores only the size

        m = new int[n][n];  // matrix 0 to n-1
        s = new int[n][n];

        // only one matrix, does not incur any cost of multiplication
        // row 0
        for(int i = 0; i < n; i++){
            m[i][i] = 0;
        }

        for(int row = 1; row < n; row++){  // length of chain = row+1
            for(int i = 0; i < n - row; i++){ // values per row
                int j = i + row;
                m[i][j] = Integer.MAX_VALUE; // set to infinity
                for(int k = i; k < j; k++){  // split
                    // formula we should derive at the beginning
                    int q = m[i][k] + m[k + 1][j] + matrices[i]*matrices[k + 1]*matrices[j + 1];

                    if(q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }

                // when we are at top cornor
                if(row == matrices.length - 2){
                    printOptimalParens(matrices, 0, n-1);
                    return m[i][j];  // return cost
                }
            }
        }
        return -1;  //error
    }

    public static void printOptimalParens(int[] matrices, int i, int j){
        if(i == j){
            System.out.print(i+1); // convert to matrix 1 to n
        }else{
            System.out.print("(");
            printOptimalParens(matrices, i, s[i][j]);
            printOptimalParens(matrices, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    // Given a sequence of matrices M
    public static int[][] matrixChainMult(int[][][] M, int s[][], int i, int j){
        if(i == j){
            return M[i];
        }

        if(j == i+1){
            return matrixMultiply(M[i], M[j]);
        }

        int[][] A = matrixChainMult(M, s, i, s[i][j]);
        int[][] B = matrixChainMult(M, s, s[i][j]+1, j);
        return matrixMultiply(A, B);
    }

    // A[row][col]
    public static int[][] matrixMultiply(int[][] A, int[][] B){
        // bad operation if A.columns != B.rows
        if(A[0].length != B.length){
            System.err.print("imcompatible dimensions");
            return null;
        }

        // resulting matrix has dimension A.rows x B.columns
        int[][] C = new int[A.length][B[0].length];

        for(int i = 0; i < A.length; i++){   // first row
            for(int j = 0; j < B[0].length; j++){   // first column
                C[i][j] = 0;
                for(int k = 0; k < A[0].length; k++){  // loop through kth num in A's specific row,
                                                       // also kth num in B's specific column
                    C[i][j] += A[i][k]*B[k][j];
                }
            }
        }

        return C;
    }

    public static void printMatrix(int[][] M){
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                System.out.print(M[i][j]);
            }
            System.out.println();
        }
    }
}
