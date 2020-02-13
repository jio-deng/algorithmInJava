package com.dengzm.lib.leetcode.lc_151_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 位1的个数
 * @date 2020/2/13 12:24
 */
public class Leetcode191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        int mask = 1;

        for (int i = 0; i < 32; i ++) {
            if ((n & mask) != 0) {
                result ++;
            }
            mask <<= 1;
        }

        return result;
    }
}
