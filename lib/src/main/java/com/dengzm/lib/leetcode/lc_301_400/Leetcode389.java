package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 找不同
 * @date 2020/2/15 10:24
 */
public class Leetcode389 {
    public char findTheDifference(String s, String t) {
        int result = 0;

        for (int i = 0; i < s.length(); i ++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }

        result ^= t.charAt(t.length() - 1);

        return (char) result;
    }


    public char findTheDifference1(String s, String t) {
        int[] chars = new int[128];

        for (int i = 0; i < s.length(); i ++) {
            chars[s.charAt(i)] ++;
        }

        for (int i = 0; i < t.length(); i ++) {
            chars[t.charAt(i)] --;

            if (chars[t.charAt(i)] < 0) {
                return t.charAt(i);
            }
        }

        return '?';
    }
}
