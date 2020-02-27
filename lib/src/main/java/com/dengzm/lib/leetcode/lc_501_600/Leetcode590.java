package com.dengzm.lib.leetcode.lc_501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description N叉树的后序遍历
 * @date 2020/2/23 18:31
 */
public class Leetcode590 {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        lastSearch(root, ans);
        return ans;
    }

    private void lastSearch(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        for (Node n : root.children) {
            lastSearch(n, list);
        }

        list.add(root.val);
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
