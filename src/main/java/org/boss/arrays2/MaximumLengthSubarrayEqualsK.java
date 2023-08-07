package org.boss.arrays2;

import java.util.HashMap;

public class MaximumLengthSubarrayEqualsK {
    public static void main(String[] args) {
        int[] nums = {2,0,0,3};
        int k = 3;
        System.out.println(findLength(nums, k));
    }

    static int findLength(int[] nums, int k) {
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
