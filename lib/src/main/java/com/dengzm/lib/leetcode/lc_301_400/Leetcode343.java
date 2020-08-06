package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 整数拆分
 * @date 2020/7/30 14:10
 */
class Leetcode343 {
    public int integerBreak(int n) {
        // 拆分成1和n-1
        if (n <= 3) {
            return n-1;
        }

        int ans = 1;

        // 大于4时，拆分出3
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }

        // 剩余部分
        if (n > 0) {
            ans *= n;
        }

        return ans;
    }
}
