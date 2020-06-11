package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题27. 二叉树的镜像
 * @date 2020/6/11 10:41
 */
public class Ms027 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        TreeNode n = root.left;
        root.left = root.right;
        root.right = n;
        return root;
    }
}
