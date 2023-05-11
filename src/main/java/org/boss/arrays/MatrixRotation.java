package org.boss.arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2 }, { 4, 5 } };

        rotate(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] mat) {
        transposeInPlace(mat);
        reverse(mat);

    }

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

    static void reverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int low = 0, high = matrix.length - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }

}
