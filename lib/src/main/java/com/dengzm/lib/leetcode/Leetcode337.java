package com.dengzm.lib.leetcode;

import java.util.HashMap;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 打家劫舍 III
 * @date 2020/1/12 20:02
 */
public class Leetcode337 {
    private HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        memo.clear();

        return robCore(root);
    }

    private int robCore(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int do_it = node.val + (node.left == null ? 0 : robCore(node.left.left) + robCore(node.left.right))
                + (node.right == null ? 0 : robCore(node.right.left) + robCore(node.right.right));

        int not_do_it = robCore(node.left) + robCore(node.right);

        int result = Math.max(do_it, not_do_it);
        memo.put(node, result);
        return result;
    }


    /*-------------------better one----------------*/
    // 三种方法解决树形动态规划问题-从入门级代码到高效树形动态规划代码实现 https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
}
