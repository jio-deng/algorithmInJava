package com.dengzm.lib.leetcode.lc_801_900;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 山羊拉丁文
 * @date 2020/3/9 12:03
 */
public class Leetcode824 {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i ++) {
            StringBuilder word;
            if (words[i].charAt(0) == 'A' || words[i].charAt(0) == 'E' || words[i].charAt(0) == 'I' ||
                    words[i].charAt(0) == 'O' || words[i].charAt(0) == 'U' || words[i].charAt(0) == 'a' ||
                    words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i' || words[i].charAt(0) == 'o' ||
                    words[i].charAt(0) == 'u') {
                // do nothing
                word = new StringBuilder(words[i]);
            } else {
                word = new StringBuilder(words[i].substring(1) + words[i].charAt(0));
            }

            word.append("ma");
            for (int j = 0; j <= i; j ++) {
                word.append("a");
            }

            res.append(word).append(" ");
        }

        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }
}
