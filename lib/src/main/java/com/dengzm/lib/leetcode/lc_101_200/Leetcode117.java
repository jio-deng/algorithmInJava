package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.Node;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 填充每个节点的下一个右侧节点指针 II
 * @date 2020/2/6 11:45
 */
public class Leetcode117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node temp;
        if (root.left != null) {
            temp = root.left;

            if (root.right != null) {
                root.left.next = root.right;
                temp = root.right;
            }
        } else {
            temp = root.right;
        }

        if (temp != null) {
            Node rootNext = root.next;
            while (rootNext != null) {
                if (rootNext.left != null) {
                    temp.next = rootNext.left;
                    break;
                } else if (rootNext.right != null) {
                    temp.next = rootNext.right;
                    break;
                }

                rootNext = rootNext.next;
            }
        }

        connect(root.right);
        connect(root.left);

        return root;
    }
}
