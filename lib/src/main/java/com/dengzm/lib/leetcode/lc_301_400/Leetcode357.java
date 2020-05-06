package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 计算各个位数不同的数字个数
 * @date 2020/5/4 10:45
 */
public class Leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        if (n > 10) {
            n = 10;
        }

        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            int start = 9, tmp = i - 1, extra = 9;
            while (tmp > 0) {
                start *= extra;
                extra --;
                tmp --;
            }

            ans += start;
        }

        return ans + 1;
    }
}
