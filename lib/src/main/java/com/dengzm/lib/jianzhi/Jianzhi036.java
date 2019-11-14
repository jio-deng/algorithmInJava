package com.dengzm.lib.jianzhi;

/**
 * @Description 036 二叉搜索树与双向链表
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 *
 * Created by deng on 2019/5/25.
 */
public class Jianzhi036 {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(14);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(12);
        BinaryTreeNode node7 = new BinaryTreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        ListNode head1 = convert(node1, true);
        while (head1 != null) {
            System.out.print(head1.value + "  ");
            head1 = head1.next;
        }

        System.out.println();

        ListNode head2 = convert(node1, false);
        while (head2 != null) {
            System.out.print(head2.value + "  ");
            head2 = head2.pre;
        }
    }

    private static ListNode convert(BinaryTreeNode root, boolean returnStart) {
        if (root == null) {
            return null;
        }

        ListNode rootNode = new ListNode(root.value);

        if (root.left != null) {
            ListNode left = convert(root.left, false);
            left.next = rootNode;
            rootNode.pre = left;
        }

        if (root.right != null) {
            ListNode right = convert(root.right, true);
            right.pre = rootNode;
            rootNode.next = right;
        }

        if (returnStart) {
            while (rootNode.pre != null) {
                rootNode = rootNode.pre;
            }
        } else {
            while (rootNode.next != null) {
                rootNode = rootNode.next;
            }
        }

        return rootNode;
    }

    private static class ListNode {
        int value;
        ListNode pre;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
