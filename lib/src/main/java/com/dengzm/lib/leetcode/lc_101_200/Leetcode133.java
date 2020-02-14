package com.dengzm.lib.leetcode.lc_101_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 克隆图
 * Created by deng on 2020/2/8.
 */
public class Leetcode133 {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<Node, Node>());
    }

    private Node dfs(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, map));
        }

        return clone;
    }

    private Node bfs(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val);
        map.put(node, clone);

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node n : curNode.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    queue.add(n);
                }

                map.get(curNode).neighbors.add(map.get(n));
            }
        }

        return clone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
