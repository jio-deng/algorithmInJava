package com.dengzm.lib.leetcode.lc_101_200;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 复制带随机指针的链表
 * @date 2020/2/13 19:22
 */
public class Leetcode138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        return copyRandomListCore(head, map);
    }

    private Node copyRandomListCore(Node head, HashMap<Node, Node> map) {
        if (head == null) {
            return null;
        }

        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node node = map.getOrDefault(head, new Node(head.val));
        map.put(head, node);

        node.next = copyRandomListCore(head.next, map);
        node.random = copyRandomListCore(head.random, map);

        return node;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
