package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最短完整词
 * @date 2020/3/6 10:09
 */
public class Leetcode748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] chars = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                chars[c-'a'] ++;
            }
        }

        int length = 100000;
        String res = "";

        for (String word : words) {
            if (word.length() >= length) {
                continue;
            }

            int[] tmp = new int[26];
            for (char c : word.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    tmp[c-'a'] ++;
                }
            }

            boolean match = true;
            for (int i = 0; i < 26; i ++) {
                if (chars[i] > tmp[i]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                if (word.length() < length) {
                    res = word;
                    length = word.length();
                }
            }
        }

        return res;
    }
}
