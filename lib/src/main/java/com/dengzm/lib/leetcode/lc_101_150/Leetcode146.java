package com.dengzm.lib.leetcode.lc_101_150;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description LRU缓存机制
 * Created by deng on 2020/2/8.
 */
public class Leetcode146 {

    class LRUCache {

        int capacity;
        int curLength;
        HashMap<Integer, Integer> map;
        LinkedList<Integer> keys;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.curLength = 0;
            map = new HashMap<>();
            keys = new LinkedList<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                keys.remove(keys.indexOf(key));
                keys.add(key);
                return map.get(key);
            }

            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                keys.remove(keys.indexOf(key));
            } else {
                if (curLength == capacity) {
                    int deleteKey = keys.poll();
                    map.remove(deleteKey);
                } else {
                    curLength ++;
                }
            }

            keys.add(key);
            map.put(key, value);
        }
    }
}
