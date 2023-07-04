package org.boss.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(binarySearch(arr, 0, arr.length - 1, 10));
    }

    static boolean binarySearch(int[] arr, int start, int end, int target) {
        // Base case - element not found
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        // Element found
        if (arr[mid] == target)
            return true;
        if (target < arr[mid]) {
            return binarySearch(arr, start, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, end, target);
        }
    }

    static int binarySearch2(int[] arr, int start, int end, int target) {
        // Base case - element not found
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        // Element found
        if (arr[mid] == target)
            return mid;
        if (target < arr[mid]) {
            return binarySearch2(arr, start, mid - 1, target);
        } else {
            return binarySearch2(arr, mid + 1, end, target);
        }
    }
}
