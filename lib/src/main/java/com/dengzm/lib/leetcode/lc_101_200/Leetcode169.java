package com.dengzm.lib.leetcode.lc_101_200;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 多数元素
 * @date 2020/2/13 10:09
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i ++) {
            if (count > 0) {
                if (result == nums[i]) {
                    count ++;
                } else {
                    count--;
                }
            } else {
                result = nums[i];
                count ++;
            }
        }

        return result;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
