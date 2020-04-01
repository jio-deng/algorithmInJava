package com.dengzm.lib.leetcode.lc_1201_1300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 独一无二的出现次数
 * @date 2020/3/31 16:49
 */
public class Leetcode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            }

            set.add(entry.getValue());
        }

        return true;
    }
}
