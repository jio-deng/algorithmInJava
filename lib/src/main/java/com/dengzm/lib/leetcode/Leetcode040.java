package com.dengzm.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 组合总和 II
 * @date 2020/1/18 13:07
 */
public class Leetcode040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        combinationSumCore(candidates, target, 0, 0, result, new ArrayList<Integer>());

        return new ArrayList<>(result);
    }

    private void combinationSumCore(int[] candidates, int target, int current, int index, Set<List<Integer>> result, List<Integer> list) {
        if (target == current) {
            result.add(list);
            return;
        }

        while (index < candidates.length && current + candidates[index] <= target) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[index]);
            combinationSumCore(candidates, target, current + candidates[index], ++ index, result, temp);
        }
    }

}
