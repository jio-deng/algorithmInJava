package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的层次遍历
 * @date 2020/2/1 10:26
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        cur.add(root);
        List<Integer> list = new ArrayList<>();
        while (!cur.isEmpty() || !next.isEmpty()) {
            if (cur.isEmpty()) {
                LinkedList<TreeNode> temp = cur;
                cur = next;
                next = temp;
                result.add(new ArrayList<>(list));
                list.clear();
            }

            TreeNode node = cur.pop();
            list.add(node.val);
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
        }

        if (!list.isEmpty()) {
            result.add(list);
        }

        return result;
    }
}
