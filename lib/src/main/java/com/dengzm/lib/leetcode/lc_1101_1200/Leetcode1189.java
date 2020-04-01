package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description “气球” 的最大数量
 * @date 2020/3/31 16:38
 */
public class Leetcode1189 {
    public int maxNumberOfBalloons(String text) {
        // balloon : b*1 a*1 l*2 o*2 n*1
        int[] counts = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'b') {
                counts[0] ++;
            } else if (c == 'a') {
                counts[1] ++;
            } else if (c == 'n') {
                counts[2] ++;
            } else if (c == 'o') {
                counts[3] ++;
            } else if (c == 'l') {
                counts[4] ++;
            }
        }

        int res = text.length();
        for (int i = 0; i < 5; i ++) {
            if (counts[i] == 0) {
                return 0;
            }
            int dev = i <= 2 ? 1 : 2;
            res = Math.min(res, counts[i] / dev);
        }

        return res;
    }
}
