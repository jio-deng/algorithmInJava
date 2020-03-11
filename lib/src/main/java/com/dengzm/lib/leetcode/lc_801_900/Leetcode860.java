package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 柠檬水找零
 * @date 2020/3/11 10:56
 */
public class Leetcode860 {
    public boolean lemonadeChange(int[] bills) {
        int numOf5 = 0, numOf10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                numOf5 ++;
            } else if (bill == 10) {
                numOf5 --;
                numOf10 ++;
                if (numOf5 < 0) {
                    return false;
                }
            } else if (bill == 20) {
                if (numOf10 > 0) {
                    numOf10 --;
                    numOf5 --;
                } else {
                    numOf5 -= 3;
                }

                if (numOf5 < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
