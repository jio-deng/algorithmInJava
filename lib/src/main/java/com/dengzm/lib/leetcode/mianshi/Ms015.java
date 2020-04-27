package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题15. 二进制中1的个数
 * @date 2020/4/27 12:16
 */
public class Ms015 {
    public int hammingWeight(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i ++) {
            if ((n & mask) != 0) {
                ans ++;
            }

            mask <<= 1;
        }

        return ans;
    }
}
