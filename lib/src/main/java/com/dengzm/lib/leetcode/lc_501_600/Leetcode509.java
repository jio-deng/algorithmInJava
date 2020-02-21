package com.dengzm.lib.leetcode.lc_501_600;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 斐波那契数
 * @date 2020/2/21 15:29
 */
public class Leetcode509 {
    int[] memo;
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        return fibCore(N);
    }

    private int fibCore(int N) {
        if (memo[N] != 0 || N == 0) {
            return memo[N];
        }

        int ans = fibCore(N-1) + fibCore(N-2);
        memo[N] = ans;
        return ans;
    }
}
