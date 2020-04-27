package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 04.05. 合法二叉搜索树
 * @date 2020/4/25 15:25
 */
public class Ms0405 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        midFs(list, root);

        int pre = list.get(0);
        for (int i = 1; i < list.size(); i ++) {
            if (pre >= list.get(i)) {
                return false;
            }

            pre = list.get(i);
        }

        return true;
    }

    private void midFs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        midFs(list, node.left);
        list.add(node.val);
        midFs(list, node.right);
    }
}
