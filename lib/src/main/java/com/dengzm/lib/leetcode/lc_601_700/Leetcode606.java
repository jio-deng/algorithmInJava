package com.dengzm.lib.leetcode.lc_601_700;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 根据二叉树创建字符串
 * @date 2020/2/25 9:28
 */
public class Leetcode606 {
    public String tree2str(TreeNode t) {
        return tree2strCore(t);
    }

    private String tree2strCore(TreeNode t) {
        if (t == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        if (t.left == null && t.right == null) {
            return sb.toString();
        } else if (t.left == null) {
            sb.append("(").append(")").append("(").append(tree2strCore(t.right)).append(")");
        } else if (t.right == null) {
            sb.append("(").append(tree2strCore(t.left)).append(")");
        } else {
            sb.append("(").append(tree2strCore(t.left)).append(")").append("(").append(tree2strCore(t.right)).append(")");
        }

        return sb.toString();
    }
}
