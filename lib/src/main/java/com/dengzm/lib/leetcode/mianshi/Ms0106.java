package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 01.06. 字符串压缩
 * @date 2020/3/16 9:54
 */
public class Ms0106 {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        int cur = 1;
        char curChar = S.charAt(0);

        for (int i = 1; i < S.length(); i ++) {
            char c = S.charAt(i);
            if (curChar == c) {
                cur ++;
            } else {
                res.append(curChar).append(cur);
                curChar = c;
                cur = 1;
            }
        }

        res.append(curChar).append(cur);

        return res.length() < S.length() ? res.toString() : S;
    }
}
