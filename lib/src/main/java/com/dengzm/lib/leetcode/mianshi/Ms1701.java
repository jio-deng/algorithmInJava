package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 17.01. 不用加号的加法
 * @date 2020/4/27 12:19
 */
public class Ms1701 {
    public int add(int a, int b) {
        int sum, carry;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}
