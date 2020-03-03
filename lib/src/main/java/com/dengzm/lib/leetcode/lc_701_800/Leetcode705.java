package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 设计哈希集合
 * @date 2020/3/3 9:53
 */
public class Leetcode705 {
    class MyHashSet {
        private ListNode[] datas;

        /** Initialize your data structure here. */
        public MyHashSet() {
            datas = new ListNode[128];
        }

        public void add(int key) {
            int pos = Math.abs(key) % 128;
            ListNode node = datas[pos];
            while (node != null) {
                if (node.val == key) {
                    return;
                }

                node = node.next;
            }

            ListNode newNode = new ListNode(key);
            newNode.next = datas[pos];
            datas[pos] = newNode;
        }

        public void remove(int key) {
            int pos = Math.abs(key) % 128;
            ListNode node = datas[pos], pre = null;
            while (node != null) {
                if (node.val == key) {
                    if (pre == null) {
                        datas[pos] = node.next;
                    } else {
                        pre.next = node.next;
                    }

                    return;
                }

                pre = node;
                node = node.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int pos = Math.abs(key) % 128;
            ListNode node = datas[pos];
            while (node != null) {
                if (node.val == key) {
                    return true;
                }

                node = node.next;
            }

            return false;
        }
    }

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
