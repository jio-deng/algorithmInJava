package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两地调度
 * @date 2020/3/25 12:19
 */
public class Leetcode1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });

        int ans = 0;
        for (int i = 0; i < costs.length; i ++) {
            if (i < costs.length / 2) {
                ans += costs[i][0];
            } else {
                ans += costs[i][1];
            }
        }

        return ans;
    }
}
