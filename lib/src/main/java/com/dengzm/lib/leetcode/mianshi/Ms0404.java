package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 04.04. 检查平衡性
 * @date 2020/4/9 18:29
 */
public class Ms0404 {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        banlanceCore(root);
        return flag;
    }

    private int banlanceCore(TreeNode root) {
        if (!flag) {
            return 0;
        }

        if (root == null) {
            return 0;
        }

        int left = banlanceCore(root.left);
        int right = banlanceCore(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
            return 0;
        }

        return Math.max(left, right) + 1;
    }
}
