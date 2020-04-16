package com.dengzm.lib.leetcode.lc_801_900;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 根据前序和后序遍历构造二叉树
 * @date 2020/4/16 8:37
 */
public class Leetcode889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) {
            return null;
        }

        return constructFromPrePostCore(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode constructFromPrePostCore(int[] pre, int start, int end, int[] post, int start2, int end2) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(pre[start]);
        }

        TreeNode node = new TreeNode(pre[start]);
        int left = pre[start + 1];

        for (int i = start2; i <= end2; i ++) {
            if (post[i] == left) {
                int len = i - start2;
                node.left = constructFromPrePostCore(pre, start + 1, start + len -1, post, start2, i);
                node.right = constructFromPrePostCore(pre, start + len + 1, end, post, i+1, end2 - 1);
            }
        }

        return node;
    }
}
