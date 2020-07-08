package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 剑指 Offer 50. 第一个只出现一次的字符
 * @date 2020/6/24 8:14
 */
public class Ms050 {
    public char firstUniqChar(String s) {
        int[] chars = new int[1080];
        for (char c : s.toCharArray()) {
            chars[c] ++;
        }

        for (char c : s.toCharArray()) {
            if (chars[c] == 1) {
                return c;
            }
        }

        return ' ';
    }
}
