package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.05. 递归乘法
 * @date 2020/4/17 19:26
 */
public class Ms0805 {
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }

        boolean flag = true;

        if (A < 0) {
            A = -A;
            flag = false;
        }

        if (B < 0) {
            B = -B;
            flag = !flag;
        }

        if (A < B) {
            A = A + B - (B = A);
        }

        int res = mutiplyCore(A, B, 0);
        return flag ? res : -res;
    }

    private int mutiplyCore(int A, int B, int ans) {
        if (B == 0) {
            return ans;
        }

        return mutiplyCore(A, B - 1, ans + A);
    }
}
