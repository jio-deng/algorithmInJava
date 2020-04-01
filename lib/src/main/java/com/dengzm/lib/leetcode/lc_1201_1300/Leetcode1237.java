package com.dengzm.lib.leetcode.lc_1201_1300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 找出给定方程的正整数解
 * @date 2020/3/21 11:13
 */
public class Leetcode1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 0, y = z;
        while (x <= z && y >= 1) {
            int val = customfunction.f(x, y);
            if (val > z) {
                y --;
            } else if (val < z) {
                x ++;
            } else if (val == z) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                res.add(list);
                x ++;
                y --;
            }
        }

        return res;
    }

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 0;
        }
    }
}