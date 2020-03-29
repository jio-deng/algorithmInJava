package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 乘积最大子数组
 * @date 2020/3/29 11:45
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];

        int a = 1;
        for (int num : nums) {
            a *= num;
            max = Math.max(max, a);
            if (a == 0) {
                a = 1;
            }
        }

        a = 1;
        for (int i = nums.length - 1; i >= 0; i --) {
            a *= nums[i];
            max = Math.max(max, a);
            if (a == 0) {
                a = 1;
            }
        }

        return max;
    }
}
