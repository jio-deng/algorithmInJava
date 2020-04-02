package com.dengzm.lib.leetcode.lc_101_200;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉搜索树迭代器
 * @date 2020/4/2 13:56
 */
public class Leetcode173 {
    class BSTIterator {
        int curIndex = 0;
        List<Integer> list = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            list.clear();
            curIndex = 0;
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return list.get(curIndex ++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return curIndex < list.size();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
