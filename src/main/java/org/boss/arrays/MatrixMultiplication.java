package org.boss.arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2 }, { 3, 4 } };
        int[][] arr2 = { { 5, 7, 9 }, { 6, 8, 10 } };

        int rows1 = arr1.length, cols1 = arr1[0].length;
        int rows2 = arr2.length, cols2 = arr2[0].length;

        if (cols1 != rows2) {
            System.out.println("Cannot multiply matrices");
        } else {
            int[][] ans = multiply(arr1, arr2, rows1, cols1, rows2, cols2);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[0].length; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    /*
     * Conventional matrix multiplication
     * 
     * Time Complexity : O(n1*m2*k)
     * Space Complexity : O(n1*m2)
     */
    static int[][] multiply(int[][] arr1, int[][] arr2, int rows1, int cols1, int rows2, int cols2) {
        int[][] ans = new int[rows1][cols2];

        for (int r = 0; r < rows1; r++) {
            for (int c = 0; c < cols2; c++) {
                ans[r][c] = 0;
                for (int k = 0; k < rows2; k++) {
                    ans[r][c] += arr1[r][k] * arr2[k][c];
                }
            }
        }
        return ans;
    }
}
