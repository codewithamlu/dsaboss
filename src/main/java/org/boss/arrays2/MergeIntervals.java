package org.boss.arrays2;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {9, 9}, {15, 18}};
        for(int[] i:mergeIntervals2(arr)){
            System.out.println(Arrays.toString(i));
        }
    }

    static int[][] mergeIntervals(int[][] arr) {
        List<int[]> res = new ArrayList<>();
        if(arr.length == 0 || arr == null){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(arr, (a,b)-> a[0] - b[0]);

        int start = arr[0][0], end = arr[0][1];
        for(int[] i:arr){
            if(i[0] <= end){
                end = Math.max(i[1],end);
            }else{
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
    static int[][] mergeIntervals2(int[][] arr) {
        List<int[]> res = new ArrayList<>();
        if(arr.length == 0){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(arr, (a,b)-> a[0] - b[0]);

        for(int[] i:arr){
            if(res.size() == 0 || res.get(res.size() - 1)[1] < i[0]){
                res.add(i);
            }else{
                res.get(res.size() - 1)[1] = Math.max(i[1], res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[0][]);
    }
}
