package org.boss.arrays2;

import java.util.HashMap;

public class SubarraysSumEqualsK {
    public static void main(String[] args) {
        int[] nums = {3, -3, 1, 1, 1};
        int k = 3;
        System.out.println(countSubarrays(nums, k));
    }

    static int countSubarrays(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum - k;
            count += map.getOrDefault(rem, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

}
