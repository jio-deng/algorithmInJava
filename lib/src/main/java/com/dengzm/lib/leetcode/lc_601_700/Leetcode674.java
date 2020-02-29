package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最长连续递增序列
 * @date 2020/2/29 11:43
 */
public class Leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0, cur = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                cur ++;
                continue;
            }

            if (nums[i] > nums[i-1]) {
                cur ++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }
        }

        max = Math.max(max, cur);
        return max;
    }
}
