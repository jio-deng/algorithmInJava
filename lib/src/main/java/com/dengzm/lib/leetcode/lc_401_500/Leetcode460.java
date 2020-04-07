package com.dengzm.lib.leetcode.lc_401_500;

import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description LFU缓存
 * @date 2020/4/5 10:05
 */
public class Leetcode460 {
    class LFUCache {
        Map<Integer, Node> cache;
        Map<Integer, LinkedHashSet<Node>> freqMap;
        int capacity;
        int minFreq;  // 最小频次

        public LFUCache(int capacity) {
            cache = new HashMap<>(capacity);
            freqMap = new HashMap<>();
            this.capacity = capacity;
            int minFreq = 1;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            // 更新频率
            updateFreq(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            Node node = cache.get(key);
            if (node == null){
                // 满了，应该移除
                if (cache.size() == capacity){
                    removeNode();
                }
                Node newNode = new Node(key, value);
                addNode(newNode);
            } else {
                // 直接覆盖
                node.value = value;
                updateFreq(node);
            }
        }
        /**
         * 更新频率
         */
        public void updateFreq(Node node){
            // 当前缓存的频率
            int freq = node.freq;
            LinkedHashSet<Node> set = freqMap.get(freq);
            // 删除当前频率下的缓存
            set.remove(node);
            // 当前缓存的频率是最小的，并且没有当前频率的缓存了
            if (freq == minFreq && set.size() == 0) minFreq = freq + 1;

            node.freq++;
            LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
            if (newSet == null){
                newSet = new LinkedHashSet<>();
                freqMap.put(freq+1, newSet);
            }
            newSet.add(node);
        }

        /**
         * 移除最小频率的最后一个节点
         */
        public void removeNode(){
            // 移除频率链表中的节点
            LinkedHashSet<Node> set = freqMap.get(minFreq);
            Node node = set.iterator().next();
            set.remove(node);
            // 移除 cache map 中的节点
            Node cacheNode = cache.get(node.key);
            cache.remove(cacheNode.key);
        }

        /**
         * 添加一个新的节点
         */
        public void addNode(Node node){
            int freq = node.freq;
            LinkedHashSet<Node> set = freqMap.get(freq);
            if (set == null){
                set = new LinkedHashSet<>();
                freqMap.put(node.freq, set);
            }
            set.add(node);
            minFreq = node.freq;
            cache.put(node.key, node);
        }


    }
    class Node{
        int key;
        int value;
        int freq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */







//    static class LFUCache {
//        PriorityQueue<Num> priorityQueue = new PriorityQueue<>(new Comparator<Num>() {
//            @Override
//            public int compare(Num o1, Num o2) {
//                return o1.f - o2.f;
//            }
//        });
//        HashMap<Integer, Num> map = new HashMap<>();
//        int size = 0;
//        int capacity;
//
//        public LFUCache(int capacity) {
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            if (!map.containsKey(key)) {
//                return -1;
//            }
//
//            reRange(map.get(key));
//            return map.get(key).val;
//        }
//
//        public void put(int key, int value) {
//            if (map.containsKey(key)) {
//                Num n = map.get(key);
//                n.val = value;
//                reRange(n);
//            } else {
//                if (size >= capacity) {
//                    if (size == 0) {
//                        return;
//                    }
//                    Num k = priorityQueue.poll();
//                    // System.out.println(k);
//                    map.remove(k.key);
//                    size --;
//                }
//
//                Num num = new Num(key, value);
//                map.put(key, num);
//                priorityQueue.offer(num);
//                size ++;
//            }
//        }
//
//        private void reRange(Num num) {
//            num.f ++;
//        }
//
//        class Num {
//            public int key;
//            public int f;
//            public int val;
//
//            public Num(int key, int val) {
//                this.key = key;
//                f = 1;
//                this.val = val;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        LFUCache cache = new LFUCache(3);
//        cache.put(2, 2);
//        cache.put(1, 1);
//        cache.get(2);
//        cache.get(1);
//        cache.get(2);
//        cache.put(3, 3);
//        cache.put(4, 4);
//        cache.get(3);
//        cache.get(2);
//        cache.get(1);
//        cache.get(4);
//    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
