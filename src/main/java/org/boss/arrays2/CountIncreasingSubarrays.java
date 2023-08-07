package org.boss.arrays2;

public class CountIncreasingSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 3, 5};
        System.out.println(countIncreasing2(nums, nums.length));
    }

    static int countIncreasing(int nums[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1]) {
                    count += 1;
                } else
                    break;
            }
        }

        return count;
    }
    static int countIncreasing2(int nums[], int n) {
        int c = 0, len = 1;
        for(int i = 0; i < n - 1; i++){
            if(nums[i+1] > nums[i]){
                len++;
            }else{
                c += (len * (len - 1) / 2);
                len = 1;
            }
        }
        // When loop finishes , we need to find all possible answers which are valid
        if(len > 1){
            c += (len * (len - 1) / 2);
        }
        return c;
    }

}
