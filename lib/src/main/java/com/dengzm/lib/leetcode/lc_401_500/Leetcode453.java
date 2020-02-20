package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最小移动次数使数组元素相等
 * @date 2020/2/20 18:06
 */
public class Leetcode453 {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        int sum = 0;
        for (int num : nums) {
            sum += (num - min);
        }

        return sum;
    }
}
