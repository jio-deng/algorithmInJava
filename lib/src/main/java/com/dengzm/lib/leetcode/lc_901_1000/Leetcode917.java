package com.dengzm.lib.leetcode.lc_901_1000;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 仅仅反转字母
 * @date 2020/3/14 11:58
 */
public class Leetcode917 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            while (start < end && !isChar(chars[start])) {
                start ++;
            }

            while (end > start && !isChar(chars[end])) {
                end --;
            }

            if (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start ++;
                end --;
            }
        }

        return String.valueOf(chars);
    }

    private boolean isChar(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }
}
