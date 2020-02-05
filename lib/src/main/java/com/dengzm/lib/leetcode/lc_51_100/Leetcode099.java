package com.dengzm.lib.leetcode.lc_51_100;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 恢复二叉搜索树
 * @date 2020/2/5 10:48
 */
public class Leetcode099 {
    /**
     * morris遍历的实现原则
     * 来到当前节点，记为cur（引用）
     * 1、如果cur无左孩子，cur向右移动（cur = cur.right）
     * 2、如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
     *     （1）如果mostright的right指针指向空，让其指向cur，cur向左移动（cur = cur.left）
     *     （2）如果mostright的right指针指向cur，让其指向空，cur向右移动（cur = cur.right）
     *
     *
     * 原文链接：https://blog.csdn.net/qq_38180223/article/details/81697535
     *
     * @param root
     */
    public static void recoverTree(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode node1 = null;
        TreeNode node2 = null;

        TreeNode mostRight = null;
        TreeNode cur = root;

        TreeNode pre = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {  // 第二次遍历到了
                    mostRight.right = null;
                }
            }

            // 题目中要找的错点
            if (pre != null && pre.val > cur.val) {
                node1 = node1 == null ? pre : node1;
                node2 = cur;
            }

            pre = cur;
            cur = cur.right;
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
