package com.isa.Interviews.Recursion;

import java.util.ArrayList;

/**
 * Created by isa on 2017-04-16.
 */
public class RobotGetPath {

    static class Point{
        int row;
        int col;

        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    // row -> maze.length - 1
    // col -> maze[0].length - 1

    public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        // If out of bounds or not available, return.
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        // If there's a path from the start to my current location, add my location.
        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true, true},{true, false, true, false},
                {false, true, true, true},{true, false, false, true}};

        ArrayList<Point> path = getPath(maze);
        if (path != null) {
            for(Point p: path){
                System.out.println("(" + p.row + "," + p.col + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }

}
