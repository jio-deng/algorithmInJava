package com.dengzm.lib.leetcode.lc_501_600;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组拆分 I
 * @date 2020/2/22 21:19
 */
public class Leetcode561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }

        return ans;
    }
}
