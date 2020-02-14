package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 丑数
 * @date 2020/2/14 11:22
 */
public class Leetcode263 {
    public boolean isUgly(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
