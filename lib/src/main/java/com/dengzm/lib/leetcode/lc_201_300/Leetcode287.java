package com.dengzm.lib.leetcode.lc_201_300;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 寻找重复数
 * @date 2020/4/8 10:34
 */
public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        int num = nums[0];
        while (true) {
            int another = nums[num];
            if (another == num) {
                return another;
            }

            nums[num] = num;
            num = another;
        }
    }
}
