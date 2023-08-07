package org.boss.arrays2;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes2(nums));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, curCount = 0;
        for (int num : nums) {
            if (num == 1)
                curCount += 1;
            else {
                res = Math.max(res, curCount);
                curCount = 0;
            }
        }

        return Math.max(res, curCount);
    }

    static int findMaxConsecutiveOnes2(int[] nums) {
        int res = 0, curCount = 0;
        for (int num : nums) {
            if (num == 1) {
                curCount += 1;
                if (curCount > res)
                    res = curCount;
            } else {
                curCount = 0;
            }
        }

        return res;
    }
}
