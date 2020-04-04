package com.dengzm.lib.leetcode.lc_101_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 重复的DNA序列
 * @date 2020/4/3 11:12
 */
public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }

        int length = 10;
        Set<String> set1 = new HashSet<>(), set2 = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i ++) {
            String target = s.substring(i, i+length);
            if (set1.contains(target)) {
                set2.add(target);
            } else {
                set1.add(target);
            }
        }

        return new ArrayList<>(set2);
    }
}
