package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 强整数
 * @date 2020/3/19 9:15
 */
public class Leetcode970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        if (bound < 2) {
            return new ArrayList<>();
        }
        res.add(2);

        for (int i = 0; i < bound; i ++) {
            int val1 = (int) Math.pow(x, i);
            if (val1 >= bound) {
                break;
            }

            for (int j = 0; j < bound; j ++) {
                int val = (int) Math.pow(y, j) + val1;
                if (val <= bound) {
                    res.add(val);
                } else {
                    break;
                }
            }
        }

        List<Integer> ans = new ArrayList<>(res);
        Collections.sort(ans, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return ans;
    }
}
