package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数字范围按位与
 * @date 2020/6/4 10:03
 */
public class Leetcode201 {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i ++;
        }

        return m << i;
    }
}
