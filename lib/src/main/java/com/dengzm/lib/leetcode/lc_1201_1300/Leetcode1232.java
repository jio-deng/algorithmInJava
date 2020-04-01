package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 缀点成线
 * @date 2020/3/21 11:06
 */
public class Leetcode1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }

        double k = ((double) coordinates[0][1] - coordinates[1][1]) / (coordinates[0][0] - coordinates[1][0]);
        double b = (double) coordinates[0][1] - k * coordinates[0][0];

        for (int i = 1; i < coordinates.length; i ++) {
            if (coordinates[i][1] != k * coordinates[i][0] + b) {
                return false;
            }
        }

        return true;
    }
}
