package org.boss.arrays2;

import java.util.Arrays;

public class MoveNegatives {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        moveNegatives(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveNegatives(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp > 0) {
                int j = i - 1;
                while (j >= 0 && nums[j] < 0) {
                    nums[j + 1] = nums[j];
                    j--;

                }
                nums[j + 1] = tmp;
            }
        }
    }

    static void moveNegatives2(int[] nums) {
        int n = nums.length;

        int[] tmp = new int[nums.length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                tmp[k] = nums[i];
                k++;
            }
        }
        if (k == n || k == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                tmp[k] = nums[i];
                k++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }

    // Partiton based on 0 but order do change
    static void moveNegatives3(int[] nums) {
        int i = -1;
        int pivot = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > pivot) {
                i++;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
    }


}
