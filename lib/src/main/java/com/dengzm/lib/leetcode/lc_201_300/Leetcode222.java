package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 完全二叉树的节点个数
 * @date 2020/5/4 11:16
 */
public class Leetcode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
