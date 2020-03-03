package com.dengzm.lib.leetcode.lc_701_800;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 设计哈希映射
 * @date 2020/3/3 9:53
 */
public class Leetcode706 {
    class MyHashMap {
        private Entry[] datas;

        /** Initialize your data structure here. */
        public MyHashMap() {
            datas = new Entry[128];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int pos = Math.abs(key) % 128;
            Entry entry = datas[pos];
            while (entry != null) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }

                entry = entry.next;
            }

            Entry newEntry = new Entry();
            newEntry.key = key;
            newEntry.value = value;
            newEntry.next = datas[pos];
            datas[pos] = newEntry;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int pos = Math.abs(key) % 128;
            Entry entry = datas[pos];
            while (entry != null) {
                if (entry.key == key) {
                    return entry.value;
                }

                entry = entry.next;
            }

            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int pos = Math.abs(key) % 128;
            Entry entry = datas[pos], pre = null;
            while (entry != null) {
                if (entry.key == key) {
                    if (pre == null) {
                        datas[pos] = entry.next;
                    } else {
                        pre.next = entry.next;
                    }

                    return;
                }

                pre = entry;
                entry = entry.next;
            }
        }
    }

    class Entry {
        public int key;
        public int value;
        public Entry next;
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
