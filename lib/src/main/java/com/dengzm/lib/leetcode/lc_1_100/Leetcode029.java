package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两数相除
 * @date 2020/1/13 11:09
 */
public class Leetcode029 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long temp1 = Math.abs((long)dividend);
        long temp2 = Math.abs((long)divisor);

        if (temp1 < temp2) {
            return 0;
        }

        int flag = (dividend ^ divisor) < 0 ? -1 : 1;

        long i = 1;
        long d = temp2;

        if (d == 1) {
            i = temp1;
        } else {
            while (temp1 > d) {
                d <<= 1;
                i <<= 1;

                if (temp1 < d) {
                    i = (i >> 1) + divide((int)(temp1 - (d >> 1)), (int)temp2);
                }
            }
        }

        return flag < 0 ? (int)-i : (int)i;
    }
}
