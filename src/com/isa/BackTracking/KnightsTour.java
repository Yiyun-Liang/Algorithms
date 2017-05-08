package com.isa.BackTracking;

/**
 * Created by isa on 2017-05-08.
 */
public class KnightsTour {
    /*
        The idea behind the Knight's Tour problem is for a Knight to start on one space on an m x n grid,
        and visit each space exactly once.
        A Knight is limited in its movements to either two rows and one column, or one row and two columns.

        This is where the backtracking comes in. If the Knight reaches a dead end, then it is important
        to backtrack and try another avenue.

        This is a brute force solution used to illustrate the idea of backtracking.
     */
    private static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private boolean[][] grid;
    private int count, spaces;

    private static final Point[] MOVES = new Point[]{
        new Point(-2, -1),
        new Point(-2, 1),
        new Point(2, -1),
        new Point(2, 1),
        new Point(-1, -2),
        new Point(-1, 2),
        new Point(1, -2),
        new Point(1, 2)
    };

    public KnightsTour(int rows, int cols){
        grid = new boolean[rows][cols];
        spaces = rows*cols;
        count = 0;
    }

    /**
     * @param row The current row of the Knight
     * @param col The current column of the Knight
     * @return boolean: true if the Knight visits all of the
     *                  spaces on the grid, false otherwise
     *
     * This method starts with the current space for the Knight.
     * From there, it flags the current space as occupied and increments
     * the counter for the number of occupied spaces. The unvisited
     * spaces are visited individually in a depth-first manner in
     * an attempt to determine if the path will lead to a solution. If
     * it does, true is returned. If not, the current move is undone, the counter
     * is decremented, and false is returned.
     *
     ***/
    public boolean tourFrom(int row, int col){
        grid[row][col] = true;
        count++;

        if(count == spaces)
            return true;

        for(Point p:MOVES){
            int nextRow = row + p.x;
            int nextCol = col + p.y;

            if(nextRow < 0 || nextRow >= grid.length)
                continue;
            else if(nextCol < 0 || nextCol >= grid.length)
                continue;
            else if(grid[nextRow][nextCol])
                continue;
            if(tourFrom(row+p.x, col+p.y))
                return true;
        }

        printGrid();
        grid[row][col] = false;
        count--;
        return false;
    }

    private void printGrid(){
        System.out.println("Count: " + count);
        for(boolean[] rows:grid){
            for(boolean b:rows){
                System.out.print((b) ? "T":"F");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String[] args){
        KnightsTour tour = new KnightsTour(3,3);
        tour.tourFrom(0, 0);
        tour.printGrid();
    }

}