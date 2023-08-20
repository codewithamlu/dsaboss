package org.boss.arrays2;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(maxProduct2(nums));
    }

    static int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                maxProd = Math.max(prod, maxProd);
            }
        }
        return maxProd;
    }

    static int maxProduct2(int[] nums) {
        int res = Integer.MIN_VALUE;
        int pre = 1, suff = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;
            pre *= nums[i];
            suff *= nums[n - i - 1];
            res = Math.max(res, Math.max(pre, suff));
        }
        return res;
    }
}
