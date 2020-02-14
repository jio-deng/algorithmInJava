package com.dengzm.lib.leetcode.lc_201_300;

import java.util.TreeSet;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 存在重复元素 III
 * @date 2020/2/13 18:33
 */
public class Leetcode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            Long ceiling = set.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= nums[i]) {
                return true;
            }

            Long floor = set.floor((long) nums[i] + t);
            if (floor != null && floor >= nums[i]) {
                return true;
            }

            set.add((long) nums[i]);

            if (i >= k) {
                set.remove((long) nums[i-k]);
            }
        }

        return false;
    }
}
