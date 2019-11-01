package com.dengzm.lib;

/**
 * @Description 007 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历，重建该二叉树。（假设二叉树中不含有重复的数字）
 * Created by deng on 2018/12/19.
 */
public class Jianzhi007 {

    public static void main(String[] args) {
        int[] pre = new int[] {1,2,4,7,3,5,6,8};
        int[] middle = new int[] {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = rebuildTree(pre, middle);
        printTree(root);
    }

    //判空
    //前序遍历中第一位为root节点，找到后寻找中序中该节点的位置；递归计算对应左右位置（49-57行）
    public static BinaryTreeNode rebuildTree(int[] first, int[] middle) {
        if (first == null || first.length == 0 || middle == null || middle.length == 0 || first.length != middle.length) {
            return null;
        }

        return rebuildTreeCore(first, middle, 0, first.length - 1, 0, middle.length - 1);
    }

    private static BinaryTreeNode rebuildTreeCore(int[] first, int[] middle, int preOrderStart, int preOrderEnd,
                                                 int inOrderStart, int inOrderEnd) {
        int rootValue = first[preOrderStart];
        BinaryTreeNode rootNode = new BinaryTreeNode(rootValue);

        if (preOrderStart == preOrderEnd) {
            if (inOrderStart == inOrderEnd && first[preOrderStart] == middle[inOrderStart]) {
                return rootNode;
            } else {
                throw new RuntimeException("wrong data!");
            }
        }

        int inOrderMiddle = -1;
        for (int i = inOrderStart; i <= inOrderEnd; i ++) {
            if (middle[i] == rootValue) {
                inOrderMiddle = i;
                break;
            }
        }

        if (inOrderMiddle != -1) {
            int count = inOrderMiddle - inOrderStart;
            if (count > 0) {
                rootNode.mLeft = rebuildTreeCore(first, middle, preOrderStart + 1, preOrderStart + count, inOrderStart, inOrderMiddle - 1);

            }
            if (count < preOrderEnd - preOrderStart) {
                rootNode.mRight = rebuildTreeCore(first, middle, preOrderStart + count + 1, preOrderEnd, inOrderMiddle + 1, inOrderEnd);

            }
        } else {
            throw new RuntimeException("wrong data!");
        }

        return rootNode;
    }

    //print tree
    private static void printTree(BinaryTreeNode root) {
        if (root == null) return;
        System.out.println(root.value + ", ");
        printTree(root.mLeft);
        printTree(root.mRight);
    }

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode mLeft;
        BinaryTreeNode mRight;

        BinaryTreeNode(int value) {
            this.value = value;
        }
    }
}
