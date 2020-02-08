package com.dengzm.lib.leetcode.lc_101_150;

/**
 * @Description 只出现一次的数字 II
 * Created by deng on 2020/2/8.
 */
public class Leetcode137 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;

        for (int num : nums) {
            two |= one & num;
            one ^= num;
            three = one & two;
            one &= ~three;
            two &= three;
        }

        return one;
    }
}
