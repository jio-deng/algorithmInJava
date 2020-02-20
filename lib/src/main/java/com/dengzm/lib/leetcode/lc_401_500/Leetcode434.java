package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字符串中的单词数
 * @date 2020/2/17 11:31
 */
public class Leetcode434 {
    // c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'
    public int countSegments(String s) {
        int result = 0;
        int curLength = 0;

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c != ' ') {
                curLength ++;
            } else {
                if (curLength > 0) {
                    result ++;
                    curLength = 0;
                }
            }
        }

        if (curLength > 0) {
            result ++;
        }

        return result;
    }
}
