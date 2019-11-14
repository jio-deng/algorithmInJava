package com.dengzm.lib.jianzhi;

/**
 * @Description 035 复杂链表的复制
 * 在复杂链表中，每个节点除了指向下一个节点，还有一个变量指向链表中的任意节点或为null
 *
 * Created by deng on 2019/5/25.
 */
public class Jianzhi035 {

    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.sibling = node3;
        node2.sibling = node4;
        node3.sibling = node5;
        node5.sibling = node1;
        ComplexListNode clonedHead = clone(node1);
        while (clonedHead != null) {
            System.out.println("Node:value=" + clonedHead.value + ", next=" + clonedHead.next + ", sibling=" + clonedHead.sibling);
            clonedHead = clonedHead.next;
        }
    }

    private static ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        connectSibling(head);
        return getClonedHead(head);
    }

    /**
     * 将每个节点复制一份，接在各自的后面
     *
     * @param head head
     */
    private static void cloneNodes(ComplexListNode head) {
        ComplexListNode temp = head;
        while (temp != null) {
            ComplexListNode clone = new ComplexListNode(temp.value);
            clone.next = temp.next;
            temp.next = clone;
            temp = clone.next;
        }
    }

    /**
     * 为clone节点的sibling赋值
     *
     * @param head head
     */
    private static void connectSibling(ComplexListNode head) {
        ComplexListNode temp = head;
        while (temp != null) {
            ComplexListNode clone = temp.next;
            if (temp.sibling != null) {
                clone.sibling = temp.sibling.next;
            }
            temp = clone.next;
        }
    }

    /**
     * 将复制的列表提取出来；并恢复原链表
     *
     * @param head originalHead
     * @return new head
     */
    private static ComplexListNode getClonedHead(ComplexListNode head) {
        ComplexListNode temp = head;
        ComplexListNode clonedHead = null;
        ComplexListNode cloneNode = null;

        if (temp != null) {
            clonedHead = cloneNode = temp.next;
            temp.next = cloneNode.next;
            temp = temp.next;
        }

        while (temp != null) {
            cloneNode.next = temp.next;
            cloneNode = cloneNode.next;
            temp.next = cloneNode.next;
            temp = temp.next;
        }

        return clonedHead;
    }


    private static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;

        public ComplexListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return super.toString() + ":" + value;
        }
    }
}
