package com.dengzm.lib.leetcode.lc_801_900;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 递增顺序查找树
 * @date 2020/3/12 16:27
 */
public class Leetcode897 {
    TreeNode dummy = new TreeNode(0), node = dummy;

    public TreeNode increasingBST(TreeNode root) {
        increasingBSTCore(root);
        return dummy.right;
    }

    private void increasingBSTCore(TreeNode root) {
        if (root == null) {
            return;
        }

        // System.out.println(root.val);

        increasingBSTCore(root.left);
        node.right = new TreeNode(root.val);
        node = node.right;
        increasingBSTCore(root.right);
    }
}
