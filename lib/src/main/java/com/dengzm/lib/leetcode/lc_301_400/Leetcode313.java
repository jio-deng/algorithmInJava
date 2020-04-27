package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 超级丑数
 * @date 2020/4/26 9:40
 */
public class Leetcode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[primes.length];

        for (int i = 1; i < n; i ++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j ++) {
                if (min > dp[index[j]] * primes[j]) {
                    min = dp[index[j]] * primes[j];
                }

                dp[i] = min;
            }

            for (int j = 0; j < primes.length; j ++) {
                if (min == dp[index[j]] * primes[j]) {
                    index[j] ++;
                }
            }
        }

        return dp[n-1];
    }
}
