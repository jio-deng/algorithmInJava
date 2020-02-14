package com.dengzm.lib.leetcode.lc_1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 组合
 * @date 2020/1/29 11:51
 */
public class Leetcode077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (k < 1 || n < k) {
            return result;
        }

        combineCore(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }

    private void combineCore(List<List<Integer>> result, List<Integer> list, int n, int k, int curIndex) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 剪枝
        if (curIndex > n || (n - curIndex + 1) < (k - list.size())) {
            return;
        }

        for (int i = curIndex; i <= n; i ++) {
            list.add(i);
            combineCore(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
