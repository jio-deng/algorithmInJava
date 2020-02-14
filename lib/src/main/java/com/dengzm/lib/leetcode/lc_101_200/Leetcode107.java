package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的层次遍历 II
 * @date 2020/2/3 12:56
 */
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> curQueue = new LinkedList<>();
        LinkedList<TreeNode> nextQueue = new LinkedList<>();
        LinkedList<TreeNode> temp;
        List<Integer> list = new ArrayList<>();

        curQueue.add(root);

        while (!curQueue.isEmpty() || !nextQueue.isEmpty()) {
            if (curQueue.isEmpty()) {
                temp = curQueue;
                curQueue = nextQueue;
                nextQueue = temp;

                result.add(0, new ArrayList<Integer>(list));
                list.clear();
            }

            TreeNode node = curQueue.poll();
            list.add(node.val);

            if (node.left != null) {
                nextQueue.add(node.left);
            }

            if (node.right != null) {
                nextQueue.add(node.right);
            }
        }

        if (!list.isEmpty()) {
            result.add(0, list);
        }

        return result;
    }
}
