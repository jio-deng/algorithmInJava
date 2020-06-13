package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 提莫攻击
 * @date 2020/6/13 12:57
 */
public class Leetcode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < timeSeries.length; i ++) {
            ans += Math.min(duration, timeSeries[i] - timeSeries[i-1]);
        }

        ans += duration;

        return ans;
    }
}
