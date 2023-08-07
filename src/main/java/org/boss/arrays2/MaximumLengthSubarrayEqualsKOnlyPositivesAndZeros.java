package org.boss.arrays2;

import java.util.HashMap;

public class MaximumLengthSubarrayEqualsKOnlyPositivesAndZeros {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,3,2};
        int k = 3;
        System.out.println(findLength(nums, k));
    }

    static int findLength(int[] nums, int k) {
        int ans = 0;
        int i = 0, j = 0, sum = 0;
        while (j < nums.length && i < nums.length) {
            sum += nums[j];
            if (sum == k) {
                ans = Math.max(ans, j - i + 1);

                j++;
            } else if (sum < k)
                j++;
            else {
                sum -= nums[i];
                j++;
                i++;
            }
        }
        return ans;
    }


    static int findLength2(int[] nums, int k) {
        int count = 0, preSum = 0;
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSum == k) {
                count = Math.max(count, i + 1);
            }

            int diff = preSum - k;
            if (preSumMap.containsKey(diff)) {
                int len = i - preSumMap.get(diff);
                count = Math.max(count, len);
            }
            if(!preSumMap.containsKey(preSum)){
                preSumMap.put(preSum, i);
            }

        }
        return count;
    }
}
