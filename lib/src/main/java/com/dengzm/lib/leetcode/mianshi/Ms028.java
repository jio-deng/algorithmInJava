package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题28. 对称的二叉树
 * @date 2020/6/12 10:49
 */
public class Ms028 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricCore(root.left, root.right);
    }

    private boolean isSymmetricCore(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetricCore(node1.left, node2.right) && isSymmetricCore(node1.right, node2.left);
    }
}
