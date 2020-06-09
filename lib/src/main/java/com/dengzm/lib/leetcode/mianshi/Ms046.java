package com.dengzm.lib.leetcode.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题46. 把数字翻译成字符串
 * @date 2020/6/9 14:19
 */
public class Ms046 {
    private Map<String, Integer> cache = new HashMap<>();

    public int translateNum(int num) {
        return translateNum(String.valueOf(num));
    }

    private int translateNum(String s) {
        if (s == null || s.length() <= 1) {
            return 1;
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        int res = translateNum(s.substring(1));
        if (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) - '0' <= 5) {
            res += translateNum(s.substring(2));
        }

        cache.put(s, res);
        return res;
    }
}
