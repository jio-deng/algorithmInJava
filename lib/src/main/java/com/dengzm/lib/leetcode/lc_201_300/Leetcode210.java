package com.dengzm.lib.leetcode.lc_201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 课程表 II
 * @date 2020/5/17 10:15
 */
public class Leetcode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] counts = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int[] pre : prerequisites) {
            counts[pre[0]] ++;
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i ++) {
            if (counts[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ans[index] = course;
            index ++;

            List<Integer> list = map.getOrDefault(course, new ArrayList<>());
            for (int i : list) {
                counts[i] --;
                if (counts[i] == 0) {
                    queue.add(i);
                }
            }
        }

        if (index != numCourses) {
            return new int[] {};
        }

        return ans;
    }
}
