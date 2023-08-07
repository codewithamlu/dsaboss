package org.boss.arrays2;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(findLength4(nums));
    }

    // Brute-force approach
    static int findLength(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int count = 1;
            while (search(nums, x + 1)) {
                x = x + 1;
                count += 1;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }

    static boolean search(int[] nums, int tar) {
        for (int num : nums) {
            if (num == tar)
                return true;
        }
        return false;
    }

    // Better Approach - Sort the array
    static int findLength2(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        Arrays.sort(nums);
        int maxLen = 0, count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                continue;
            if (nums[i + 1] - nums[i] == 1) {
                count += 1;
                maxLen = Math.max(maxLen, count);
            } else {
                count = 1;
            }
        }
        maxLen = Math.max(maxLen, count);
        return maxLen;
    }

    // Better Approach - Sort the array with another approach using recent smaller elemen
    static int findLength3(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        Arrays.sort(nums);
        int maxLen = 1, count = 1, lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i] - 1 == lastSmaller){
               count += 1;
               lastSmaller = nums[i];
           }else if(nums[i] != lastSmaller){
               count = 1;
               lastSmaller = nums[i];
           }
           maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }
    // Optimal Approach Using Hashing - Hashset
    static int findLength4(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxLen = 0;
        HashSet<Integer> s = new HashSet<>();
        for(int num:nums)
            s.add(num);

        for(int i:s){
            if(!s.contains(i -1)){
                int count = 1;
                int j = i;
                while(s.contains(j + 1)){
                    count += 1;
                    j++;
                }
                maxLen = Math.max(maxLen, count);
            }

        }
        return maxLen;
    }
}
