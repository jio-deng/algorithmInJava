package com.dengzm.lib.leetcode.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 单词规律
 * @date 2020/2/13 17:55
 */
public class Leetcode290 {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        Map<Character, String> map = new HashMap<>();
        String[] strings = str.split(" ");

        if (strings.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i ++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strings[i])) {
                    return false;
                }
            } else if (map.containsValue(strings[i])) {
                return false;
            }

            map.put(pattern.charAt(i), strings[i]);
        }

        return true;
    }
}
