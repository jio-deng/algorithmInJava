package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description node
 * @date 2020/2/6 11:45
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
