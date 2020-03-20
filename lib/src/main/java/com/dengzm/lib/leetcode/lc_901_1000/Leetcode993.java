package com.dengzm.lib.leetcode.lc_901_1000;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的堂兄弟节点
 * @date 2020/3/20 12:04
 */
public class Leetcode993 {
    int xpar, xdep, ypar, ydep;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, 1, x, y, root.val);
        dfs(root.right, 1, x, y, root.val);
        return (xpar != ypar) && (xdep == ydep);
    }

    public void dfs(TreeNode node, int dep, int x, int y, int par) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xpar = par;
            xdep = dep;
        } else if (node.val == y) {
            ypar = par;
            ydep = dep;
        } else {
            dfs(node.left, dep+1, x, y, node.val);
            dfs(node.right, dep+1, x, y, node.val);
        }
    }






    public boolean isCousins1(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(root.val, -1);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                map.put(node.val, depth);
                if (node.left != null) {
                    queue.add(node.left);
                    parent.put(node.left.val, node.val);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    parent.put(node.right.val, node.val);
                }

                size --;
            }

            depth ++;
        }

        return map.get(x) == map.get(y) && parent.get(x) != parent.get(y);
    }
}
