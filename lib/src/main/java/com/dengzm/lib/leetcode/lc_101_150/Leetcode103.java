package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的锯齿形层次遍历
 * @date 2020/2/3 12:27
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> curStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();

        curStack.add(root);

        List<Integer> list = new ArrayList<>();
        boolean addLeftFirst = true;
        while (!curStack.isEmpty() || !nextStack.isEmpty()) {
            if (curStack.isEmpty()) {
                Stack<TreeNode> temp = curStack;
                curStack = nextStack;
                nextStack = temp;

                result.add(new ArrayList<>(list));
                list.clear();

                addLeftFirst = !addLeftFirst;
            }

            TreeNode node = curStack.pop();
            list.add(node.val);

            if (addLeftFirst) {
                if (node.left != null) {
                    nextStack.push(node.left);
                }

                if (node.right != null) {
                    nextStack.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextStack.push(node.right);
                }

                if (node.left != null) {
                    nextStack.push(node.left);
                }
            }
        }

        if (!list.isEmpty()) {
            result.add(list);
        }

        return result;
    }
}
