package com.isa.Interviews.Recursion;

import java.util.ArrayList;

public class RecurseAroundCell {
   ArrayList<Integer> computePondSizes(int[][] land) {
   boolean[][] visited = new boolean[land.length][land[0].length];
   ArrayList<Integer> pondSizes = new ArrayList<Integer>();
   for (int r = 0; r < land. length; r++) {
     for (int c = 0; c < land[r].length; c++) {
       int size = computeSize(land, visited, r, c);
       if (size> 0) {
          pondSizes.add(size);
       }
     }
   }
   return pondSizes;
 }

 int computeSize(int[][] land, boolean[][] visited, int row, int col) {
   // If out of bounds or already visited.
   if (row < 0 || col < 0 || row >= land.length || col >= land[row].length ||
        visited[row][col] || land[row][col] != 0) {
        return 0;
   }
   int size = 1;
   visited[row][col] = true;

   // a good way to recurse on all eight cells around this cell
   for (int dr = -1; dr <= 1; dr++) {
     for (int dc = -1; dc <= 1; dc++) {
        size += computeSize(land, visited, row + dr, col + dc);
     }
   }
   return size;
 }
}
