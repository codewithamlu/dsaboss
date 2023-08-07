package org.boss.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReArrangeArrayBySign2 {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4,-1,-1, 12};
        reArrange(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Brute-Force approach
    static void reArrange(int[] nums) {
        int n = nums.length;
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for (int num : nums) {
            if (num >= 0)
                positives.add(num);
            else
                negatives.add(num);
        }

        if(positives.size() > negatives.size()){
            for(int i = 0; i < negatives.size();i++){
                nums[i * 2] = positives.get(i);
                nums[i * 2 + 1] = negatives.get(i);
            }
            int idx = negatives.size() * 2;
            for(int i = negatives.size(); i < positives.size();i++){
                nums[idx] = positives.get(i);
                idx ++;
            }
        }else{
            for(int i = 0; i < positives.size();i++){
                nums[i * 2] = positives.get(i);
                nums[i * 2 + 1] = negatives.get(i);
            }
            int idx = positives.size() * 2;
            for(int i = positives.size(); i < negatives.size();i++){
                nums[idx] = negatives.get(i);
                idx ++;
            }
        }

    }

}
