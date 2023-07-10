package org.boss.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        print(n);
    }

    static void print(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] arr = new int[n][n];
        solve(arr, 0, res);
        System.out.println(res);
    }

    static void solve(int[][] arr, int r, List<List<String>> res) {
        if (r == arr.length) {
            fill2(arr, res);
            return;
        }
        for (int c = 0; c < arr.length; c++) {
            if (valid(arr, r, c)) {
                arr[r][c] = 1;
                solve(arr, r + 1, res);
                arr[r][c] = 0;
            }
        }
    }

    static boolean valid(int[][] arr, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (arr[i][c] == 1)
                return false;
        }
        for (int j = 0; j < c; j++) {
            if (arr[r][j] == 1)
                return false;
        }
        for (int i = r, j = c; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 1)
                return false;
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1)
                return false;
        }
        return true;
    }

    static void fill(int[][] arr, List<List<String>> res) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String s = "";
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1)
                    s += "Q";
                else
                    s += ".";
            }
            list.add(s);
        }
        res.add(list);
    }

    static void fill2(int[][] arr, List<List<String>> res) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1)
                    s.append('Q');
                else
                    s.append('.');
            }
            list.add(s.toString());
        }
        res.add(list);
    }
}
