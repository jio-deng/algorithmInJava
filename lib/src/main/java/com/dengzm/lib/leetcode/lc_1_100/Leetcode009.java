package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 回文数
 * @date 2019/12/14 9:20
 */
public class Leetcode009 {
    public boolean isPalindrome1(int x) {
        // 负数和末位为0的数，不是回文数
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        // 单个数字
        if (x < 10) {
            return true;
        }

        int cur = 0;

        while (x > cur) {
            cur = cur * 10 + x % 10;
            x = x / 10;
        }

        // 位数为双数 || 位数为单数
        return x == cur || x == cur / 10;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int cur = 0, temp = x;

        while (temp > 0) {
            cur = cur * 10 + temp % 10;
            temp = temp / 10;
        }

        return x == cur;
    }
}
