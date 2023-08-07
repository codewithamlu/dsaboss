package org.boss.arrays2;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
        System.out.println(findLeaders2(nums));
    }

    // Brute-force Approach of checking for each element for its right part if i greater than anyone
    static List<Integer> findLeaders(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (valid(nums, i)) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    static boolean valid(int[] nums, int pos) {
        int val = nums[pos];
        for (int i = pos + 1; i < nums.length; i++) {
            if (nums[i] > val)
                return false;
        }
        return true;
    }

    // Optimal Approach - Start from right itself and keep track of max value and compare it current
    static List<Integer> findLeaders2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        list.add(nums[n - 1]);

        int max = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] > max){
                max = nums[i];
                list.add(nums[i]);
            }
        }
        return list;
    }
}
