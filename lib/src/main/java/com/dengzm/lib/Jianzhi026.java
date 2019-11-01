package com.dengzm.lib;

/**
 * @Description 026 树的子结构
 * 输入两颗二叉树A和B，判断B是不是A的子结构。
 *
 * Created by deng on 2019/5/1.
 */
public class Jianzhi026 {
    public static void main(String[] args) {
        BinaryTreeNode head1 = new BinaryTreeNode(1.3);
        BinaryTreeNode head2 = new BinaryTreeNode(1.3);

        BinaryTreeNode temp1 = new BinaryTreeNode(1.3);
        BinaryTreeNode temp2 = new BinaryTreeNode(1.5);
        BinaryTreeNode temp3 = new BinaryTreeNode(1.6);
        BinaryTreeNode temp4 = new BinaryTreeNode(1.7);
        BinaryTreeNode temp5 = new BinaryTreeNode(1.8);
        BinaryTreeNode temp6 = new BinaryTreeNode(1.9);
        BinaryTreeNode temp66 = new BinaryTreeNode(2.4);

        BinaryTreeNode temp7 = new BinaryTreeNode(1.6);
        BinaryTreeNode temp8 = new BinaryTreeNode(1.8);
        BinaryTreeNode temp9 = new BinaryTreeNode(1.9);
        BinaryTreeNode temp10 = new BinaryTreeNode(2.4);

        head1.pLeft = temp1;
        head1.pRight = temp2;
        temp1.pLeft = temp3;
        temp1.pRight = temp4;
        temp3.pLeft = temp5;
        temp3.pRight = temp6;
        temp6.pRight = temp66;

        head2.pLeft = temp7;
        temp7.pLeft = temp8;
        temp7.pRight = temp9;
        temp9.pRight = temp10;


        boolean result = hasSubTree(head1, head2);
        System.out.println("MainRoot has SubRoot ? Result is " + result + ".");
    }

    private static boolean hasSubTree(BinaryTreeNode rootMain, BinaryTreeNode rootSub) {
        boolean result = false;

        if (rootMain != null && rootSub != null) {
            if (rootMain.value == rootSub.value) {
                // 判断是否是子结构
                result = isSubTree(rootMain, rootSub);
            }
            // 若不是，则遍历左右子树
            if (!result) {
                result = hasSubTree(rootMain.pLeft, rootSub);
            }
            if (!result) {
                result = hasSubTree(rootMain.pRight, rootSub);
            }

        }

        return result;
    }

    /**
     * 根结点相同，判断rootMain是否包含rootSub
     *
     * @param rootMain MainRoot
     * @param rootSub SubRoot
     * @return is sub tree
     */
    private static boolean isSubTree(BinaryTreeNode rootMain, BinaryTreeNode rootSub) {
        boolean result = true;
        // rootSub为null，则已遍历完，跳出
        if (rootSub != null) {
            result = rootMain != null && rootMain.value == rootSub.value;

            if (result) {
                result = isSubTree(rootMain.pLeft, rootSub.pLeft);
            }
            if (result) {
                result = isSubTree(rootMain.pRight, rootSub.pRight);
            }
        }

        return result;
    }

    static class BinaryTreeNode {
        BinaryTreeNode pLeft;
        BinaryTreeNode pRight;
        double value;

        BinaryTreeNode(double value) {
            this.value = value;
        }
    }
}
