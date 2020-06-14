package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题58 - I. 翻转单词顺序
 *              面试题58 - II. 左旋转字符串
 * @date 2020/6/14 20:52
 */
public class Ms058 {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i --) {
            String ss = strings[i].trim();
            if (ss.isEmpty()) {
                continue;
            }

            res.append(ss).append(" ");
        }

        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }

    public String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }

        return s.substring(n) + s.substring(0, n);
    }
}
