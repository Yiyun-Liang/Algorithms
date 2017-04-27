package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-04-27.
 */
public class StripePainter {
    // https://community.topcoder.com/stat?c=problem_statement&pm=1215&rd=4555
    int minStrokes(String stripes) {
        int[][] M = new int[50][50];

        for(int i=0;i<50;i++) {
            for(int j=0;j<50;j++) {
                M[i][j] = 100000; } }

        for(int i=0;i<50;i++) {
            M[i][i]=1; }

        int N = stripes.length();
        for(int l=1;l<N;l++) {
            for(int i=0;i<N-l;i++) {
                int j=i+l;
                for(int k=i;k<j;k++) {
                    if(M[i][k]<100000 && M[k+1][j] < 100000)
                        M[i][j] = Math.min(M[i][j],M[i][k]+M[k+1][j]);
                }
                if(M[i][j]<100000 && stripes.charAt(i) == stripes.charAt(j)) M[i][j]--;
            }
        }

        return M[0][N-1];
    }

}
