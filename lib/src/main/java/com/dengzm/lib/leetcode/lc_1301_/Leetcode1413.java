package com.dengzm.lib.leetcode.lc_1301_;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 逐步求和得到正数的最小值
 * @date 2020/4/24 10:43
 */
public class Leetcode1413 {
    public int minStartValue(int[] nums) {
        int min = 1;
        int cur = 1;
        for (int num : nums) {
            cur += num;
            min = Math.min(min, cur);
        }

        return min >= 1 ? 1 : 2 - min;
    }
}
