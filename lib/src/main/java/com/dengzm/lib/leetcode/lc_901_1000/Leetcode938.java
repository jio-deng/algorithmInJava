package com.dengzm.lib.leetcode.lc_901_1000;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉搜索树的范围和
 * @date 2020/3/17 9:28
 */
public class Leetcode938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> list = new ArrayList<>();
        midBST(list, root);

        int ans = 0;
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) > R) {
                break;
            } else if (list.get(i) >= L) {
                ans += list.get(i);
            }
        }

        return ans;
    }

    private void midBST(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        midBST(list, root.left);
        list.add(root.val);
        midBST(list, root.right);
    }
}
