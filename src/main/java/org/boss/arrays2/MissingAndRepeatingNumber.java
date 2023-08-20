package org.boss.arrays2;

import java.util.Arrays;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] nums = {4,3,6,2,1,1};
        System.out.println(Arrays.toString(findTwoElement2(nums)));
    }

    // Brute force
    static int[] findTwoElement(int[] nums){
        int[] res = {-1,-1};
        for(int i = 1; i <= nums.length; i++){
            int cnt = 0;
            for (int num : nums) {
                if (num == i) {
                    cnt++;
                }
            }
            if(cnt == 2)
                res[0] = i;
            else if(cnt == 0)
                res[1] = i;
            if(res[0] != -1 && res[1] != -1)
                break;
        }
        return res;
    }
    // Hash Array to store count of each number
    // Create new array of size n + 1
    static int[] findTwoElement2(int[] nums){
        int[] res = {-1,-1};
        int[] hash = new int[nums.length + 1];
        for(int i : nums){
            hash[i]++;
        }
        for(int i = 1; i <= hash.length; i++){
            if(hash[i] == 2)
                res[0] = i;
            else if(hash[i] == 0)
                res[1] = i;
            if(res[0] != -1 && res[1] != -1)
                break;
        }
        return res;
    }
}
