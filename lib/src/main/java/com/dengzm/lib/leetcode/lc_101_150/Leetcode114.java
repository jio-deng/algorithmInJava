package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树展开为链表
 * @date 2020/2/6 11:27
 */
public class Leetcode114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                node = node.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = node.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = node.right;
                node.right = node.left;
                node.left = null;
            }
        }
    }
//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        if (root.right != null) {
//            stack.push(root.right);
//            root.right = null;
//        }
//
//        if (root.left != null) {
//            stack.push(root.left);
//            root.left = null;
//        }
//
//        TreeNode node = root;
//        while (!stack.isEmpty()) {
//            TreeNode temp = stack.pop();
//            if (temp.right != null) {
//                stack.push(temp.right);
//                temp.right = null;
//            }
//
//            if (temp.left != null) {
//                stack.push(temp.left);
//                temp.left = null;
//            }
//
//            node.right = temp;
//            node = node.right;
//        }
//    }
}
