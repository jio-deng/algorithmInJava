package com.dengzm.lib.leetcode.lc_301_400;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 摆动排序 II
 * @date 2020/6/21 8:38
 */
public class Leetcode324 {
    public void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int start = (nums.length - 1) / 2, end = nums.length - 1;
        int index = 0;
        while (start >= 0) {
            nums[index] = tmp[start];
            index ++;
            if (index < nums.length) {
                nums[index] = tmp[end];
                index ++;
            }
            start --;
            end --;
        }
    }
}
