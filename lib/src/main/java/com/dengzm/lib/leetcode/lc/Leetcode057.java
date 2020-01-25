package com.dengzm.lib.leetcode.lc;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 插入区间
 * @date 2020/1/25 10:11
 */
public class Leetcode057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            intervals = new int[1][2];
            intervals[0] = newInterval;
            return intervals;
        }

        int[][] result = new int[intervals.length + 1][2];
        boolean hasAdded = false;
        int plus = 0;

        for (int i = 0; i < intervals.length; i ++) {
            int[] temp = intervals[i];

            if (!hasAdded) {
                if (newInterval[1] < temp[0]) {
                    if (plus == 0) {
                        result[i] = newInterval;
                    } else {
                        result[i + plus] = newInterval;
                    }
                    plus ++;
                    hasAdded = true;
                } else { // (newInterval[1] >= temp[0])
                    if (newInterval[0] <= temp[1]) {
                        temp[0] = Math.min(newInterval[0], temp[0]);
                        temp[1] = Math.max(newInterval[1], temp[1]);
                        newInterval = temp;
                        plus --;
                    }
                }

            }

            if (plus >= 0 || hasAdded) {
                result[i + plus] = temp;
            }
        }

        if (!hasAdded) {
            result[intervals.length + plus] = newInterval;
            plus ++;
        }

        return Arrays.copyOf(result, intervals.length + plus + 1);
    }
}
