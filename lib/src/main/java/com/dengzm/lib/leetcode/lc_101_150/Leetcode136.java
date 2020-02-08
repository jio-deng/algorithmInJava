package com.dengzm.lib.leetcode.lc_101_150;

/**
 * @Description 只出现一次的数字
 * Created by deng on 2020/2/8.
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i = i ^ num;
        }

        return i;
    }
}
