package com.dengzm.lib.leetcode.lc_1201_1300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分割平衡字符串
 * @date 2020/3/31 16:59
 */
public class Leetcode1221 {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int L = 0, R = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                L ++;
            } else if (c == 'R') {
                R ++;
            }

            if (L == R && L != 0) {
                ans ++;
                L = 0;
                R = 0;
            }
        }

        return ans;
    }
}
