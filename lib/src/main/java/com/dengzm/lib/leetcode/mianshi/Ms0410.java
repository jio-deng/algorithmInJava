package com.dengzm.lib.leetcode.mianshi;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 04.10. 检查子树
 * @date 2020/4/21 12:39
 */
public class Ms0410 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        get(t1, sb1);
        get(t2, sb2);
        return sb1.toString().contains(sb2.toString());
    }

    private void get(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        get(node.left, sb);
        sb.append("#").append(node.val);
        get(node.right, sb);
    }
}
