package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最大单词长度乘积
 * @date 2020/6/20 11:22
 */
public class Leetcode318 {
    public int maxProduct(String[] words) {
        int[] codes = new int[words.length];
        for (int i = 0; i < words.length; i ++) {
            for (char c : words[i].toCharArray()) {
                int plus = 1 << (c - 'a');
                if ((codes[i] & plus) == 0) {
                    codes[i] += plus;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < words.length - 1; i ++) {
            for (int j = i+1; j < words.length; j ++) {
                if ((codes[i] & codes[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}
