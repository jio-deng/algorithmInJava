package com.dengzm.lib.leetcode.lc_601_700;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 三个数的最大乘积
 * @date 2020/2/27 9:11
 */
public class Leetcode628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * Math.max(nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1]);
    }
}
