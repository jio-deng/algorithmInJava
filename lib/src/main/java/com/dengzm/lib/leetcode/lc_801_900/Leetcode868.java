package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二进制间距
 * @date 2020/3/11 11:29
 */
public class Leetcode868 {
    public int binaryGap(int N) {
        int max = 0;
        int pre = 2333;
        int cur = 0;

        while (N > 0) {
            if ((N & 1) == 1) {
                max = Math.max(max, cur - pre);
                pre = cur;
            }

            cur ++;
            N >>= 1;
        }

        return max;
    }
}
