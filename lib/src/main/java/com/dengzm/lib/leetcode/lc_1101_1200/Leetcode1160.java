package com.dengzm.lib.leetcode.lc_1101_1200;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 拼写单词
 * @date 2020/3/17 8:54
 */
public class Leetcode1160 {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;

        int[] target = new int[26];
        for (int i = 0; i < chars.length(); i ++) {
            target[chars.charAt(i) - 'a'] ++;
        }

        int[] cur = new int[26];
        for (String word : words) {
            Arrays.fill(cur, 0);
            boolean flag = true;
            for (char c : word.toCharArray()) {
                cur[c - 'a'] ++;
                if (cur[c - 'a'] > target[c - 'a']) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans += word.length();
            }
        }

        return ans;
    }
}
