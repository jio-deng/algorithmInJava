package com.dengzm.lib.jianzhi;

import java.util.ArrayDeque;

/**
 * @Description 032 从上到下打印二叉树
 * 从上到下打印二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 *
 * Created by deng on 2019/5/23.
 */
public class Jianzhi032 {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        printFromTopToBottom(node1);
    }

    private static void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.pop();
            printTreeNode(node);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private static void printTreeNode(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value);
    }
}
