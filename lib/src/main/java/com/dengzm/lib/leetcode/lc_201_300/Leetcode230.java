package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉搜索树中第K小的元素
 * @date 2020/6/12 10:17
 */
public class Leetcode230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        aaa(list, root);
        return list.get(k-1);
    }

    private void aaa(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        aaa(list, node.left);
        list.add(node.val);
        aaa(list, node.right);
    }
}
