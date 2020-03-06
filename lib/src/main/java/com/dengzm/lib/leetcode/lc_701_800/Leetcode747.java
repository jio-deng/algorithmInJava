package com.dengzm.lib.leetcode.lc_701_800;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 至少是其他数字两倍的最大数
 * @date 2020/3/6 9:54
 */
public class Leetcode747 {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        if (tmp[tmp.length - 1] < tmp[tmp.length - 2] * 2) {
            return -1;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == tmp[tmp.length - 1]) {
                return i;
            }
        }

        return -1;
    }
}
