package com.dengzm.lib.leetcode.lc_1101_1200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 比较字符串最小字母出现频次
 * @date 2020/3/27 10:49
 */
public class Leetcode1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] que = new int[queries.length];
        int[] wor = new int[words.length];

        for (int i = 0; i < queries.length; i ++) {
            que[i] = f(queries[i]);
        }

        for (int i = 0; i < words.length; i ++) {
            wor[i] = f(words[i]);
        }

        Arrays.sort(wor);

        for (int i = 0; i < que.length; i ++) {
            int q = que[i];
            for (int j = wor.length - 1; j >= 0; j --) {
                int w = wor[j];
                if (q < w) {
                    ans[i] ++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    private int f(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] chars = new int[26];
        for (char c : s.toCharArray()){
            chars[c-'a'] ++;
        }

        for (int i : chars) {
            if (i > 0) {
                return i;
            }
        }

        return 0;
    }
}
