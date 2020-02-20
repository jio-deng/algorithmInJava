package com.dengzm.lib.leetcode.lc_401_500;

import java.util.TreeSet;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 第三大的数
 * @date 2020/2/17 9:53
 */
public class Leetcode414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : nums) {
            treeSet.add(i);
            if (treeSet.size() > 3) treeSet.remove(treeSet.first());
        }

        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }
}
