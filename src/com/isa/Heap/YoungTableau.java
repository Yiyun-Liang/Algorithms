package com.isa.Heap;

/**
 * Created by isa on 2017-02-12.
 */
public class YoungTableau {

    /*
        Recurrence:
            let p = m+n
            T(p) <= T(p-1) + O(1) = O(p)

        Time complexity: O(m+n)
     */
    public int extractMin(int[][] matrix){
        int min = matrix[0][0];
        matrix[0][0] = Integer.MAX_VALUE;

        youngify(matrix, 0, 0);

        return min;
    }

    /*
        Time complexity: O(m+n)
     */
    public void insert(int[][] matrix, int key){
        if(isFull(matrix)){
            System.out.println("No more insertions possible, The tableau is full");
            return;
        }

        int i = matrix.length - 1;
        int j = matrix[0].length-1;
        // insert to last position if matrix is not full
        matrix[i][j] = key;

        int x = i;
        int y = j;

        while(i > 0 || j > 0){
            // find the bigger of its neighbors and swap with them
            if(i-1 >= 0 && matrix[i][j] < matrix[i-1][j]){
                x = i-1;
                y = j;
            }

            if(j-1 >= 0 && matrix[x][y] < matrix[i][j-1]){
                x = i;
                y = j-1;
            }

            if(i != x || j != y){
                exch(matrix, i, j, x, y);
                i = x;
                j = y;
            }else{
                break;
            }
        }
    }

    // search to see if key exists in the young tableau
    // O(m+n) worst-time
    public boolean exists(int[][] matrix, int key){
        return exists(matrix, key, 0, 0);
    }

    public boolean exists(int[][] matrix, int key, int i, int j){
        if(i >= matrix.length || j >= matrix[0].length){
            return false;
        }

        int c = matrix[i][j];

        if(c == key){
            return true;
        }else if(c > key){
            return false;
        }else{
            return exists(matrix, key, i+1, j) || exists(matrix, key, i, j+1);
        }
    }

    public void youngify(int[][] matrix, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        int x = i;
        int y = j;

        // find smallest of its two neighbors
        if(i + 1 < m && matrix[i][j] > matrix[i+1][j]){
            x = i+1;
            y = j;
        }

        if(j + 1 < n && matrix[x][y] > matrix[i][j+1]){
            x = i;
            y = j+1;
        }

        // if bigger then either of the two, swap, then youngify again
        if(x != i || y != j){
            exch(matrix, i, j, x, y);
            youngify(matrix, x, y);
        }
    }

    public boolean isEmpty(int[][] matrix){
        return matrix[0][0] == Integer.MAX_VALUE;
    }

    public boolean isFull(int[][] matrix){
        return matrix[matrix.length-1][matrix[0].length-1] != Integer.MAX_VALUE;
    }

    // can usually be replaced with insertion technique,
    // by storing the key, then when movings are all done, place the new key
    public void exch(int[][] matrix, int i, int j, int x, int y){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }

    public void printMatrix(int[][] matrix){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
