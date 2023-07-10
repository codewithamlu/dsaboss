package org.boss.backtracking;

public class Sudoku {
    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        sudokuSolver(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + ' ');
            }
            System.out.println();
        }
    }

    static void sudokuSolver(char[][] board) {
        solve(board, 0, 0);
    }

    static boolean solve(char[][] arr, int r, int c) {
        if (r == arr.length)
            return true;
        if (c == arr.length)
            return solve(arr, r + 1, 0);
        if (arr[r][c] != '.') {
            return solve(arr, r, c + 1);
        } else {
            for (char n = '1'; n <= '9'; ++n) {
                if (valid(arr, r, c, n)) {
                    arr[r][c] = n;
                    if (solve(arr, r, c + 1))
                        return true;
                    else
                        arr[r][c] = '.';
                }
            }
        }
        return false;
    }

    static boolean valid(char[][] arr, int r, int c, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][c] == ch)
                return false;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[r][j] == ch)
                return false;
        }
        int x = r - r % 3, y = c - c % 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arr[i][j] == ch)
                    return false;
            }
        }
        return true;
    }
}
