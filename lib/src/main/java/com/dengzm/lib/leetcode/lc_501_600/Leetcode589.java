package com.dengzm.lib.leetcode.lc_501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description N叉树的前序遍历
 * @date 2020/2/23 18:29
 */
public class Leetcode589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        firstSearch(root, ans);
        return ans;
    }

    private void firstSearch(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        for (Node n : root.children) {
            firstSearch(n, list);
        }
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
