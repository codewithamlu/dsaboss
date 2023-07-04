package org.boss.binarysearch;

public class Floor {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 8, 10, 10, 12, 19 };
        int target = 5;
        System.out.println(floor(nums, target));
    }

    static int floor(int[] nums, int target) {
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
        return end;
    }
}
