package com.dengzm.lib.jianzhi;

/**
 * @Description 052 两个链表的第一个公共节点
 *
 * Created by deng on 2019/9/22.
 */
public class Jianzhi052 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;

        node4.next = node5;
        node5.next = node6;

        Node result = findFirstSameNode(node1, node4);
        System.out.println(result == null ? "null" : result.value);
    }

    private static Node findFirstSameNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        int difLength;
        Node longHead;
        Node shortHead;

        int length1 = getLength(head1);
        int length2 = getLength(head2);

        if (length1 > length2) {
            longHead = head1;
            shortHead = head2;
            difLength = length1 - length2;
        } else {
            longHead = head1;
            shortHead = head2;
            difLength = length1 - length2;
        }

        if (difLength != 0) {
            for (int i = 0; i < difLength; i ++) {
                longHead = longHead.next;
            }
        }

        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) {
                return longHead;
            }

            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return null;
    }

    private static int getLength(Node head) {
        int len = 0;
        Node temp = head;

        while(temp != null) {
            len ++;
            temp = temp.next;
        }

        return len;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
