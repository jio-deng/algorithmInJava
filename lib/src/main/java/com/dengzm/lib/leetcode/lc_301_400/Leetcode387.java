package com.dengzm.lib.leetcode.lc_301_400;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字符串中的第一个唯一字符
 * @date 2020/2/15 10:10
 */
public class Leetcode387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i ++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
