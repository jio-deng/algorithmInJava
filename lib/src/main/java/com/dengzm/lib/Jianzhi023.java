package com.dengzm.lib;

/**
 * @Description 链表中环的入口节点
 * Created by deng on 2019/1/6.
 */
public class Jianzhi023 {
    public static void main(String[] args) {
        //无环
        Node head = new Node(1);
        Node temp1 = new Node(2);
        Node temp2 = new Node(3);
        Node temp3 = new Node(4);
        Node temp4 = new Node(5);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        findEntryOfLoop(head);

        //有环
        Node ahead = new Node(1);
        Node atemp1 = new Node(2);
        Node atemp2 = new Node(3);
        Node atemp3 = new Node(4);
        Node atemp4 = new Node(5);
        ahead.next = atemp1;
        atemp1.next = atemp2;
        atemp2.next = atemp3;
        atemp3.next = atemp4;
        atemp4.next = atemp2;
        findEntryOfLoop(ahead);
    }

    private static void findEntryOfLoop(Node head) {
        if (head == null) {
            return;
        }

        // 获取环内节点个数：first向前num步，当second到达入口节点时，first绕环一圈也回到了入口节点
        int num = isLoop(head);

        if (num == 0) {
            System.out.println("this is not a loop!");
            return;
        }

        Node first = head;
        Node second = head;

        for (int i = 0; i < num; i ++) {
            first = first.next;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        System.out.println(first.value);
    }

    /**
     * 判断当前链表是否为loop
     * @param head 头节点
     * @return 是，返回环内节点个数；否，返回0
     */
    private static int isLoop(Node head) {
        Node first = head;
        Node second = head;
        int num = 0;

        do {
            first = first.next;
            if (first == null) {
                return 0;
            }
            first = first.next;
            second = second.next;
            num ++;
        } while (first != null && first != second);

        return num;
    }

    static class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}
