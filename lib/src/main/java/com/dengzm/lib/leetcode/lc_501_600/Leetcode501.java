package com.dengzm.lib.leetcode.lc_501_600;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉搜索树中的众数
 * @date 2020/2/21 13:55
 */
public class Leetcode501 {
    int curTimes = 0;
    int maxTimes = 0;
    List<Integer> res;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        inOrder(root);

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i ++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        curTimes = pre != null && root.val == pre.val ? curTimes + 1 : 1;

        if (curTimes == maxTimes) {
            res.add(root.val);
        } else if (curTimes > maxTimes) {
            res.clear();
            res.add(root.val);
            maxTimes = curTimes;
        }

        pre = root;

        inOrder(root.right);
    }
}
