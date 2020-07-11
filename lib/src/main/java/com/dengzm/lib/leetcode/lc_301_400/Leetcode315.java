package com.dengzm.lib.leetcode.lc_301_400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 计算右侧小于当前元素的个数
 * @date 2020/7/11 8:38
 */
class Leetcode315 {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }

        int[] count = new int[nums.length];

        for (int i = nums.length - 2; i >= 0; i --) {
            int c = 0;

            for (int j = i+1; j < nums.length; j ++) {
                if (nums[j] > nums[i]) {
                    continue;
                } else if (nums[j] == nums[i]) {
                    count[i] = count[j] + c;
                    break;
                } else {
                    c ++;
                    count[i] = Math.max(count[i], count[j] + c);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int c : count) {
            list.add(c);
        }
        return list;
    }
}
