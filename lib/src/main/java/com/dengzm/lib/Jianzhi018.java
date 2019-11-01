package com.dengzm.lib;

/**
 * @Description 018 删除链表的节点
 * Created by deng on 2018/12/21.
 */
public class Jianzhi018 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp1 = new Node(2);
        Node temp2 = new Node(3);
        Node temp3 = new Node(4);
        Node temp4 = new Node(5);
        head.mNext = temp1;
        temp1.mNext = temp2;
        temp2.mNext = temp3;
        temp3.mNext = temp4;
        //题目1
        //deleteNode(head, temp3);
        deleteNode(head, temp4);
        printList(head);
        System.out.println();
        //题目2
        Node head1 = new Node(1);
        Node temp11 = new Node(1);
        Node temp12 = new Node(3);
        Node temp13 = new Node(4);
        Node temp14 = new Node(4);
        head1.mNext = temp11;
        temp11.mNext = temp12;
        temp12.mNext = temp13;
        temp13.mNext = temp14;
        head1 = deleteDuplicatedNode(head1);
        printList(head1);
    }

    //题目1：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
    //链表长度为n时，删除尾节点的时间复杂度为O(n)，其他节点为O(1)，平均时间为（O(n) + (n - 1) * O(1)) / n，结果仍为O(1)
    public static void deleteNode(Node mHeadNode, Node mDelNode) {
        if (mHeadNode == null || mDelNode == null) {
            return;
        }
        if (mDelNode.mNext != null) { //待删除节点不是尾节点
            Node pNext = mDelNode.mNext;
            mDelNode.value = pNext.value;
            mDelNode.mNext = pNext.mNext;
            pNext.deleteSelf();
        } else if (mHeadNode == mDelNode) { //只有一个节点
            mHeadNode.deleteSelf();
        } else { //删除尾节点
            Node temp = mHeadNode;
            while (temp.mNext != mDelNode) {
                temp = temp.mNext;
            }
            temp.mNext = null;
            mDelNode.deleteSelf();
        }
    }

    //题目2：在一个排序的链表中，删除重复的节点。例如，1->2->3->3->4->4->5,删除后为1->2->5
    public static Node deleteDuplicatedNode(Node pHead) {
        if (pHead == null) {
            return null;
        }
        Node preNode = null;
        Node pNode = pHead;
        while (pNode != null) {
            Node pNext = pNode.mNext;
            if (pNext != null && pNext.value == pNode.value) {
                //当两个节点值相等时，循环向后判断是否仍有相同值；
                //删除所有相同节点，将后继节点与preNode拼接；
                //preNode为null则头节点被删，换为新的头节点
                int value = pNode.value;
                Node pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.value == value) {
                    pToBeDel = pToBeDel.mNext;
                }
                if (preNode == null) {
                    pHead = pToBeDel;
                } else {
                    preNode.mNext = pToBeDel;
                }
                pNode = pToBeDel;
            } else {
                preNode = pNode;
                pNode = pNode.mNext;
            }
        }
        return pHead;
    }

    //打印链表
    private static void printList(Node head) {
        if (head == null) {
            return;
        }
        while (head.mNext != null) {
            System.out.println(head.value);
            head = head.mNext;
        }
        System.out.println(head.value);
    }

    static class Node {
        int value;
        Node mNext;

        Node(int value) {
            this.value = value;
        }

        void deleteSelf() {
            //TODO:删除节点
        }
    }
}
