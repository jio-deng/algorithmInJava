package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 移动石子直到连续
 * @date 2020/3/25 10:28
 */
public class Leetcode1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        int[] data = new int[3];
        data[0] = a;
        data[1] = b;
        data[2] = c;
        Arrays.sort(data);

        ans[1] += Math.abs(data[0] - data[1]) - 1;
        ans[1] += Math.abs(data[1] - data[2]) - 1;
        if (Math.abs(data[0] - data[1]) == 2 || Math.abs(data[1] - data[2]) == 2) {
            ans[0] = 1;
        } else {
            ans[0] += Math.abs(data[0] - data[1]) - 1 == 0 ? 0 : 1;
            ans[0] += Math.abs(data[1] - data[2]) - 1 == 0 ? 0 : 1;
        }

        return ans;
    }
}
