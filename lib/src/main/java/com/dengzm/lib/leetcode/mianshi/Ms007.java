package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题07. 重建二叉树
 * @date 2020/4/27 12:01
 */
public class Ms007 {
    private int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        return buildTreeCore(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        } else if (pStart == pEnd) {
            return new TreeNode(preorder[pStart]);
        }

        int rVal = preorder[pStart];
        int index = iStart;
        for (;index <= iEnd; index ++) {
            if (inorder[index] == rVal) {
                break;
            }
        }

        System.out.println(pStart + " " + pEnd + " " + iStart + " " + iEnd + " " + index);

        TreeNode node = new TreeNode(rVal);
        node.left = buildTreeCore(pStart + 1, pStart + index - iStart, iStart, index - 1);
        node.right = buildTreeCore(pStart + index - iStart + 1, pEnd, index + 1, iEnd);
        return node;
    }
}
