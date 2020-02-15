package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两整数之和
 * @date 2020/2/15 8:59
 */
public class Leetcode371 {
    /**
     * 两个整数a, b; a ^ b是无进位的相加； a&b得到每一位的进位；让无进位相加的结果与进位不断的异或， 直到进位为0；
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }

        return a;
    }
}
