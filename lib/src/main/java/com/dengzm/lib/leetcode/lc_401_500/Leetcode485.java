package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最大连续1的个数
 * @date 2020/2/21 13:03
 */
public class Leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;

        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        max = Math.max(max, cur);
        return max;
    }
}
