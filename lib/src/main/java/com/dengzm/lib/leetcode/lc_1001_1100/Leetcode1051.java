package com.dengzm.lib.leetcode.lc_1001_1100;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 高度检查器
 * @date 2020/3/20 12:37
 */
public class Leetcode1051 {
    public int heightChecker(int[] heights) {
        int[] nums = Arrays.copyOf(heights, heights.length);
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (heights[i] != nums[i]) {
                ans ++;
            }
        }

        return ans;
    }
}
