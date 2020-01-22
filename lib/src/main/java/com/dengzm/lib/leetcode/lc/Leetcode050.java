package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description Pow(x, n)
 * @date 2020/1/22 12:47
 */
public class Leetcode050 {
    /**
     * 栈溢出
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return myPow1(1 / x, n);
        }

        double temp = myPow1(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
