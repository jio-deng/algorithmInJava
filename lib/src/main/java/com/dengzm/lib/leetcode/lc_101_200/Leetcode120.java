package com.dengzm.lib.leetcode.lc_101_200;

import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 三角形最小路径和
 * @date 2020/2/7 19:42
 */
public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return -1;
        }

        int[] nums = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i ++) {
            if (i == 0) {
                nums[0] = triangle.get(0).get(0);
                continue;
            }

            List<Integer> list = triangle.get(i);
            for (int j = i; j >= 0; j --) {
                if (j == i) {
                    nums[j] = list.get(j) + nums[j-1];
                } else if (j == 0) {
                    nums[j] += list.get(0);
                } else {
                    nums[j] = list.get(j) + Math.min(nums[j], nums[j-1]);
                }
            }
        }

        int min = 10000000;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }
}
