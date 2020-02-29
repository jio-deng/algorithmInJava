package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两数之和 IV - 输入 BST
 * @date 2020/2/29 9:58
 */
public class Leetcode653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        ArrayList<Integer> list = new ArrayList<>();
        midBianli(root, list);
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                end --;
            } else {
                start ++;
            }
        }

        return false;
    }

    private void midBianli(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        midBianli(root.left, list);
        list.add(root.val);
        midBianli(root.right, list);
    }
}
