package org.boss.arrays2;

public class CountInversions {
    public static void main(String[] args) {
        int[] nums = {5, 3, 2, 4, 1};
        System.out.println(countPairs2(nums));
    }

    // Brute-force approach
    static int countPairs(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    pairs++;
                }
            }
        }
        return pairs;
    }


    static int countPairs2(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;
        int mid = (low + high) / 2;
        count += mergeSort(nums, 0, mid);
        count += mergeSort(nums, mid + 1, high);
        count +=  merge(nums, low, mid, high);
        return count;
    }

    static int merge(int[] nums, int low, int mid, int high) {
        int[] arr = new int[nums.length];
        int left = low, right = mid + 1, k = 0;
        int pairs = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                arr[k] = nums[left];
                left++;
                k++;
            } else {
                arr[k] = nums[right];
                pairs += (mid - left + 1);
                right++;
                k++;
            }
        }
        while (left <= mid) {
            arr[k] = nums[left];
            left++;
            k++;
        }
        while (right <= high) {
            arr[k] = nums[right];
            right++;
            k++;
        }
        for(int i = low; i <= high; i++){
            nums[i] = arr[i - low];
        }
        return pairs;
    }
}
