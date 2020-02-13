package com.dengzm.lib.leetcode.lc_151_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 颠倒二进制位
 * @date 2020/2/13 11:22
 */
public class Leetcode190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i ++) {
            //System.out.println((n & 1) + "    " + result);
            result = (result << 1) + (n & 1);
            n >>= 1;
        }

        return result;
    }
}
