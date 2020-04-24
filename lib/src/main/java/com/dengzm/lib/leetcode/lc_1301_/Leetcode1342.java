package com.dengzm.lib.leetcode.lc_1301_;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 将数字变成 0 的操作次数
 * @date 2020/4/1 13:36
 */
public class Leetcode1342 {
    public int numberOfSteps (int num) {
        int ans = 0;
        while (num > 0) {
            if (num == 1) {
                ans += 1;
                break;
            }

            if (num % 2 == 0) {
                ans += 1;
            } else {
                ans += 2;
            }

            num /= 2;
        }

        return ans;
    }
}
