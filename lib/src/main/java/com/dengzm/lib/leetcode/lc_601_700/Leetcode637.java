package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的层平均值
 * @date 2020/2/28 10:01
 */
public class Leetcode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(sum / size);
        }

        return result;
    }
}
