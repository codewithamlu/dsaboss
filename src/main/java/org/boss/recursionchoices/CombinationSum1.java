package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 10 };
        int target = 10;
        combineSum(arr, arr.length, target);
    }

    static void combineSum(int arr[], int n, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(arr, 0, 0, sum, new ArrayList<Integer>(), ans);
        System.out.println(ans);
    }

    static void solve(int[] arr, int i, int cSum, int sum, List<Integer> list, List<List<Integer>> ans) {
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
        solve(arr, i, cSum + arr[i], sum, list, ans);

        // Not to pick element
        list.remove(list.size() - 1);

        solve(arr, i + 1, cSum, sum, list, ans);

    }
}
