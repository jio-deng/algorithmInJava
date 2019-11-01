package com.dengzm.lib;

/**
 * @Description 027 二叉树的镜像
 * 请完成一个函数，输入一颗二叉树，该函数输出它的镜像。
 *
 * Created by deng on 2019/5/1.
 */
public class Jianzhi027 {
    public static void main(String[] args) {
        BinaryTreeNode head1 = new BinaryTreeNode(1);

        BinaryTreeNode temp1 = new BinaryTreeNode(2);
        BinaryTreeNode temp2 = new BinaryTreeNode(2);
        BinaryTreeNode temp3 = new BinaryTreeNode(2);
        BinaryTreeNode temp4 = new BinaryTreeNode(2);
        BinaryTreeNode temp5 = new BinaryTreeNode(2);
        BinaryTreeNode temp6 = new BinaryTreeNode(2);
        BinaryTreeNode temp66 = new BinaryTreeNode(3);

        head1.pLeft = temp1;
        head1.pRight = temp2;
        temp1.pLeft = temp3;
        temp1.pRight = temp4;
        temp3.pLeft = temp5;
        temp3.pRight = temp6;
        temp6.pRight = temp66;

        mirrorBinaryTree(head1);
    }

    private static void mirrorBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        if (root.pLeft == null && root.pRight == null) {
            return;
        }

        BinaryTreeNode temp = root.pLeft;
        root.pLeft = root.pRight;
        root.pRight = temp;

        mirrorBinaryTree(root.pLeft);
        mirrorBinaryTree(root.pRight);
    }


    static class BinaryTreeNode {
        BinaryTreeNode pLeft;
        BinaryTreeNode pRight;
        int value;

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}
