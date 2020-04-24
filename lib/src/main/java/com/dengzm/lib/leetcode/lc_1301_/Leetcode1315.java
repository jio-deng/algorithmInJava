package com.dengzm.lib.leetcode.lc_1301_;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 祖父节点值为偶数的节点和
 * @date 2020/4/17 18:55
 */
public class Leetcode1315 {
    private int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        sumEvenGrandparentCore(root, 0);
        return ans;
    }

    private void sumEvenGrandparentCore(TreeNode root, int flag) {
        if (root == null) {
            return;
        }

        if (flag == 1) {
            ans += root.left == null ? 0 : root.left.val;
            ans += root.right == null ? 0 : root.right.val;
        }

        flag = root.val % 2 == 0 ? 1 : 0;
        sumEvenGrandparentCore(root.left, flag);
        sumEvenGrandparentCore(root.right, flag);
    }
}
