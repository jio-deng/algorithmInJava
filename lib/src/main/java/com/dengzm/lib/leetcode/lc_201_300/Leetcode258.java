package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 各位相加
 * @date 2020/2/14 11:16
 */
public class Leetcode258 {
    public int addDigits(int num) {
        if (num > 9) {
            num = num % 9;
            if (num == 0) {
                num = 9;
            }
        }

        return num;
    }
}
