package org.boss.binarysearch;

public class FirstLastPosition {
    public static void main(String[] args) {

    }

    static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = searchTarget(nums, target, true);
        res[1] = searchTarget(nums, target, false);
        return res;
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
