package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 寻找数组的中心索引
 * @date 2020/5/1 14:00
 */
public class Leetcode724 {
    public int pivotIndex(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        for (int i = 1; i < nums.length; i ++) {
            dp1[i] = dp1[i-1] + nums[i-1];
        }

        for (int i = nums.length - 2; i >= 0; i --) {
            dp2[i] = dp2[i+1] + nums[i+1];
        }

        for (int i = 0; i < nums.length; i ++) {
            if (dp1[i] == dp2[i]) {
                return i;
            }
        }

        return -1;
    }
}
