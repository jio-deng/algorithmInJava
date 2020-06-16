package com.dengzm.lib.leetcode.lc_1301_;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 连续字符
 * @date 2020/6/16 11:32
 */
public class Leetcode1446 {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        int cur = 0;
        char c = 0;

        for (int i = 0; i < s.length(); i ++) {
            if (i == 0) {
                cur = 1;
                c = s.charAt(i);
                continue;
            }

            char cc = s.charAt(i);
            if (cc == c) {
                cur ++;
            } else {
                ans = Math.max(ans, cur);
                cur = 1;
                c = cc;
            }
        }

        ans = Math.max(ans, cur);
        return ans;
    }
}
