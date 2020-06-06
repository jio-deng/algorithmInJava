package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题64. 求1+2+…+n
 * @date 2020/6/2 15:02
 */
public class Ms064 {
    public int sumNums(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            ans = plus(ans, i);
        }

        return ans;
    }

    private int plus(int a, int b) {
        if (a < b) {
            a = a + b - (b = a);
        }

        int sum, plus;
        while (b > 0) {
            sum = a ^ b;
            plus = (a & b) << 1;
            a = sum;
            b = plus;
        }

        return a;
    }
}
