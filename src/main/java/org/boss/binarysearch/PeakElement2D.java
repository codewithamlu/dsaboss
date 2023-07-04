package org.boss.binarysearch;

public class PeakElement2D {
    public static void main(String[] args) {

    }

    static int[] findPeakColGrid(int[][] mat) {
        int[] ans = { -1, -1 };
        int m = mat.length, n = mat[0].length;
        int lCol = 0;
        int rCol = n - 1;
        while (lCol <= rCol) {
            int midCol = (lCol + rCol) / 2;
            int maxInRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxInRow][midCol]) {
                    maxInRow = i;
                }
            }

            if ((midCol == 0 || mat[maxInRow][midCol] > mat[maxInRow][midCol - 1])
                    && (midCol == n - 1 || mat[maxInRow][midCol] > mat[maxInRow][midCol + 1])) {
                ans[0] = maxInRow;
                ans[1] = midCol;
                return ans;
            }
            if (midCol > 0 && mat[maxInRow][midCol] < mat[maxInRow][midCol - 1]) {
                rCol = midCol - 1;
            } else {
                lCol = midCol + 1;
            }
        }
        return ans;
    }

    static int[] findPeakRowGrid(int[][] mat) {
        int[] ans = { -1, -1 };
        int m = mat.length, n = mat[0].length;
        int lRow = 0;
        int rRow = m - 1;
        while (lRow <= rRow) {
            int midRow = (lRow + rRow) / 2;
            int maxInCol = 0;
            for (int i = 0; i < n; i++) {
                if (mat[midRow][i] > mat[midRow][maxInCol]) {
                    maxInCol = i;
                }
            }

            if ((midRow == 0 || mat[midRow][maxInCol] > mat[midRow - 1][maxInCol])
                    && (midRow == m - 1 || mat[midRow][maxInCol] > mat[midRow + 1][maxInCol])) {
                ans[0] = midRow;
                ans[1] = maxInCol;
                return ans;
            }
            if (midRow > 0 && mat[midRow][maxInCol] < mat[midRow - 1][maxInCol]) {
                rRow = midRow - 1;
            } else {
                lRow = midRow + 1;
            }
        }
        return ans;
    }
}
