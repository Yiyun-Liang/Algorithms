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

    // inefficient recursive solution, too many recursion calls
    public static String LCSNaive(String a, String b){
        int aLen = a.length();
        int bLen = b.length();
        if(aLen == 0 || bLen == 0){
            return "";
        }else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
            return LCSNaive(a.substring(0,aLen-1),b.substring(0,bLen-1))
                    + a.charAt(aLen-1);
        }else{
            String x = LCSNaive(a, b.substring(0,bLen-1));
            String y = LCSNaive(a.substring(0,aLen-1), b);
            return (x.length() > y.length()) ? x : y;
        }
    }

    // Top down with memoization

    public static int LCSTopDown(String a, String b){
        int m = a.length();
        int n = b.length();

        int[][] memo = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                memo[i][j] = -1;
            }
        }

        return LCSTopDown(memo, a, b, a.length(), b.length());
    }

    public static int LCSTopDown(int[][] memo, String a, String b, int i, int j){
        if(memo[i][j] > -1){  // >= 0
            return memo[i][j];
        }

        if(i == 0 || j == 0){
            memo[i][j] = 0;
        }else{
            if(a.charAt(i-1) == b.charAt(j-1)){
                memo[i][j] = LCSTopDown(memo, a, b, i-1, j-1) + 1;
            }else{
                memo[i][j] = Math.max(LCSTopDown(memo, a, b, i-1, j), LCSTopDown(memo, a, b, i, j-1));
            }
        }

        return memo[i][j];
    }

    // Bottom up approach, takes O(mn) time and space(for C table)
    public static int[][] LCSLength(String X, String Y){
        int m = X.length();
        int n = Y.length();

        int[][] C = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            C[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){
            C[0][j] = 0;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(X.charAt(i) == Y.charAt(j)){       // chars are primitive type, can be compared directly
                    C[i+1][j+1] = C[i][j] + 1;
                }else{
                    C[i+1][j+1] = Math.max(C[i][j+1], C[i+1][j]);
                }
            }
        }

        // read the substring out from the matrix
        StringBuffer sb = new StringBuffer();
        for(int x = X.length(), y = Y.length(); x != 0 && y != 0;){
            if(C[x][y] == C[x-1][y]){
                x--;
            }else if(C[x][y] == C[x][y-1]){
                y--;
            }else{
                // assertions are used to verify the correctness of an invariant in the code.
                // They can be activated at run-time by way of the -ea option on the java command,
                // but are not turned on by default.
                assert X.charAt(x-1) == Y.charAt(y-1);
                sb.append(X.charAt(x-1));
                x--;
                y--;
            }
        }

        String result =  sb.reverse().toString();
        System.out.println(result);

        return C;
    }

    // print without S table
    // i and j are length-1 of X and Y respectively
    public static void printLCS(int[][] C, String X, String Y, int i, int j){
        if(i == 0 || j == 0){
            return;
        }

        if(X.charAt(i) == Y.charAt(j)){
            printLCS(C, X, Y, i, j);
            System.out.print(X.charAt(i));
        }else if(C[i-1][j] >= C[i][j-1]){
            printLCS(C, X, Y, i-1, j);
        }else{
            printLCS(C, X, Y, i, j-1);
        }
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

        String A = "10010101";
        String B = "010110110";

        int[][] C = LCS.LCSLength(A, B);

        System.out.println(C[A.length()][B.length()]);
        //printLCS(S, X, X.length(), Y.length()); // BCBA
    }
}
