package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 只出现一次的数字 III
 * @date 2020/4/4 10:20
 */
public class Leetcode260 {
    public int[] singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            ans ^= nums[i];
        }

        int mask = 1;
        while ((mask & ans) == 0) {
            mask <<= 1;
        }

        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
