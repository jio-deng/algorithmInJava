package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题65. 不用加减乘除做加法
 * @date 2020/6/11 10:45
 */
public class Ms065 {
    public int add(int a, int b) {
        int m, n;
        while (b != 0) {
            m = a ^ b;
            n = (a & b) << 1;
            a = m;
            b = n;
        }

        return a;
    }
}
