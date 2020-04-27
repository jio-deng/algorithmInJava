package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题14- I. 剪绳子
 * @date 2020/4/27 11:46
 */
public class Ms014 {
    public int cuttingRope1(int n) {
        if (n == 4) {
            return 4;
        } else if (n < 4) {
            return n - 1;
        }

        int count = 0;
        while (n > 4) {
            count ++;
            n -= 3;
        }

        if (n == 0) {
            n = 1;
        }

        return (int) Math.pow(3, count) * n;
    }

    private int MOD = (int) 1e9 + 7;
    public int cuttingRope(int n) {
        if (n == 4) {
            return 4;
        } else if (n < 4) {
            return n - 1;
        }

        int count = 0;
        while (n > 4) {
            count ++;
            n -= 3;
        }

        if (n == 0) {
            n = 1;
        }

        long ans = n;
        while (count > 0) {
            ans *= 3;
            ans %= MOD;
            count --;
        }

        return (int) ans;
    }
}
