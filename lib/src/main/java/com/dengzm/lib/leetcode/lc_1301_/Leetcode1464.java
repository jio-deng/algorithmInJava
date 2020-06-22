package com.dengzm.lib.leetcode.lc_1301_;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组中两元素的最大乘积
 * @date 2020/6/18 16:10
 */
public class Leetcode1464 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1] - 1) * (nums[n-2] - 1);
    }
}
