package org.boss.arrays2;

import java.util.Arrays;

public class ReArrangeArrayFromAiToAAi {
    public static void main(String[] args) {
        int[] nums = {4, 0, 2, 1, 3};
        reArrange(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void reArrange(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = nums[i]; // 4
            int ival = nums[val]; // 3
            nums[i] = val + (ival % n ) * n; // 4 + (3 % 5) * 5 = 19
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }
    }
}
