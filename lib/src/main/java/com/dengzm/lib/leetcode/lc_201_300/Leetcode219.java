package com.dengzm.lib.leetcode.lc_201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 存在重复元素 II
 * @date 2020/2/13 18:22
 */
public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if (i >= k) {
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
}
