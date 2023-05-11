package org.boss.arrays;

public class BarChart {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 6 };
        makeBuilding(nums);
    }

    /*
     * Make Horizontal Building
     * 
     * Time Complexity : O(n*n)
     * Space Complexity : O(1)
     */
    static void makeBuilding(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
