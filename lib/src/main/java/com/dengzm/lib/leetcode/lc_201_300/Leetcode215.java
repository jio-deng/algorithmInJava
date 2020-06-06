package com.dengzm.lib.leetcode.lc_201_300;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组中的第K个最大元素
 * @date 2020/6/4 10:14
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
