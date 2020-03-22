package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 使数组唯一的最小增量
 * @date 2020/3/22 9:53
 */
public class Leetcode945 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        int min = -1;
        for (int a : A) {
            if (a > min) {
                min = a;
            } else {
                min ++;
                ans += (min - a);
            }
        }

        return ans;
    }
}
