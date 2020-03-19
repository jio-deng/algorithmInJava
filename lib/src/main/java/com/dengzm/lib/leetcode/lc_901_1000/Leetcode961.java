package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 重复 N 次的元素
 * @date 2020/3/19 8:56
 */
public class Leetcode961 {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a)) {
                return a;
            }

            set.add(a);
        }

        return -1;
    }
}
