package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description Bigram 分词
 * @date 2020/3/26 10:13
 */
public class Leetcode1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] t = text.split(" ");
        for (int i = 0; i < t.length - 2; i ++) {
            if (t[i].equals(first) && t[i+1].equals(second)) {
                res.add(t[i+2]);
            }
        }

        return res.toArray(new String[0]);
    }
}
