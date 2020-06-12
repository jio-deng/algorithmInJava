package com.dengzm.lib.leetcode.lc_201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 求众数 II
 * @date 2020/6/12 10:26
 */
public class Leetcode229 {
    /**
     * 【笔记】摩尔投票法。该算法用于1/2情况，它说：“在任何数组中，出现次数大于该数组长度一半的值只能有一个。”
     *
     * 那么，改进一下用于1/3。可以着么说：“在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。”
     *
     * 于是，需要定义两个变量。空间复杂度为O(1)。
     *
     * 摩尔投票法：https://mabusyao.iteye.com/blog/2223195
     *
     * 算法1/3改进：https://blog.csdn.net/weixin_42768679/article/details/81567231
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int x = 0, y = 0, cx = 0, cy = 0;
        for (int num : nums) {
            if ((cx == 0 || x == num) && num != y) {
                cx ++;
                x = num;
            } else if (cy == 0 || y == num) {
                cy ++;
                y = num;
            } else {
                cx --;
                cy --;
            }
        }

        int countX = 0, countY = 0;
        for (int num : nums) {
            if (num == x) {
                countX ++;
            } else if (num == y) {
                countY ++;
            }
        }

        if (countX > nums.length / 3) {
            res.add(x);
        }

        if (countY > nums.length / 3 && x != y) {
            res.add(y);
        }

        return res;
    }
}
