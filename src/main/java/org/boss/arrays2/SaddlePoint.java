package org.boss.arrays2;

public class SaddlePoint {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3},
                {4, 5, 6},
                {8, 7, 9}};
        findSaddlePoint(mat);
    }

    static void findSaddlePoint(int[][] mat) {
        int[] ans = new int[2];
        int rows = mat.length, cols = mat[0].length;
        boolean flag = false;
        int val = 0;
        for (int i = 0; i < rows; i++) {
            int minVal = mat[i][0], minC = 0;
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] < minVal) {
                    minVal = mat[i][j];
                    val = minVal;
                    minC = j;
                }
            }
            flag = checkMaximum(mat, minC, minVal);

        }
        if (flag)
            System.out.println("Saddle Point present " + val);
        else
            System.out.println("No Saddle Point");
    }

    static boolean checkMaximum(int[][] mat, int minCol, int maxVal) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][minCol] > maxVal)
                return false;
        }
        return true;
    }
}
