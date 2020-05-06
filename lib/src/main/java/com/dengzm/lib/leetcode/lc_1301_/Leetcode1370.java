package com.dengzm.lib.leetcode.lc_1301_;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 上升下降字符串
 * @date 2020/5/2 12:28
 */
public class Leetcode1370 {
    public String sortString(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a'] ++;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i < 26; i ++) {
                if (counts[i] > 0) {
                    sb.append((char)('a' + i));
                    counts[i] --;
                    count ++;
                }
            }

            for (int i = 25; i >= 0; i --) {
                if (counts[i] > 0) {
                    sb.append((char)('a' + i));
                    counts[i] --;
                    count ++;
                }
            }
        }

        return sb.toString();
    }
}
