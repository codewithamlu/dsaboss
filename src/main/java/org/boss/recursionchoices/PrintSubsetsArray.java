package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsetsArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        subsets(arr);
    }

    static void subsets(int[] arr) {
        solve(arr, 0, new ArrayList<>());
    }

    static void solve(int[] arr, int i, List<Integer> out) {
        if (i == arr.length) {
            System.out.println(out);
            return;
        }
        // Pick element
        out.add(arr[i]);
        solve(arr, i + 1, out);
        // not to Pick element
        out.remove(out.size() - 1);
        solve(arr, i + 1, out);
    }
}
