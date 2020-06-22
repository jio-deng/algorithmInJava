package com.dengzm.lib.leetcode.lc_1001_1100;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 从先序遍历还原二叉树
 * @date 2020/6/18 15:35
 */
public class Leetcode1028 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<A> stack = new ArrayDeque<>();
        int count = 0;
        int num = 0;

        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);
            if (c == '-') {
                if (num != 0) {
                    TreeNode node = new TreeNode(num);
                    A a = new A(node, count);

                    while (!stack.isEmpty()) {
                        A pre = stack.peek();
                        if (pre.depth >= a.depth) {
                            stack.pop();
                        } else {
                            if (pre.node.left == null) {
                                pre.node.left = a.node;
                            } else {
                                pre.node.right = a.node;
                            }

                            break;
                        }
                    }

                    stack.push(a);

                    count = 0;
                    num = 0;
                }

                count ++;
            } else {
                num = num * 10 + c - '0';
            }
        }

        if (num != 0) {
            TreeNode node = new TreeNode(num);
            A a = new A(node, count);

            while (!stack.isEmpty()) {
                A pre = stack.peek();
                if (pre.depth >= a.depth) {
                    stack.pop();
                } else {
                    if (pre.node.left == null) {
                        pre.node.left = a.node;
                    } else {
                        pre.node.right = a.node;
                    }

                    break;
                }
            }

            stack.push(a);
        }

        return stack.peekLast().node;
    }

    public class A {
        public TreeNode node;
        public int depth;

        public A(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
