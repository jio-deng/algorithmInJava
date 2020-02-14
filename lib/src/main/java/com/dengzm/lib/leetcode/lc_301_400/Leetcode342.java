package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 4的幂
 * @date 2020/2/14 18:36
 */
public class Leetcode342 {
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }

        if ((num & (num - 1)) == 0) {
            String binary = Integer.toBinaryString(num);
            return binary.length() % 2 != 0;
        }

        return false;
    }
}
