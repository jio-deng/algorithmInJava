package com.dengzm.lib.leetcode.lc_51_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 颜色分类
 * @date 2020/1/28 17:43
 */
public class Leetcode075 {
    public void sortColors(int[] nums) {
        int start = 0, cur = 0, end = nums.length - 1;

        while (cur <= end) {
            if (nums[cur] == 0) {
                nums[cur] = nums[start];
                nums[start] = 0;
                start ++;
                cur ++;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[end];
                nums[end] = 2;
                end --;
            } else {
                cur ++;
            }
        }
    }
}
