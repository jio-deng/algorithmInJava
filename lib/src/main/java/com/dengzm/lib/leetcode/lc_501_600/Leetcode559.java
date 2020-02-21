package com.dengzm.lib.leetcode.lc_501_600;

import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description N叉树的最大深度
 * @date 2020/2/21 17:26
 */
public class Leetcode559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }

        return max + 1;
    }

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
