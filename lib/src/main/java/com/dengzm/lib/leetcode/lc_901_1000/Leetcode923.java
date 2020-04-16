package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 三数之和的多种可能
 * @date 2020/4/16 9:53
 */
public class Leetcode923 {
    private int MOD = 1000000007;

    public int threeSumMulti(int[] A, int target) {
        long ans = 0;
        long[] count = new long[101];
        for (int a : A) {
            count[a] ++;
        }

        for (int i = 0; i <= target; i ++) {
            for (int j = i; j <= target; j ++) {
                int k = target - i - j;

                if (k < 0 || k > count.length || k < j) continue;
                if (i < 0 || i > 100 || j < 0 || j > 100 || k < 0 || k > 100) continue;

                if (i == j && j == k) {
                    ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    ans += count[k] * count[i] * (count[i] - 1) / 2;
                } else if (i != j && j == k) {
                    ans += count[i] * count[j] * (count[j] - 1) / 2;
                } else {
                    ans += count[i] * count[j] * count[k];
                }

                ans %= MOD;
            }
        }

        return (int) ans;
    }
}
