package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @date 2020/6/23 12:01
 */
public class Ms039 {
    public int majorityElement(int[] nums) {
        int num = -1;
        int count = 0;
        for (int n : nums) {
            if (n == num) {
                count ++;
            } else {
                if (count > 0) {
                    count --;
                } else {
                    num = n;
                    count = 1;
                }
            }
        }

        return num;
    }
}
