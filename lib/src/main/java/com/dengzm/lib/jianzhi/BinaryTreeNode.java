package com.dengzm.lib.jianzhi;

/**
 * @Description Node of Binary Tree
 *
 * Created by deng on 2019/10/29.
 */
public class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int value) {
        this.value = value;
    }

    public void setNodes(BinaryTreeNode left, BinaryTreeNode right) {
        this.left = left;
        this.right = right;
    }
}
