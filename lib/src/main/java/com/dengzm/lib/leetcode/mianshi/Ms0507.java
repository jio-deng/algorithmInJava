package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 05.07. 配对交换
 * @date 2020/4/22 21:07
 */
public class Ms0507 {
    public int exchangeBits(int num) {
        int ans = 0;
        boolean flag = num >= 0;
        if (num < 0) {
            num = -num;
        }

        int mask = 0;
        while (num > 0) {
            int val1 = num & 1;
            num >>= 1;
            int val2 = num & 1;
            num >>= 1;
            ans += (val2 << mask) + (val1 << (mask + 1));
            mask += 2;
        }

        return flag ? ans : -ans;
    }
}
