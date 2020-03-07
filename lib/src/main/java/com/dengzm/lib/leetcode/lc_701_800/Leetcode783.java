package com.dengzm.lib.leetcode.lc_701_800;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉搜索树结点最小距离
 * @date 2020/3/7 9:15
 */
public class Leetcode783 {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        mid(list, root);

        int min = 100000;
        int pre = list.get(0);
        for (int i = 1; i < list.size(); i ++) {
            int cur = list.get(i);
            min = Math.min(min, cur - pre);
            pre = cur;
        }

        return min;
    }

    private void mid(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        mid(list, root.left);
        list.add(root.val);
        mid(list, root.right);
    }
}
