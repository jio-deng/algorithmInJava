package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.Node;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 填充每个节点的下一个右侧节点指针
 * @date 2020/2/6 11:44
 */
public class Leetcode116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}
