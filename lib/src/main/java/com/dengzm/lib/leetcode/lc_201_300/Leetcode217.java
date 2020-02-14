package com.dengzm.lib.leetcode.lc_201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 存在重复元素
 * @date 2020/2/13 18:10
 */
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        return nums.length != set.size();
    }
}
