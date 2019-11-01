package com.dengzm.lib;

/**
 * @Description 028 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。如果一颗二叉树和它的镜像一样，那么它是对称的。
 *
 * Created by deng on 2019/5/1.
 */
public class Jianzhi028 {

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
        head1.pRight = temp1;

        boolean result1 = isMirror(head1);

        temp1.pLeft = temp3;
        temp1.pRight = temp4;
        temp3.pLeft = temp5;
        temp3.pRight = temp6;
        temp6.pRight = temp66;

        boolean result2 = isMirror(head1);

        System.out.println("Result1 = " + result1 + ", Result2 = " + result2);
    }

    private static boolean isMirror(BinaryTreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value == root2.value &&
                isMirror(root1.pLeft, root2.pRight) &&
                isMirror(root1.pRight, root2.pLeft);
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
