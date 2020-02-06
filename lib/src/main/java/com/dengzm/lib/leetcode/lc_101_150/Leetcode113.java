package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 路径总和 II
 * @date 2020/2/6 11:18
 */
public class Leetcode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumCore(root, sum, result, new ArrayList<Integer>());

        return result;
    }

    private void pathSumCore(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left == null && root.right == null && sum - root.val == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            pathSumCore(root.left, sum - root.val, lists, list);
            pathSumCore(root.right, sum - root.val, lists, list);
        }

        list.remove(list.size() - 1);
    }
}
