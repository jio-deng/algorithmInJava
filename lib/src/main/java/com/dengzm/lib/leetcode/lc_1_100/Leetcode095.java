package com.dengzm.lib.leetcode.lc_1_100;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 不同的二叉搜索树 II
 * @date 2020/2/1 10:45
 */
public class Leetcode095 {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        return numTreesCore(1, n);
    }

    private ArrayList<TreeNode> numTreesCore(int start, int end) {
        ArrayList<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i ++) {
            ArrayList<TreeNode> left = numTreesCore(start, i - 1);
            ArrayList<TreeNode> right = numTreesCore(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    allTrees.add(node);
                }
            }
        }

        return allTrees;
    }
}
