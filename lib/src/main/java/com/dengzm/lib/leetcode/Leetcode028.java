package com.dengzm.lib.leetcode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 实现 strStr()
 * @date 2020/1/3 21:40
 */
public class Leetcode028 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        if (haystack.length() == 0) {
            return needle.length() == 0 ? 0 : -1;
        }

        boolean flag;
        for (int i = 0; i < haystack.length(); i ++) {
            flag = true;

            for (int j = 0; j < needle.length(); j ++) {
                if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
        }

        return -1;
    }
}
