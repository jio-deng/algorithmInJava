package com.dengzm.lib.leetcode.lc_1001_1100;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 从根到叶的二进制数之和
 * @date 2020/3/25 8:52
 */
public class Leetcode1022 {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeafCore(root, 0);
    }

    private int sumRootToLeafCore(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        val = val * 2 + node.val;
        if (node.left == null && node.right == null) {
            return val;
        } else {
            return sumRootToLeafCore(node.left, val) + sumRootToLeafCore(node.right, val);
        }
    }
}
