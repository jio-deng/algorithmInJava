package com.dengzm.lib.leetcode.lc_51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 子集
 * @date 2020/1/28 17:46
 */
public class Leetcode078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        subsetsCore(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    private void subsetsCore(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<>(list));

        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i ++) {
            list.add(nums[i]);
            subsetsCore(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
