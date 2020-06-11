package com.dengzm.lib.leetcode.lc_401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数组中重复的数据
 * @date 2020/6/11 9:57
 */
public class Leetcode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] != i + 1) {
                int v = nums[nums[i] - 1];
                if (nums[i] == v) {
                    break;
                }

                nums[nums[i] - 1] = nums[i];
                nums[i] = v;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }

        return res;
    }
}
