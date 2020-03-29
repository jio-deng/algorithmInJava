package com.dengzm.lib.leetcode.lc_1101_1200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 质数排列
 * @date 2020/3/29 11:56
 */
public class Leetcode1175 {
    private static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        boolean[] isPrime = new boolean[n+1];
        int prime = 0;
        for (int i = 2; i <= n; i ++) {
            if (isPrime[i]) {
                continue;
            }

            prime ++;

            // 标记非质数
            int muti = 2;
            while (i * muti <= n) {
                isPrime[i * muti] = true;
                muti ++;
            }
        }

        return (int) (factorial(prime)* factorial(n - prime) % MOD);
    }

    private long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i ++) {
            ans *= i;
            ans %= MOD;
        }

        return ans;
    }
}
