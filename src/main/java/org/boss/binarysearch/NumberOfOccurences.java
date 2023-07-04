package org.boss.binarysearch;

public class NumberOfOccurences {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println(count(nums, nums.length, target));
    }

    static int count(int[] arr, int n, int x) {
        int first = searchTarget(arr, x, true);
        int last = searchTarget(arr, x, false);
        if (first != -1)
            return last - first + 1;
        return 0;
    }

    static int searchTarget(int[] nums, int target, boolean isStartIdx) {
        int ans = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                ans = mid;
                if (isStartIdx) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
