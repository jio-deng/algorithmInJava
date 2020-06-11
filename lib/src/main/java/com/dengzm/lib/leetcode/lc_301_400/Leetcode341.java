package com.dengzm.lib.leetcode.lc_301_400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 扁平化嵌套列表迭代器
 * @date 2020/6/8 11:38
 */
public class Leetcode341 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {
        int index = 0;
        List<Integer> list = new ArrayList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            Deque<NestedInteger> stack = new ArrayDeque<>();
            for (int i = nestedList.size() - 1; i >= 0; i --) {
                stack.push(nestedList.get(i));
            }

            while (!stack.isEmpty()) {
                NestedInteger n = stack.pop();
                if (n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    List<NestedInteger> l = n.getList();
                    for (int i = l.size() - 1; i >= 0; i --) {
                        stack.push(l.get(i));
                    }
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index ++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }

    public interface NestedInteger {

       // @return true if this NestedInteger holds a single integer, rather than a nested list.
       public boolean isInteger();

       // @return the single integer that this NestedInteger holds, if it holds a single integer
       // Return null if this NestedInteger holds a nested list
       public Integer getInteger();

       // @return the nested list that this NestedInteger holds, if it holds a nested list
       // Return null if this NestedInteger holds a single integer
       public List<NestedInteger> getList();
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
