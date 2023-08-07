package org.boss.arrays2;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missinNumber3(nums));
    }
    static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        int cSum = 0;
        for (int num : nums) {
            cSum += num;
        }

        return sum - cSum;
    }

    static int missingNumber2(int[] nums) {
        int n = nums.length;
        // Sort the array
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i != nums[i])
                ans = i;
        }
        return ans;
    }

    static int missinNumber3(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]);
            if(idx == 1_00_000)
                    idx = 0;

            if(idx < n){
                if(nums[idx] == 0)
                    nums[idx] = -1 * 1_00_000;
                else
                    nums[idx] = -1 * nums[idx];
            }
        }

        for(int i = 0; i < n;i++){
            if(nums[i] >= 0){
                return i;
            }
        }
        return n;
    }
}
