package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 水壶问题
 * @date 2020/3/21 10:57
 */
public class Leetcode365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }

        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }

        if (x < y) {
            x = x + y - (y = x);
        }

        while (y % x != 0) {
            int tmp = y % x;
            y = x;
            x = tmp;
        }

        return z % x == 0;
    }
}
