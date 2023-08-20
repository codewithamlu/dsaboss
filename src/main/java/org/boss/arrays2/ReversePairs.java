package org.boss.arrays2;

import java.util.Arrays;
import java.util.Collections;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs2(nums));
    }

    // Brute-force approach
    // Get every such pair by two loops and check if condition satisfies
    static int reversePairs(int[] nums) {
        Arrays.sort(nums);
        reverseArr(nums);
        System.out.println(Arrays.toString(nums));
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] > 2 * nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void reverseArr(int[] arr) {
        int idx = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, idx);
            idx--;
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int reversePairs2(int[] nums) {
       return mergeSort(nums, 0 , nums.length - 1);
    }
    static int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;
        int mid = (low + high) / 2;
        count += mergeSort(nums, 0, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low,mid,high);
        merge(nums, low, mid, high);
        return count;
    }
    static void merge(int[] nums, int low, int mid, int high) {
        int[] arr = new int[nums.length];
        int left = low, right = mid + 1, k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                arr[k] = nums[left];
                left++;
                k++;
            } else {
                arr[k] = nums[right];

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

        // Store tmp array into original
        for (int i = low; i <= high; i++) {
            nums[i] = arr[i - low];
        }
    }

    static int countPairs(int[] a, int low, int mid, int high) {
        int cnt = 0;
        int ri = mid + 1;
        for (int li = low; li <= mid; li++) {
            while (ri <= high && a[li] > 2 * a[ri]) {
                ri++;
            }
            cnt += ri - (mid + 1);;
        }
        return cnt;
    }
}
