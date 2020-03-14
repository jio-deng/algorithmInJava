package com.dengzm.lib.leetcode.lc_201_300;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长上升子序列
 * @date 2020/3/14 10:33
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = dp.length - 2; i >= 0; i --) {
            for (int j = i + 1; j < dp.length; j ++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int d : dp) {
            max = Math.max(max, d);
        }

        return max;
    }


//    private int max = 0;
//
//    public int lengthOfLIS(int[] nums) {
//        lengthOfLISCore(nums, -100000, 0, 0);
//        return max;
//    }
//
//    private void lengthOfLISCore(int[] nums, int pre, int curIndex, int curMax) {
//        if (curIndex >= nums.length) {
//            max = Math.max(curMax, max);
//            return;
//        }
//
//        if (nums[curIndex] > pre) {
//            lengthOfLISCore(nums, nums[curIndex], curIndex + 1, curMax + 1);
//        }
//
//        lengthOfLISCore(nums, pre, curIndex + 1, curMax);
//    }
}
