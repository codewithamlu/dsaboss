package org.boss.arrays2;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
//        int[][] mat = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] mat = {{0}, {1}};
        setZeroes3(mat);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    // Brute force - Iterate over each element and apply zero by putting -1 marking them will allow us to make those marked elements make zeroes
    // Consider matrix has only positive natural numbers and 0
    static void setZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // Mark -1 for row and col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    markRows(mat, i);
                    markColumns(mat, j);
                }
            }
        }
        // Substitute 0 for -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    static void markRows(int[][] mat, int row) {
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[row][j] != 0)
                mat[row][j] = -1;
        }
    }

    static void markColumns(int[][] mat, int col) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] != 0)
                mat[i][col] = -1;
        }
    }

    // Better Approach by Considering extra row and column and marking it, so we can do it with  * O(2 * m * n)
    static void setZeroes2(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        // Mark rows and column where cell = 0 mark = 1
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // Put 0 for marked rows or columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    // Optimal - No extra space complexity
    // Instead of using extra space lets use first row and first column as our reference ones
    static void setZeroes3(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int col0 = 1;
        // Mark first row and column as reference where cell = 0 use mark = 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if (j != 0)
                        mat[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        //  Put 0 for marked rows or columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] != 0) {
                    if (mat[i][0] == 0 || mat[0][j] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }
        }
        if(mat[0][0] == 0){
            for(int j = 0; j < n; j++){
                mat[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i = 0; i < m; i++){
                mat[i][0] = 0;
            }
        }
    }
}
