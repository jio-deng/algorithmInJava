package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 翻转字符串里的单词
 * @date 2020/3/18 11:30
 */
public class Leetcode151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int start = -1, end = -1;

        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) == ' ') {
                if (start != -1) {
                    if (end != -1) {
                        res.append(s, end, start + 1);
                        start = -1;
                        end = -1;
                    } else {
                        res.append(s, start, start + 1);
                        start = -1;
                    }

                    res.append(" ");
                }
            } else {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }

        if (start != -1) {
            if (end != -1) {
                res.append(s, end, start + 1);
            } else {
                res.append(s, start, start + 1);
            }

            res.append(" ");
        }

        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }
}
