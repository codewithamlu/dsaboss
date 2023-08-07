package org.boss.arrays2;

import java.util.Arrays;

public class MaxConsecOnesInBinaryCircular {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes2(nums));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int[] arr = new int[2 * nums.length];
        int c = 0;

        for (int i = 0; i < 2; i++) {
            int j = 0;
            while (j < nums.length) {
                arr[c] = nums[j];
                j++;
                c++;
            }
        }

        return find(arr);

    }

    static int find(int[] nums) {
        int res = 0, curCount = 0;
        for (int num : nums) {
            if (num == 1) {
                curCount += 1;
                if (curCount > res)
                    res = curCount;
            } else {
                curCount = 0;
            }
        }

        return res;
    }

    static int findMaxConsecutiveOnes2(int[] nums) {
        int n = nums.length;
        int res = 0, count = 0;
        for (int i = 0; i < 2 * n; i++) {

            int idx = i % n;
            if (nums[idx] == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        // This means array contains all 1's
        if (count == 2 * n) {
            return n;
        }
        // Otherwise return
        return res;
    }

}
