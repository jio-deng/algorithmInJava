package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 到最近的人的最大距离
 * @date 2020/3/11 10:23
 */
public class Leetcode849 {
    public int maxDistToClosest(int[] seats) {
        int pre = -1, max = 0;
        for (int i = 0; i < seats.length; i ++) {
            if (seats[i] == 1) {
                max = Math.max(max, pre == -1 ? i : (i - pre) / 2);
                pre = i;
            } else if (i == seats.length - 1) {
                max = Math.max(max, i - pre);
            }
        }

        return max;
    }
}
