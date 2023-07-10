package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class PerfectSum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 10 };
        // System.out.println(perfectSum(arr, arr.length, 10));
        perfectSum3(arr, arr.length, 10);
    }

    static int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        return solve(arr, 0, 0, sum);
    }

    static int solve(int[] arr, int i, int cSum, int sum) {
        if (cSum > sum)
            return 0;
        if (i == arr.length) {
            if (cSum == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        // Pick element
        cSum += arr[i];
        int left = solve(arr, i + 1, cSum, sum);

        // Not to pick element
        cSum -= arr[i];
        int right = solve(arr, i + 1, cSum, sum);

        return left + right;
    }

    static void perfectSum2(int arr[], int n, int sum) {
        // Your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        solve2(arr, 0, 0, sum, new ArrayList<Integer>(), ans);
        System.out.println(ans);
    }

    static void solve2(int[] arr, int i, int cSum, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (cSum > sum)
            return;
        if (i == arr.length) {
            if (cSum == sum) {
                ans.add(new ArrayList<>(list));
                return;
            } else
                return;
        }
        // Pick element
        cSum += arr[i];
        list.add(arr[i]);
        solve2(arr, i + 1, cSum, sum, list, ans);

        // Not to pick element
        cSum -= arr[i];
        list.remove(list.size() - 1);
        solve2(arr, i + 1, cSum, sum, list, ans);

    }

    static void perfectSum3(int arr[], int n, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        solve3(arr, 0, 0, sum, new ArrayList<Integer>(), ans);
        System.out.println(ans);
    }

    static void solve3(int[] arr, int i, int cSum, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (cSum > sum)
            return;
        if (i == arr.length) {
            if (cSum == sum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        // Pick element
        list.add(arr[i]);
        solve3(arr, i, cSum + arr[i], sum, list, ans);

        // Not to pick element
        list.remove(list.size() - 1);

        solve3(arr, i + 1, cSum, sum, list, ans);

    }
}
