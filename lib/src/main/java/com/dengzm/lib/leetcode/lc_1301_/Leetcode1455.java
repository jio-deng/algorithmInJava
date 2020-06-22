package com.dengzm.lib.leetcode.lc_1301_;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 检查单词是否为句中其他单词的前缀
 * @date 2020/6/18 16:14
 */
public class Leetcode1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = 0;
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i ++) {
            String s = strings[i];
            if (s.startsWith(searchWord)) {
                return i+1;
            }
        }

        return -1;
    }
}
