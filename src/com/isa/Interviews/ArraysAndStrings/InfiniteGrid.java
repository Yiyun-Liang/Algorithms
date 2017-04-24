package com.isa.Interviews.ArraysAndStrings;

import java.util.HashSet;
import java.util.Objects;

/**
 * Created by isa on 2017-04-24.
 */
public class InfiniteGrid {
    /*
        Approach 1: Resizable array

        to resize a 2D array, usually either doubles # rows or doubles # columns
        int this way, grid[i].length are all the same for every i
     */

    private boolean[][] grid;

    public InfiniteGrid(){
        grid = new boolean[1][1];
    }

    /* Copy old values into new array, with an offset/shift applied to the row and columns. */
    public void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftCol){
        for(int r = 0; r < oldGrid.length; r++){
            for(int c = 0; c < oldGrid[0].length; c++){
                newGrid[r+shiftRow][c+shiftCol] = oldGrid[r][c];
            }
        }
    }

    // ensure a move fits in the matrix, otherwise, doubles either # rows or # columns
    private void ensureFit(int row, int col){
        int shiftRow = 0;
        int shiftCol = 0;

        int numRows = grid.length;
        if(row < 0){
            shiftRow = numRows;
            numRows *= 2;
        }else if(row >= numRows){
            numRows *= 2;
        }

        int numCols = grid[0].length;
        if(col < 0){
            shiftCol = numCols;
            numCols *= 2;
        }else if(col >= numCols){
            numCols *= 2;
        }

        // resize
        if(numRows != grid.length || numCols != grid[0].length){
            boolean[][] newGrid = new boolean[numRows][numCols];
            copyWithShift(grid, newGrid, shiftRow, shiftCol);
            grid = newGrid;
        }
    }

    // override toString to print out the grid
    /*
        // change orientation variable, then call this function
        public void move() {
            if (orientation == Orientation.left) {
            position.column--;
            } else if (orientation == Orientation.right) {
            position.column++;
            } else if (orientation == Orientation. up) {
            position.row-- ;
            } else if (orientation == Orientation.down) {
            position.row++; }
        }
     */

    /*
        Keep another enum Orientation class with values up,down,left,right
        keep a function getTurn to take boolean clockwise and to return a Orientation
     */

    /*
        Approach 2: HashSet

            Easier for the question of an ant flipping colors
            if a position is in the hashset, it is white, otherwise, it is black

            but how do we print out the board?
            keep two positions topLeftCorner(min row and col) and bottomRightCorner(max row and col)
            update when the ant moves, then in the end when we want to print out the grid
            we know the bounds, then we check if each cell is in the grid
     */

    private HashSet<Position> whites = new HashSet<>();
    Position topLeftCorner;
    Position bottomRightCorner;
}

class Position{
    /*
        This position will be keys in a hashset
        so we need to implement a hashCode function!!!
     */

    int row, col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Position){
            Position p = (Position) o;
            return p.row == this.row && p.col == this.col;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (row * 31) ^ col;  // many options for hash functions
    }

    public Position clone(){
        return new Position(row, col);
    }
}
