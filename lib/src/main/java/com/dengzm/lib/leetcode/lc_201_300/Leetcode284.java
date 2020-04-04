package com.dengzm.lib.leetcode.lc_201_300;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 顶端迭代器
 * @date 2020/4/4 10:14
 */
public class Leetcode284 {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {
        LinkedList<Integer> queue;
        Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            queue = new LinkedList<>();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (queue.isEmpty()) {
                queue.add(iterator.next());
            }

            return queue.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (!queue.isEmpty()) {
                return queue.poll();
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty() || iterator.hasNext();
        }
    }
}
