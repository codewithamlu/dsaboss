package org.boss.arrays2;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 3, 12};
        moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveZeroes(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
    }

    static void moveZeroes2(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // Check for non-zero number and place it at its correct position
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        // Put 0 in remaining places at last
        for(int k = i; k < nums.length; k++){
            nums[k] = 0;
        }
    }
}
