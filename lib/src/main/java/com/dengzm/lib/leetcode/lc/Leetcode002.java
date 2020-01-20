package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 两数相加
 * @date 2019/12/10 11:24
 */
public class Leetcode002 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    /**
     * When im writing this, I remembered this is the last question when i was interviewed in Xiaomi. Haha.
     * link form : https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
     * @param l1 number1
     * @param l2 number2
     * @return add result
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode number1 = l1;
        ListNode number2 = l2;
        ListNode result = null;
        ListNode temp = null;

        int tens = 0;
        boolean isNumber1Null = false;
        boolean isNumber2Null = false;
        while (number1 != null || number2 != null || tens != 0) {
            if (!isNumber1Null && number1 == null) {
                isNumber1Null = true;
            }
            if (!isNumber2Null && number2 == null) {
                isNumber2Null = true;
            }
            int sum = (!isNumber1Null ? number1.val : 0) + (!isNumber2Null ? number2.val : 0) + tens;
            tens = sum / 10;
            sum = sum % 10;

            if (result == null) {
                temp = new ListNode(sum);
                result = temp;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }

            if (!isNumber1Null) {
                number1 = number1.next;
            }

            if (!isNumber2Null) {
                number2 = number2.next;
            }
        }

        return result;
    }

    /*执行结果：通过
      显示详情
      执行用时 :2 ms, 在所有 java 提交中击败了99.97%的用户
      内存消耗 :44.1 MB, 在所有 java 提交中击败了87.24%的用户*/
}
