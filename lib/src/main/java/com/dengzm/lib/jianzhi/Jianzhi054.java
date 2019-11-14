package com.dengzm.lib.jianzhi;

/**
 * @Description 054 二叉搜索树的第k大节点
 *
 * Created by deng on 2019/10/29.
 */
public class Jianzhi054 {
    private static int index = 0;

    public static void main(String[] args) {
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);

        node5.setNodes(node3, node7);
        node3.setNodes(node2, node4);
        node7.setNodes(node6, node8);

        System.out.println("The 6th Big Number is " + getKthNumberInBinaryTree(node5, 6).value);
    }

    /**
     * 对二叉树进行中序遍历，得到的即为升序，即可得到第K大的数字
     *
     * @param root root
     * @return Kth num
     */
    private static BinaryTreeNode getKthNumberInBinaryTree(BinaryTreeNode root, int k) {
        if (root == null || k < 1) {
            return null;
        }

        index = 0;

        return getKthNumCore(root, k);
    }

    private static BinaryTreeNode getKthNumCore(BinaryTreeNode root, int k) {
        if (root == null) {
            return null;
        }

        BinaryTreeNode temp = null;

        // 如果有左子数，先遍历
        if (root.left != null) {
            temp = getKthNumCore(root.left, k);
        }

        // temp为null，代表此时遍历左子树后，未获得第K大的节点
        // 此时，第一步，计算当前节点自身添加后是否满足
        // 第二步，在自身不满足的情况下，遍历右子树
        if (temp == null) {
            index ++;
            if (index == k) {
                return root;
            }

            if (root.right != null) {
                temp = getKthNumCore(root.right, k);
            }
        }

        return temp;
    }

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int value) {
            this.value = value;
        }

        void setNodes(BinaryTreeNode left, BinaryTreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
}
