package org.boss.arrays;

public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };

        int[][] ans = transpose(matrix);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        // transposeInPlace(matrix);
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println();
        // }
    }

    /*
     * we are given m*m matrix , so we decalre our new matrix as m*n taking into
     * consideration
     * Store (i,j) -> (j,i)
     * 
     * Time Complexity : O(n*m)
     * Space Complexity : O(m*n)
     */
    static int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    /*
     * Given a square matrix , we swap elements at non-diagonal position,
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static void transposeInPlace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

    }
}
