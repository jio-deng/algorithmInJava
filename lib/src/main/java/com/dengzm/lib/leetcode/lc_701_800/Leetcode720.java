package com.dengzm.lib.leetcode.lc_701_800;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 词典中最长的单词
 * @date 2020/3/4 10:26
 */
public class Leetcode720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        Set<String> set = new HashSet<>();
        String result = "";

        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                set.add(s);
                if (s.length() > result.length()) {
                    result = s;
                }
            }
        }

        return result;
    }
}
