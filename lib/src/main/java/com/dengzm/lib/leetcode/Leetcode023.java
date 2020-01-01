package com.dengzm.lib.leetcode;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 合并k个排序链表
 * @date 2020/1/1 8:48
 */
public class Leetcode023 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int len = lists.length;
        int internal = 1;

        while (internal < len) {
            for (int i = 0; i < len - internal; i += internal * 2) {
                lists[i] = merge2List(lists[i], lists[i + internal]);
            }

            internal *= 2;
        }

        return lists[0];
    }

    public ListNode merge2List(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }

        dummy.next = list1 != null ? list1 : list2;

        return result.next;
    }

    /*执行结果：通过
      显示详情
      执行用时 :2 ms, 在所有 java 提交中击败了100.00%的用户
      内存消耗 :40.4 MB, 在所有 java 提交中击败了84.36%的用户*/

}
