package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 剑指 Offer 32 - I. 从上到下打印二叉树
 *              剑指 Offer 32 - II. 从上到下打印二叉树 II
 *              剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @date 2020/6/15 12:30
 */
public class Ms032 {
    public int[] levelOrder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                res.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                size --;
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i ++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                size --;
            }

            res.add(list);
        }

        return res;
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        boolean isLeft = false;

        if (root != null) {
            queue1.add(root);
        }

        while (!queue1.isEmpty()) {
            int size = queue1.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue1.pollLast();
                list.add(node.val);

                if (isLeft) {
                    if (node.left != null) {
                        queue2.add(node.left);
                    }

                    if (node.right != null) {
                        queue2.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        queue2.add(node.right);
                    }

                    if (node.left != null) {
                        queue2.add(node.left);
                    }
                }

                size --;
            }

            queue1 = queue2;
            queue2 = new LinkedList<>();
            isLeft = !isLeft;
            res.add(list);
        }

        return res;
    }
}
