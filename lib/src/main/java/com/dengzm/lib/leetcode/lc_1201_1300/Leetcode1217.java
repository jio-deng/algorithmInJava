package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 玩筹码
 * @date 2020/3/31 16:52
 */
public class Leetcode1217 {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        for (int chip : chips) {
            if (chip % 2 == 1) {
                odd ++;
            }
        }

        return Math.min(odd, chips.length - odd);
    }
}
