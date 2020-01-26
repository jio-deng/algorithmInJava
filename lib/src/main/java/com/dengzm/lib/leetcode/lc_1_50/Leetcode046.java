package com.dengzm.lib.leetcode.lc_1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 全排列
 * @date 2020/1/21 14:26
 */
public class Leetcode046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        permuteCore(result, temp, nums, visited, 0);

        return result;
    }

    private void permuteCore(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] visited, int curLength) {
        if (curLength == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            curLength ++;
            temp.add(nums[i]);

            permuteCore(result, temp, nums, visited, curLength);

            visited[i] = false;
            curLength --;
            temp.remove(temp.size() - 1);
        }
    }
}
