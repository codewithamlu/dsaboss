package org.boss.arrays2;

import java.util.HashMap;

public class MaximumLengthSubarraySum0 {
    public static void main(String[] args) {

    }
    static int findLength(int[] nums){
        int k = 0;
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
