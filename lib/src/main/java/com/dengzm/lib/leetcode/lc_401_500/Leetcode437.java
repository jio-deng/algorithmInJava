package com.dengzm.lib.leetcode.lc_401_500;

import com.dengzm.lib.leetcode.lc.TreeNode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 路径总和 III
 * @date 2020/2/15 18:36
 */
public class Leetcode437 {
    public int pathSum(TreeNode root, int sum) {
        int[] array = new int[1000];
        return pathSumCore(root, sum, array, 0);
    }

    private int pathSumCore(TreeNode root, int sum, int[] array, int p) {
        if (root == null) {
            return 0;
        }

        int temp = root.val;
        int n = temp == sum ? 1 : 0;

        for (int i = p - 1; i >= 0; i --) {
            temp += array[i];
            if (temp == sum) {
                n ++;
            }
        }

        array[p] = root.val;
        int n1 = pathSumCore(root.left, sum, array, p+1);
        int n2 = pathSumCore(root.right, sum, array, p+1);
        // System.out.println(n + " " + n1 + " " + n2);

        return n + n1 + n2;
    }
}
