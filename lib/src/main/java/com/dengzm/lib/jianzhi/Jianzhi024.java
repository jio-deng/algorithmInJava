package com.dengzm.lib.jianzhi;

/**
 * @Description 024 反转链表
 * Created by deng on 2019/1/6.
 */
public class Jianzhi024 {
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
        reverseList(head);
    }

    private static void reverseList(Node head) {
        if (head == null) {
            return;
        }

        Node preNode = null;
        Node curNode = null;
        Node nextNode = head;

        while (nextNode != null) {
            curNode = nextNode;
            nextNode = nextNode.next;
            curNode.next = preNode;
            preNode = curNode;
        }

        while (curNode != null) {
            System.out.println(curNode.value);
            curNode = curNode.next;
        }
    }

    static class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}
