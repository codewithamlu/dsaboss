package org.boss.arrays2;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 2, 0, 0, 1, 0, 2, 0, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            int n = nums[j];
            if (n == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            } else if (n == 2) {
                int tmp = nums[k];
                nums[k] = nums[j];
                nums[j] = tmp;
                k--;
            } else {
                j++;
            }
        }
    }
}
