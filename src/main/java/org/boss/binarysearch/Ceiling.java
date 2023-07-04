package org.boss.binarysearch;

public class Ceiling {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 8, 10, 10, 12, 19 };
        int target = 5;
        System.out.println(ceiling(nums, target));
    }

    static int ceiling(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
