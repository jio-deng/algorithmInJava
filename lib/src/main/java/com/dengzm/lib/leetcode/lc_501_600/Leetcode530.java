package com.dengzm.lib.leetcode.lc_501_600;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉搜索树的最小绝对差
 * @date 2020/2/21 15:55
 */
public class Leetcode530 {
    TreeNode pre;
    int min = 10000;

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre = null;
        getTree(root);

        return min;
    }

    private void getTree(TreeNode root) {
        if (root == null) {
            return;
        }

        getTree(root.left);

        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }

        pre = root;
        getTree(root.right);
    }
}
