package com.isa.BackTracking;

/**
 * Created by isa on 2017-05-08.
 */
public class EightQueens {

    private int N = 1;
    private int solutions = 0;

    private boolean possible(int row, int col){
        return false;
    }

    private boolean cancel(int row, int col){
        return false;
    }

    private boolean reserve(int row, int col){
        return false;
    }

    private void printSolution(){

    }

    private void addQueen(int x){

    }

    private void addQueenShorter(int row) {
        for (int col = 0; col <= N-1; col++) {
            if (possible(row, col)) {
                reserve(row, col);
                if (row == N-1) {
                    printSolution();
                    solutions++;
                } else {
                    addQueen(row + 1);
                }
                cancel(row, col);
            }
        }
    }
}
