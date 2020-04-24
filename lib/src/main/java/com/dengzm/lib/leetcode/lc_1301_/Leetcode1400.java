package com.dengzm.lib.leetcode.lc_1301_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 构造 K 个回文字符串
 * @date 2020/4/17 19:44
 */
public class Leetcode1400 {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }

        if (k == s.length()) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int val = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                val ++;
            }
        }

        return val <= k;
    }
}
