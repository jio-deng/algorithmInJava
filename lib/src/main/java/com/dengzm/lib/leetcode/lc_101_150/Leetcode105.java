package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 从前序与中序遍历序列构造二叉树
 * @date 2020/2/3 12:41
 */
public class Leetcode105 {
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }

        return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }

        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);
        if (pStart == pEnd) {
            return root;
        }

        int i = map.get(val);
//        for (i = iStart; i <= iEnd; i ++) {
//            if (inorder[i] == val) {
//                break;
//            }
//        }

        int leftLength = i - iStart;
        root.left = buildTreeCore(preorder, pStart + 1, pStart + leftLength, inorder, iStart, i - 1);
        root.right = buildTreeCore(preorder, pStart + leftLength + 1, pEnd, inorder, i + 1, iEnd);

        return root;
    }
}
