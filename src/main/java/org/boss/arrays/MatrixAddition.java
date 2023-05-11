package org.boss.arrays;

public class MatrixAddition {
    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2 }, { 3, 4 } };
        int[][] arr2 = { { 1, 2 }, { 3, 4 } };

        int[][] ans = add(arr1, arr2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Add respective (i3,j3) = (i1,j1) + (i2,j2)
     * 
     * Time Complexity : O(n*m)
     * Space Complexity : O(n*m)
     */
    static int[][] add(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr1[0].length;

        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return ans;
    }
}
