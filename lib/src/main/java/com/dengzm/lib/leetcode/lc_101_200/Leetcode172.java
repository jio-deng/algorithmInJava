package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 阶乘后的零
 * @date 2020/2/13 10:20
 */
public class Leetcode172 {
    public int trailingZeroes(int n) {
        int result = 0;

        while (n >= 0) {
            n /= 5;
            result += n;
        }

        return result;
    }
}
