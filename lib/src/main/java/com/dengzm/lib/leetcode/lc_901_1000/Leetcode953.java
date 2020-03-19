package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 验证外星语词典
 * @date 2020/3/19 8:44
 */
public class Leetcode953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int val = 0;
        for (char o : order.toCharArray()) {
            map.put(o, val);
            val ++;
        }

        for (int i = 1; i < words.length; i ++) {
            String pre = words[i-1];
            String cur = words[i];
            boolean isOrdered = false;
            for (int j = 0; j < pre.length(); j ++) {
                if (j >= cur.length()) {
                    break;
                }

                if (map.get(pre.charAt(j)) < map.get(cur.charAt(j))) {
                    isOrdered = true;
                    break;
                } else if (map.get(pre.charAt(j)) > map.get(cur.charAt(j))) {
                    break;
                }
            }

            if (!isOrdered) {
                return false;
            }
        }

        return true;
    }
}
