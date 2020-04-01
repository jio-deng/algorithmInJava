package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description LCP 1. 猜数字
 * @date 2020/4/1 14:03
 */
public class LCP1 {
    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for (int i = 0; i < guess.length; i ++) {
            if (guess[i] == answer[i]) {
                ans ++;
            }
        }

        return ans;
    }
}
