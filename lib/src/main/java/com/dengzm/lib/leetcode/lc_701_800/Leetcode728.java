package com.dengzm.lib.leetcode.lc_701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 自除数
 * @date 2020/3/2 12:36
 */
public class Leetcode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        for (int i = left; i <= right; i ++) {
            int num = i;
            while (num > 0) {
                int tmp = num % 10;
                if (tmp == 0 || i % tmp != 0) {
                    break;
                }

                num /= 10;
            }

            if (num == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
