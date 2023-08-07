package org.boss.arrays2;

import java.util.Arrays;

public class ReArrangeArrayBySign {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        reArrange2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Brute-Force approach
    static void reArrange(int[] nums) {
        int n = nums.length;
        int[] positives = new int[n / 2];
        int[] negatives = new int[n / 2];

        int pi = 0, ni = 0;

        for (int num : nums) {
            if (num >= 0)
                positives[pi++] = num;
            else
                negatives[ni++] = num;
        }

        for (int i = 0; i < n / 2; i++) {
            nums[i * 2] = positives[i];
            nums[i * 2 + 1] = negatives[i];
        }
    }

    // Optimal Approach
    static void reArrange2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pi = 0, ni = 0;

        for (int num : nums) {
            if (num >= 0) {
                ans[pi * 2] = num;
                pi += 1;
            } else {
                ans[ni * 2 + 1] = num;
                ni += 1;
            }

        }

        for(int i = 0; i < n; i++){
            nums[i] = ans[i];
        }

    }
}
