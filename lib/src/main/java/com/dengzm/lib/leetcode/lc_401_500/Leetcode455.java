package com.dengzm.lib.leetcode.lc_401_500;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分发饼干
 * @date 2020/2/20 19:00
 */
public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0, sIndex = 0, ans = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                ans ++;
                gIndex ++;
                sIndex ++;
            } else {
                sIndex ++;
            }
        }

        return ans;
    }
}
