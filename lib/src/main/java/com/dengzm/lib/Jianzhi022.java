package com.dengzm.lib;

/**
 * @Description 链表中倒数第k个节点
 * Created by deng on 2019/1/6.
 */
public class Jianzhi022 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp1 = new Node(2);
        Node temp2 = new Node(3);
        Node temp3 = new Node(4);
        Node temp4 = new Node(5);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        findLastKNode(head, 6);
        findLastKNode(head, 3);
        findLastKNode(head, 1);
    }

    private static void findLastKNode(Node head, int k) {
        if (head == null || k < 1) {
            return;
        }
        // 两个指针，first先走k步，然后一起移动；当first到达尾部时，second即为倒数第k个。
        // 需要注意的是，第一个指针向后移动k次，会不会超过链表长度？
        Node first = head;
        Node second = head;

        if (k != 1) {
            for (int i = 0; i < k - 1; i ++) {
                first = first.next;
                if (first == null) {
                    System.out.println("链表长度为" + (i + 1) + ", 长度不够！");
                    return;
                }
            }
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(second.value);
    }

    static class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}
