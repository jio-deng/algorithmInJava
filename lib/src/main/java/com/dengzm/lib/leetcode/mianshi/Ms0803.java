package com.dengzm.lib.leetcode.mianshi;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.03. 魔术索引
 * @date 2020/4/11 17:32
 */
public class Ms0803 {
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (i == nums[i]) {
                return i;
            }
        }

        return -1;
    }
}
