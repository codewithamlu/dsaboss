package org.boss.binarysearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }

    static int search(int[] nums, int tar) {
        int minIdx = findMin(nums);
        int ans = -1;
        ans = binarySearch(nums, tar, 0, minIdx - 1);
        if (ans == -1) {
            ans = binarySearch(nums, tar, minIdx, nums.length - 1);
        }
        return ans;
    }

    static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
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
        return -1;
    }
}
