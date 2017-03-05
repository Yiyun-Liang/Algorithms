package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-03-05.
 */
public class LCS {
    /*
        Longest common subsequence problem:

        Eg. X = {A, B, C, B, D, B, A}, Y = {B, D, C, A, B, A}
                    -  -  -        -        -     -     -  -
        LCS = {B, C, B, A}
     */

    /*
        Optimal Substructure of an LCS:
        Let X = {x1, x2, x3, ..., xm} and Y = {y1, y2, ..., yn}
        and Z = {z1, z2, .., zk} be any LCS of X and Y

        1) if xm = yn, then zk = xm = yn, and Zk-1 is an LCS of Xm-1 and Yn-1
        2) if xm != yn, then if zk != xm, Z is an LCS of Xm-1 and Y
        3) if xm != yn, then if zk != yn, Z is an LCS of Xm and Yn-1
     */

    /*
        Let C[i, j] be the length of an LCS of the sequences Xi and Yj

                  |  0                           if i = 0 if j = 0
        C[i, j] = |  C[i-1, j-1]+1               if xi = yj and i, j > 0
                  |  max{C[i-1, j], C[i, j-1]}   if xi != yj and i, j > 0

        Notice that not all subproblems are used in this problem
     */

    // Bottom up approach, takes O(mn) time and space
    public static int[][][] LCSLength(String X, String Y){
        int m = X.length();
        int n = Y.length();

        int[][] C = new int[m+1][n+1];
        int[][] S = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            C[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){
            C[0][j] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){       // chars are primitive type, can be compared directly
                    C[i][j] = C[i-1][j-1] + 1;
                    S[i][j] = 1;
                }else if(C[i-1][j] >= C[i][j-1]){
                    C[i][j] = C[i-1][j];
                    S[i][j] = 2;
                }else{
                    C[i][j] = C[i][j-1];
                    S[i][j] = 3;
                }
            }
        }

        int[][][] ret = {C, S};

        return ret;
    }

    // O(m+n)
    public static void printLCS(int[][] S, String X, int i, int j){
        if(i == 0 || j == 0){
            return;
        }

        if(S[i][j] == 1){
            printLCS(S, X, i-1, j-1);
            System.out.print(X.charAt(i-1));
        }else if(S[i][j] == 2){
            printLCS(S, X, i-1, j);
        }else{
            printLCS(S, X, i, j-1);
        }
    }

    public static void main(String[] args){
        String X = "ABCBDAB";
        String Y = "BDCABA";

        int[][][] R = LCS.LCSLength(X, Y);
        int[][] C = R[0];
        int[][] S = R[1];

        System.out.println(C[X.length()][Y.length()]);
        printLCS(S, X, X.length(), Y.length()); // BCBA
    }
}
