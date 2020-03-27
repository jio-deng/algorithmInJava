package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 卡牌分组
 * @date 2020/3/14 11:23
 */
public class Leetcode914 {
    public boolean hasGroupsSizeX(int[] deck) {
        // 统计数字个数
        int[] count = new int[10000];
        for (int c: deck) {
            count[c] ++;
        }

        // 最大公约数
        int g = -1;
        for (int value : count) {
            if (value > 0) {
                if (g == -1) {
                    g = value;
                } else {
                    g = gcd(g, value);
                }
            }
        }

        return g >= 2;
    }

    /**
     * 求最大公约数：辗转相除法
     */
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }

    private int gcd2(int x, int y) {
        while (x != 0) {
            int tmp = y % x;
            y = x;
            x = tmp;
        }

        return y;
    }
}
