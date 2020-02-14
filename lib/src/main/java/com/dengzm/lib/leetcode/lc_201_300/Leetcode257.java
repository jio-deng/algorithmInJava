package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的所有路径
 * @date 2020/2/14 11:02
 */
public class Leetcode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        binaryTreePathsCore(root, null, list);
        return list;
    }

    private void binaryTreePathsCore(TreeNode root, String path, List<String> list) {
        if (path == null) {
            path = root.val + "";
        } else {
            path += "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            list.add(path);
        } else {
            if (root.left != null) {
                binaryTreePathsCore(root.left, path, list);
            }

            if (root.right != null) {
                binaryTreePathsCore(root.right, path, list);
            }
        }
    }
}
