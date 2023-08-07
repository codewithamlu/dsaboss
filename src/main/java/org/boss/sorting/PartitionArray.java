package org.boss.sorting;

public class PartitionArray {
    public static void main(String[] args) {
        int[] arr = {9, 7, 1, 6, 4, 3, 2};
        int tar = 5;
        System.out.println(partition(arr, tar));
    }

    static int partition(int[] arr, int tar) {
        int i = 0, j = 0;
        while(i < arr.length){
            if(arr[i] < tar){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j++;
            }else
                i++;
        }
        return j - 1;
    }
}
