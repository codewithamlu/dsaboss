package org.boss.binarysearch;

public class Search2DMatrix {
    public static void main(String[] args) {

    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int size = m * n;
        int start = 0, end = size - 1;
        while (start <= end) {
            int mid =( start + end) / 2;
            int i = mid / n; // row index
            int j = mid % n; // column index

            if (matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
