package com.dengzm.lib.leetcode.lc_401_500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description N叉树的层序遍历
 * @date 2020/4/15 12:23
 */
public class Leetcode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                size --;
                list.add(node.val);

                for (Node n : node.children) {
                    queue.add(n);
                }
            }

            ans.add(list);
        }

        return ans;
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
