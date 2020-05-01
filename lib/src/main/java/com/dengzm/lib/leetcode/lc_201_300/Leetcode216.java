package com.dengzm.lib.leetcode.lc_201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 组合总和 III
 * @date 2020/4/29 19:01
 */
public class Leetcode216 {
    private int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(), 1, k, 0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> list, int start, int k, int sum) {
        if (k == 0) {
            if (sum == n) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (start > 9) {
            return;
        }

        for (int i = start; i <= 9; i ++) {
            if (n < i) {
                break;
            }

            list.add(i);
            backTrack(ans, list, i+1, k-1, sum + i);
            list.remove(list.size() - 1);
        }
    }
}
