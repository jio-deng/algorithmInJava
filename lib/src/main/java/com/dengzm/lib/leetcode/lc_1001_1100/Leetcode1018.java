package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 可被 5 整除的二进制前缀
 * @date 2020/3/24 10:43
 */
public class Leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        long num = 0;
        for (int value : A) {
            num <<= 1;
            num += value;
            res.add(num % 5 == 0);
        }

        return res;
    }

    public List<Boolean> prefixesDivBy5_1(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int value : A) {
            num <<= 1;
            num += value;
            num %= 5;
            res.add(num == 0);
        }

        return res;
    }
}
