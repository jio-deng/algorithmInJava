package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 计数二进制子串
 * @date 2020/3/1 10:14
 */
public class Leetcode696 {
    public int countBinarySubstrings(String s) {
        int res, last, cur;
        res = last = 0; cur = 1;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur ++;
            } else {
                last = cur;
                cur = 1;
            }

            if (last >= cur) {
                res ++;
            }
        }

        return res;
    }
}
