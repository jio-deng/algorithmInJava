package com.dengzm.lib.leetcode.lc_801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最常见的单词
 * @date 2020/3/9 10:19
 */
public class Leetcode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> words = new ArrayList<>();
        paragraph = paragraph.toLowerCase();
        int start = -1, end = -1;
        for (int i = 0; i < paragraph.length(); i ++) {
            if (paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z') {
                if (start == -1) {
                    start = i;
                    end = i;
                } else {
                    end ++;
                }
            } else {
                if (start == -1) {
                    // do nothing
                } else {
                    words.add(paragraph.substring(start, end + 1));
                    start = -1;
                    end = -1;
                }
            }
        }

        if (start != -1) {
            words.add(paragraph.substring(start, end + 1));
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : banned) {
            map.remove(word);
        }

        String result = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
