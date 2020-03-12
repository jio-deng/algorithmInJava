package com.dengzm.lib.leetcode.lc_801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两句话中的不常见单词
 * @date 2020/3/11 12:24
 */
public class Leetcode884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] strings1 = A.split(" ");
        String[] strings2 = B.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String s : strings1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : strings2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        return res.toArray(new String[] {});
    }
}
