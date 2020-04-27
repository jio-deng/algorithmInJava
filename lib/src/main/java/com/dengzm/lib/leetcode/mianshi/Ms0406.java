package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 04.06. 后继者
 * @date 2020/4/25 15:31
 */
public class Ms0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<Integer> list = new ArrayList<>();
        midFs(list, root);

        int target = -1;
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) == p.val && i != list.size() - 1) {
                target = list.get(i+1);
            }
        }

        if (target == -1) {
            return null;
        }

        return find(root, target);
    }

    private TreeNode find(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return node;
        } else if (node.val > val) {
            return find(node.left, val);
        } else {
            return find(node.right, val);
        }
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
