package com.dengzm.lib.leetcode.lc_201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 同构字符串
 * @date 2020/2/13 17:16
 */
public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0) {
            return t.length() == 0;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (map.containsValue(t.charAt(i))) {
                return false;
            }

            map.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}
