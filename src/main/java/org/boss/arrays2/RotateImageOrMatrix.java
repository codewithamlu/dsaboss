package org.boss.arrays2;

import java.util.Arrays;
import java.util.List;

public class RotateImageOrMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ans = rotate2(mat);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    static int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = mat[i][j];
            }
        }
        return ans;
    }

    // Optimal - Using Transpose and Reverse
    static int[][] rotate2(int[][] mat) {
        int n = mat.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(ans[i]);
        }
        return ans;
    }

    static void reverse(int[] nums) {
        int si = 0, ei = nums.length - 1;
        while (si < ei) {
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }
}
