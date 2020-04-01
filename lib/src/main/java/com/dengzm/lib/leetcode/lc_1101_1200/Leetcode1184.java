package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 公交站间的距离
 * @date 2020/3/31 16:25
 */
public class Leetcode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int d : distance) {
            sum += d;
        }

        int ans = 0;
        int smaller = Math.min(start, destination);
        int bigger = Math.max(start, destination);
        for (int i = smaller; i < bigger; i ++) {
            ans += distance[i];
        }

        return Math.min(ans, sum - ans);
    }
}
