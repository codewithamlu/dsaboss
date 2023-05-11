package org.boss.arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 11, 22, 33, 55, 66, 77, 88, 99 };
        int tar = 88;
        System.out.println(linearSearch(arr, tar));
    }

    static int linearSearch(int[] arr, int tar) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tar) {
                return i;
            }
        }
        return -1;
    }
}
