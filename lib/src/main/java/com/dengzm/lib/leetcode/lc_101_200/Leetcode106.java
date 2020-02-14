package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 从中序与后序遍历序列构造二叉树
 * @date 2020/2/3 12:54
 */
public class Leetcode106 {
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0 || inorder == null || postorder.length != inorder.length) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }

        return buildTreeCore(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }

        int val = preorder[pEnd];
        TreeNode root = new TreeNode(val);
        if (pStart == pEnd) {
            return root;
        }

        int i = map.get(val);

        int leftLength = i - iStart;
        root.left = buildTreeCore(preorder, pStart, pStart + leftLength - 1, inorder, iStart, i - 1);
        root.right = buildTreeCore(preorder, pStart + leftLength, pEnd - 1, inorder, i + 1, iEnd);

        return root;
    }
}
