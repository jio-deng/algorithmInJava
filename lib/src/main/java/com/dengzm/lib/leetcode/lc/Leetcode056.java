package com.dengzm.lib.leetcode.lc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 合并区间
 * @date 2020/1/25 10:10
 */
public class Leetcode056 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int[][] result = new int[intervals.length][2];
        int curIndex = 0;
        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i ++) {
            int[] temp = intervals[i];

            if (temp[0] > cur[1]) {
                result[curIndex] = cur;
                curIndex ++;
                cur = temp;
            } else {
                cur[1] = Math.max(cur[1], temp[1]);
            }
        }

        result[curIndex] = cur;

        return Arrays.copyOf(result, curIndex + 1);
    }
}
