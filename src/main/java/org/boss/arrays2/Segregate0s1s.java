package org.boss.arrays2;

import java.util.Arrays;

public class Segregate0s1s {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1, 1, 1, 0, 1};
        segregate0and12(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void segregate0and1(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
                j++;
            } else
                j++;
        }
    }

    static void segregate0and12(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] != 1) {
                if (nums[j] == 1) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                } else
                    j--;
            } else
                i++;
        }
    }
}
