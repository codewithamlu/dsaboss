package org.boss.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze1 {
    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        // paths(mat);
        ArrayList<String> ans = findPath(mat, mat.length);
        System.out.println(ans);
    }

    static void paths(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        solve(mat, 0, 0, new ArrayList<>(), visited);
    }

    static void solve(int[][] mat, int i, int j, List<Character> list, boolean[][] visited) {
        int n = mat.length, m = mat[0].length;

        if (i == n - 1 && j == m - 1) {
            System.out.println(list);
            return;
        }
        if (i < 0 || i == n || j < 0 || j == m || mat[i][j] == 1 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        // Top
        list.add('t');
        solve(mat, i - 1, j, list, visited);
        list.remove(list.size() - 1);

        // Right
        list.add('r');
        solve(mat, i, j + 1, list, visited);
        list.remove(list.size() - 1);

        // Bottom
        list.add('b');
        solve(mat, i + 1, j, list, visited);
        list.remove(list.size() - 1);

        // Left
        list.add('t');
        solve(mat, i, j - 1, list, visited);
        list.remove(list.size() - 1);

        visited[i][j] = false;
    }

    static void paths2(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        solve2(mat, 0, 0, "", visited);
    }

    static void solve2(int[][] mat, int i, int j, String out, boolean[][] visited) {
        int n = mat.length, m = mat[0].length;

        if (i < 0 || i == n || j < 0 || j == m || mat[i][j] == 1 || visited[i][j]) {
            return;
        }
        if (i == n - 1 && j == m - 1) {
            System.out.println(out);
            return;
        }
        visited[i][j] = true;
        // Top
        solve2(mat, i - 1, j, out + 't', visited);
        // Right
        solve2(mat, i, j + 1, out + 'r', visited);
        // Bottom
        solve2(mat, i + 1, j, out + 'b', visited);
        // Left
        solve2(mat, i, j - 1, out + 'l', visited);
        visited[i][j] = false;
    }

    // GFG - Rat In Maze where 0 represents no way ahead for making path
    public static ArrayList<String> findPath(int[][] mat, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        solve3(mat, n, 0, 0, "", visited, ans);
        return ans;
    }

    static void solve3(int[][] mat, int n, int i, int j, String out, boolean[][] visited, ArrayList<String> ans) {

        if (i < 0 || i == n || j < 0 || j == n || mat[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (i == n - 1 && j == n - 1) {
            ans.add(out);
            return;
        }
        visited[i][j] = true;
        // Top
        solve3(mat, n, i - 1, j, out + 'U', visited, ans);
        // Right
        solve3(mat, n, i, j + 1, out + 'R', visited, ans);
        // Bottom
        solve3(mat, n, i + 1, j, out + 'D', visited, ans);
        // Left
        solve3(mat, n, i, j - 1, out + 'L', visited, ans);
        visited[i][j] = false;
    }
}
