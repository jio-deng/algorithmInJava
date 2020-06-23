package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 剑指 Offer 42. 连续子数组的最大和
 * @date 2020/6/23 12:05
 */
public class Ms042 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return ans;
    }
}
