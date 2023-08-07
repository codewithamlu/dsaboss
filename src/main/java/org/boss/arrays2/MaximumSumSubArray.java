package org.boss.arrays2;

import java.util.Arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(Arrays.toString(maxSubArray2(nums)));
    }

    static int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }

    static int[] maxSubArray2(int[] nums) {
        int curSum = 0, maxSum = Integer.MIN_VALUE;
        int si = 0, ei = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            if(curSum >= maxSum) {
                maxSum = curSum;
                ei = i;
            }
            if (curSum < 0) {
                curSum = 0;
                si = i + 1;
            }

        }
        return new int[]{si, ei};
    }
}
