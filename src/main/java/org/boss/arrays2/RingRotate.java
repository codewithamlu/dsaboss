package org.boss.arrays2;

import java.util.Arrays;

public class RingRotate {
    public static void main(String[] args) {
        int[][] mat = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        ringRotate(mat, 2, 1);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    static void ringRotate(int[][] mat, int s, int k) {
        int[] arr1D = get1DArr(mat, s);
        rotate1DArr(arr1D, k);
        putBack(mat, arr1D, s);

    }

    static int[] get1DArr(int[][] mat, int s) {
        int minRow = s - 1, minCol = s - 1;
        int maxRow = mat.length - s, maxCol = mat[0].length - s;
        int size = 2 * (maxRow - minRow + maxCol - minCol);
        int[] arr = new int[size];
        // Spiral traversal of matrix
        int idx = 0;
        // Bottom
        for (int i = minRow; i <= maxRow; i++) {
            arr[idx] = mat[i][minRow];
            idx++;
        }
        minCol++;
        // Right
        for (int i = minCol; i <= maxCol; i++) {
            arr[idx] = mat[maxRow][i];
            idx++;
        }
        maxRow--;
        // Top
        for (int i = maxRow; i >= minRow; i--) {
            arr[idx] = mat[i][maxCol];
            idx++;
        }
        maxCol--;
        // Left
        for (int i = maxCol; i >= minCol; i--) {
            arr[idx] = mat[minRow][i];
            idx++;
        }
        return arr;
    }

    static void rotate1DArr(int[] arr, int k) {
        // Convert value of k into 0 - n by taking modulus
        k %= arr.length;
        // If k is negative , add n to k so that it comes in our range
        if (k < 0)
            k += arr.length;

        reverseArrayStartToEnd(arr, 0, arr.length - 1);
        reverseArrayStartToEnd(arr, 0, k - 1);
        reverseArrayStartToEnd(arr, k, arr.length - 1);
    }

    static void putBack(int[][] mat, int[] arr, int s) {
        int minRow = s - 1, minCol = s - 1;
        int maxRow = mat.length - s, maxCol = mat[0].length - s;

        // Spiral insertion into matrix
        int idx = 0;
        // Bottom
        for (int i = minRow; i <= maxRow; i++) {
            mat[i][minCol] = arr[idx];
            idx++;
        }
        minCol++;
        // Right
        for (int i = minCol; i <= maxCol; i++) {
            mat[maxRow][i] = arr[idx];
            idx++;
        }
        maxRow--;
        // Top
        for (int i = maxRow; i >= minRow; i--) {
            mat[i][maxCol] = arr[idx];
            idx++;
        }
        maxCol--;
        // Left
        for (int i = maxCol; i >= minCol; i--) {
            mat[minRow][i] = arr[idx];
            idx++;
        }
    }

    // Both start & end are inclusive
    static void reverseArrayStartToEnd(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
