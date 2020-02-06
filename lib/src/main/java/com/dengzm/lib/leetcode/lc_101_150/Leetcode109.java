package com.dengzm.lib.leetcode.lc_101_150;

import com.dengzm.lib.leetcode.lc.ListNode;
import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.ArrayList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有序链表转换二叉搜索树
 * @date 2020/2/6 9:53
 */
public class Leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            nums[i] = list.get(i);
        }

        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTCore(nums, start, mid - 1);
        node.right = sortedArrayToBSTCore(nums, mid + 1, end);

        return node;
    }
}
