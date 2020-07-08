package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 16.11. 跳水板
 * @date 2020/7/8 8:50
 */
public class Ms1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[0];
        }

        int gap = longer - shorter;
        if (gap == 0) {
            return new int[] {shorter * k};
        }

        int min = shorter * k;

        int[] ans = new int[k+1];
        for (int i = 0; i <= k; i ++) {
            ans[i] = min + gap * i;
        }

        return ans;
    }
}
