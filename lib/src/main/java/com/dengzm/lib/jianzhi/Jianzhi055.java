package com.dengzm.lib.jianzhi;

/**
 * @Description 055 二叉树的深度
 * 题目一：二叉树的深度
 * 题目二：平衡二叉树 判断一棵树是否为平衡二叉树
 *
 * Created by deng on 2019/10/29.
 */
public class Jianzhi055 {
    private static final int ERROR = -1;

    public static void main(String[] args) {
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);

//        BinaryTreeNode node9 = new BinaryTreeNode(9);
//        BinaryTreeNode node10 = new BinaryTreeNode(10);
//        BinaryTreeNode node11 = new BinaryTreeNode(11);

        node5.setNodes(node3, node7);
        node3.setNodes(node2, node4);
        node7.setNodes(node6, node8);

//        node8.setNodes(node9, node10);
//        node10.setNodes(null, node11);

        System.out.println("The depth of tree is " + getDepthOfBinaryTree(node5));
        System.out.println("This tree is balanced ? Answer is " + isTreeBalanced(node5));
    }

    /**
     * 题目一：二叉树的深度
     * 简单的递归，较高的子数的深度+1
     *
     * @param root root node
     * @return depth of tree
     */
    private static int getDepthOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepthOfBinaryTree(root.left);
        int right = getDepthOfBinaryTree(root.right);

        return left > right ? left + 1 : right + 1;
    }

    /**
     * 题目二：平衡二叉树
     * 与深度遍历类似，在遍历子树和返回深度时，增加了是否为平衡树的判断，并将-1作为不平衡的常量值
     *
     *
     * @param root root
     * @return is tree balanced
     */
    private static boolean isTreeBalanced(BinaryTreeNode root) {
        return getDepth(root) != ERROR;
    }

    private static int getDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        if (left == ERROR) {
            return ERROR;
        }

        int right = getDepth(root.right);
        if (right == ERROR) {
            return ERROR;
        }

        return Math.abs(left - right) > 1 ? ERROR : Math.max(left, right) + 1;
    }
}
