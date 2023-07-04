package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = subsets(nums);

    }

    static List<List<Integer>> subsets(int[] nums) {
        return solve(nums, nums.length);
    }

    static List<List<Integer>> solve(int[] nums, int n) {
        if (n == 0) {
            List<List<Integer>> baseRes = new ArrayList<>();
            baseRes.add(new ArrayList<>());
            return baseRes;
        }
        List<List<Integer>> small = solve(nums, n - 1);

        // First Choice - Not to pick last one
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : small) {
            res.add(list);
        }

        // Second Choice - Pick last one
        for (List<Integer> list : small) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(nums[n - 1]);
            res.add(tmp);
        }

        return res;
    }
}
