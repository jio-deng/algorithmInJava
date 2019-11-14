package com.dengzm.lib.jianzhi;

import java.util.ArrayList;

/**
 * @Description 068 树中两个节点的最低公共祖先
 *
 * Created by deng on 2019/11/2.
 */
public class Jianzhi068 {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        node1.setNodes(node2, node3);
        node2.setNodes(node4, node5);
        node4.setNodes(node6, node7);
        node5.setNodes(node8, node9);

        System.out.println(getLastCommonParent(node1, node6, node9).value);
        System.out.println(getLastCommonParent2(node1, node6, node9).value);
    }

    /**
     * 解法一：得到两个节点的路径，将问题转化为求两个链表的第一个公共节点
     *
     * @param root root
     * @param node1 node1
     * @param node2 node2
     * @return first common parent node
     */
    private static BinaryTreeNode getLastCommonParent(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        ArrayList<BinaryTreeNode> path1 = new ArrayList<>();
        getNodePath(root, node1, path1);

        ArrayList<BinaryTreeNode> path2 = new ArrayList<>();
        getNodePath(root, node2, path2);

        return getLastCommonNode(path1, path2);
    }

    /**
     * 求节点路径
     *
     * @param root root
     * @param node node
     * @param path path
     * @return is found
     */
    private static boolean getNodePath(BinaryTreeNode root, BinaryTreeNode node, ArrayList<BinaryTreeNode> path) {
        if (root == null) {
            return false;
        }

        if (root == node) {
            return true;
        }

        path.add(root);

        boolean found = getNodePath(root.left, node, path);

        if (!found) {
            found = getNodePath(root.right, node, path);
        }

        if (!found) {
            path.remove(path.size() - 1);
        }

        return found;
    }

    /**
     * 找到两个list的最后一个相同节点
     *
     * @param path1 path1
     * @param path2 path2
     * @return last common node
     */
    private static BinaryTreeNode getLastCommonNode(ArrayList<BinaryTreeNode> path1, ArrayList<BinaryTreeNode> path2) {
        if (path1 == null || path2 == null || path1.size() == 0 || path2.size() == 0) {
            return null;
        }

        BinaryTreeNode last = null;
        int curIndex = 0;

        while (curIndex < path1.size() && curIndex < path2.size()) {
            if (path1.get(curIndex) == path2.get(curIndex)) {
                last = path1.get(curIndex);
            }

            curIndex ++;
        }

        return last;
    }

    /**
     * 解法二：利用递归的方式
     *
     * @param root root
     * @param node1 node1
     * @param node2 node2
     * @return first common parent node
     */
    private static BinaryTreeNode getLastCommonParent2(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        BinaryTreeNode left = getLastCommonParent2(root.left, node1, node2);
        BinaryTreeNode right = getLastCommonParent2(root.right, node1, node2);

        // 如果有子节点返回null，则两个节点在同一个子树下
        // 若都不为null，则当前节点即为最低公共节点
        return left == null ? right : right == null ? left : root;
    }
}
