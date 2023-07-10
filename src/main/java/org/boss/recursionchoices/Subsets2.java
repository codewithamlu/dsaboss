package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2, 2, 1 };
        List<List<Integer>> ans = subsets2(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solve2(nums, 0, new ArrayList<>(), res);
        return res;
    }

    static void solve2(int[] nums, int i, List<Integer> tmp, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[i]);
        solve2(nums, i + 1, tmp, res);
        tmp.remove(tmp.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1])
            i++;
        solve2(nums, i + 1, tmp, res);
    }
}
