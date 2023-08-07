package org.boss.arrays2;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(find(nums));
    }
    static int find(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        int ans = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == ans)
                count += 1;
            else
                count -= 1;
            if(count == 0){
                ans = nums[i];
                count = 1;
            }
        }
        return ans;
    }
    static int find2(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        int maxNo = nums[0], maxCount = 0, curCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                curCount += 1;
                if (curCount > maxCount) {
                    maxCount = curCount;
                    maxNo = nums[i];
                }
            } else
                curCount = 1;
        }
        if (maxCount > nums.length / 2)
            return maxNo;
        return -1;
    }
}
