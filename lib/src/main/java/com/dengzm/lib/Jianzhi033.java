package com.dengzm.lib;

/**
 * @Description 033 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断数组是不是某二叉搜索树的后序遍历结果
 *
 * Created by deng on 2019/5/23.
 */
public class Jianzhi033 {
    public static void main(String[] args) {
        int[] squeue1 = new int[] {5,7,6,9,11,10,8};
        int[] squeue2 = new int[] {5,7,6,9,11,10,8};
        int[] squeue3 = new int[] {5,7,12,9,11,10,8};
        int[] squeue4 = new int[] {12,7,6,9,11,10,8};
        System.out.println(verifySqueceOfBST(squeue1, 0, squeue1.length - 1));
        System.out.println(verifySqueceOfBST(squeue2, 0, squeue2.length - 1));
        System.out.println(verifySqueceOfBST(squeue3, 0, squeue3.length - 1));
        System.out.println(verifySqueceOfBST(squeue4, 0, squeue4.length - 1));
    }

    private static boolean verifySqueceOfBST(int[] sequeue, int start, int end) {
        if (sequeue == null || sequeue.length == 0 || end < start) {
            return false;
        }

        int root = sequeue[end];

        // 在二叉搜索树中左子树的节点的值小于根节点的值
        int i = start;
        for (; i < end - start; i ++) {
            if (sequeue[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < end - start; j ++) {
            if (sequeue[j] < root) {
                return false;
            }
        }

        boolean left = true;

        if (i > start) {
            left = verifySqueceOfBST(sequeue, start, i - 1);
        }

        boolean right = true;

        if (i < end) {
            right = verifySqueceOfBST(sequeue, i, end - 1);
        }

        return left && right;
    }
}
