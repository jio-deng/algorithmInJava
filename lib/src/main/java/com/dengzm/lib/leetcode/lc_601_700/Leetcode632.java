package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 平方数之和
 * @date 2020/2/27 9:14
 */
public class Leetcode632 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);

        while (i <= j) {
            int total = i * i + j * j;
            if (total == c) {
                return true;
            } else if (total > c) {
                j --;
            } else {
                i ++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Leetcode632 leetcode632 = new Leetcode632();
        leetcode632.judgeSquareSum(3);
    }
}
