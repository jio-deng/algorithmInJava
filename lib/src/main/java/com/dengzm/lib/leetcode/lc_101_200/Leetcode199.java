package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的右视图
 * @date 2020/4/3 14:02
 */
public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            boolean isAdded = false;
            while (length > 0) {
                TreeNode node = queue.poll();
                if (!isAdded) {
                    res.add(node.val);
                    isAdded = true;
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                length --;
            }
        }

        return res;
    }
}
