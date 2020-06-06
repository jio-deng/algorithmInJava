package com.dengzm.lib.leetcode.lc_201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 课程表
 * @date 2020/6/5 11:40
 */
public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if (n == 0) {
            return true;
        }

        int[] nums = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<>());
            }

            map.get(prerequisite[1]).add(prerequisite[0]);

            nums[prerequisite[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            if (nums[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (flag[index]) {
                continue;
            }

            flag[index] = true;
            if (!map.containsKey(index)) {
                continue;
            }

            List<Integer> list = map.get(index);
            for (int num : list) {
                nums[num] --;
                if (nums[num] == 0 && !flag[num]) {
                    queue.add(num);
                }
            }
        }

        for (boolean f : flag) {
            if (!f) {
                return false;
            }
        }

        return true;
    }
}
