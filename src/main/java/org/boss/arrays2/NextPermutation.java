package org.boss.arrays2;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,1,5};
        find(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void find(int[] nums) {
        int idx = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i >= idx; i--) {
            if (nums[i] > nums[idx]) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                break;
            }
        }
        reverse(nums, idx + 1, nums.length - 1);
    }

    static void reverse(int[] nums, int si, int ei) {
        while(si < ei){
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }
}
