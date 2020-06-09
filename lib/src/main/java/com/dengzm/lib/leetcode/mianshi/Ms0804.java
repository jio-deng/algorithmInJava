package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.04. 幂集
 * @date 2020/6/8 11:52
 */
public class Ms0804 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, list, res);

        return res;
    }

    private void backtrack(int[] nums, int cur, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = cur; i < nums.length; ++i) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
