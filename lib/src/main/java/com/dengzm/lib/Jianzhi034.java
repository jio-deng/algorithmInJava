package com.dengzm.lib;

import java.util.Stack;

/**
 * @Description 034 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 *
 * Created by deng on 2019/5/25.
 */
public class Jianzhi034 {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        findPath(node1, 22);
    }

    /**
     * 深度遍历的方式，找到所有符合结果的路径
     *
     * @param root root Node
     * @param expectValue 符合该值的路径
     */
    private static void findPath(BinaryTreeNode root, int expectValue) {
        if (root == null) {
            return;
        }

        Stack<Integer> path = new Stack<>();
        int current = 0;
        findPathCore(root, path, current, expectValue);
    }

    private static void findPathCore(BinaryTreeNode root, Stack<Integer> path, int currentValue, int expectValue) {
        path.push(root.value);
        currentValue += root.value;

        // 值相等，且为一条完整路径（root到leaf）
        if (currentValue == expectValue) {
            boolean isLeaf = root.left == null && root.right == null;
            if (isLeaf) {
                System.out.print("Find a path : ");
                for (Integer value : path) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }

        if (root.left != null) {
            findPathCore(root.left, path, currentValue, expectValue);
        }

        if (root.right != null) {
            findPathCore(root.right, path, currentValue, expectValue);
        }

        // 在返回前，删除当前节点
        path.pop();
    }
}
