package com.dengzm.lib.leetcode.lc_801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 查找和替换模式
 * @date 2020/4/16 9:23
 */
public class Leetcode890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }

            map1.clear();
            map2.clear();

            boolean flag = true;
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);
                char p = pattern.charAt(i);

                if (!map1.containsKey(c) && !map2.containsKey(p)) {
                    map1.put(c, p);
                    map2.put(p, c);
                } else if (!map1.containsKey(c) || !map2.containsKey(p)
                        || map1.get(c) != p || map2.get(p) != c) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res.add(word);
            }
        }

        return res;
    }
}
