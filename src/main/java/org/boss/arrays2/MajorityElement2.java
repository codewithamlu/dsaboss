package org.boss.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(find(nums));
    }

    static List<Integer> find(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Find the actual frequency of those numbers
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
        }

        if (count1 > nums.length / 3)
            ans.add(num1);
        if (count2 > nums.length / 3)
            ans.add(num2);
        return ans;
    }

    static List<Integer> find2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }

        Arrays.sort(nums);

        int threshold = nums.length / 3;
        int prevNo = nums[0], curCount = 1;
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                curCount += 1;
                prevNo = nums[i];
            } else {
                if (curCount > threshold && !ans.contains(nums[i])) {
                    ans.add(prevNo);
                }
                curCount = 1;
            }

        }
        prevNo = nums[nums.length - 1];
        if (curCount > threshold && !ans.contains(prevNo)) {
            ans.add(prevNo);
        }
        return ans;
    }
}
