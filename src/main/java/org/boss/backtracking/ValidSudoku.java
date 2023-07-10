package org.boss.backtracking;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
        System.out.println(isValidSudoku(board));

    }

    static boolean isValidSudoku(char[][] board) {
        return solve(board, 0, 0);
    }

    static boolean solve(char[][] arr, int r, int c) {
        if (r == arr.length)
            return true;
        if (c == arr.length)
            return solve(arr, r + 1, 0);
        if (arr[r][c] != '.') {
            boolean initial = valid(arr, r, c, arr[r][c]);
            if (initial)
                return initial && solve(arr, r, c + 1);
            else
                return false;
        } else {
            return solve(arr, r, c + 1);
        }

    }

    static boolean valid(char[][] arr, int r, int c, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (i == r)
                continue;
            if (arr[i][c] == ch)
                return false;
        }
        for (int j = 0; j < arr.length; j++) {
            if (j == c)
                continue;
            if (arr[r][j] == ch)
                return false;
        }
        int x = r - r % 3, y = c - c % 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (i == r && j == c)
                    continue;
                if (arr[i][j] == ch)
                    return false;
            }
        }
        return true;
    }
}
