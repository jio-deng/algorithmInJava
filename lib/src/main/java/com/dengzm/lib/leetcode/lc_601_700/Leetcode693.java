package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 交替位二进制数
 * @date 2020/2/29 12:11
 */
public class Leetcode693 {
    public boolean hasAlternatingBits(int n) {
        int cur = n & 1;
        n >>= 1;
        while (n > 0) {
            int tmp = n & 1;
            if ((tmp ^ cur) == 0) {
                return false;
            }

            cur = tmp;
            n >>= 1;
        }

        return true;
    }
}
