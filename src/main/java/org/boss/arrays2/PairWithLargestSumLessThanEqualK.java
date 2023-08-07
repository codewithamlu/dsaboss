package org.boss.arrays2;

import java.util.ArrayList;
import java.util.Arrays;

public class PairWithLargestSumLessThanEqualK {
    public static void main(String[] args) {
        int[] nums = {1, 9, 10, 13, 6, 10, 8, 10};
        int k = 15;
//        int[] ans = find2(nums, k);
//        System.out.println("( " + ans[0] + ", " + ans[1] + " )");
        System.out.println(find3(nums, nums.length, k));
    }

    static int[] find(int[] nums, int k) {
        int[] ans = new int[2];

        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= maxSum && sum < k) {
                    maxSum = sum;
                    ans[0] = nums[i];
                    ans[1] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    static int[] find2(int[] nums, int k) {
        int[] ans = new int[2];
        Arrays.sort(nums);

        int si = 0, ei = nums.length - 1;
        int maxSum = 0;

        while (si < ei) {
            int sum = nums[si] + nums[ei];
            if (sum >= maxSum && sum < k) {
                maxSum = sum;
                ans[0] = nums[si];
                ans[1] = nums[ei];
                si++;
            } else {
                ei--;
            }
        }

        return ans;
    }

    static ArrayList<Integer> find3(int[] nums, int n, int k) {

        // Instead of a pair, return an array of two integers.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();


        Arrays.sort(nums);

        int si = 0, ei = nums.length - 1;
        int maxSum = 0, maxDiff = 0;

        while (si < ei) {
            int sum = nums[si] + nums[ei];
            if (sum >= maxSum && sum < k) {

                ArrayList<Integer> ans = new ArrayList<>();
                maxSum = sum;
                ans.add(nums[si]);
                ans.add(nums[ei]);
                list.add(ans);
                si++;


            } else {
                ei--;
            }
        }
        if (maxSum == 0) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(0);
            res.add(ans);

            return getPairWithMaxDiff(res);
        }
        return getPairWithMaxDiff(list);
    }

    static ArrayList<Integer> getPairWithMaxDiff(ArrayList<ArrayList<Integer>> list){
        int maxDiff = 0;
        ArrayList<Integer> ans = list.get(0);
        for(ArrayList<Integer> l:list){
            int diff = l.get(1) - l.get(0);
            if(diff > maxDiff){
                maxDiff = diff;
                ans = l;
            }
        }
        return  ans;
    }
}
