package com.dengzm.lib.leetcode.lc_1201_1300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 统计「优美子数组」
 * @date 2020/4/21 12:07
 */
public class Leetcode1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            if (nums[i] % 2 == 1) {
                queue.add(i);
            }
        }

        if (queue.size() < k) {
            return 0;
        }

        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < k - 1; i ++) {
            odds.add(queue.poll());
        }

        int ans = 0;
        int pre = -1;
        while (!queue.isEmpty()) {
            odds.add(queue.poll());

            int left = odds.get(0) - pre;
            if (left == 0) {
                left = 1;
            }

            int right = (!queue.isEmpty() ? queue.peek() - 1 : n - 1) - odds.get(odds.size() - 1) + 1;
            if (right == 0) {
                right = 1;
            }
            int tmp = left * right;
            System.out.println(tmp);
            ans += tmp;
            pre = odds.remove(0);
        }

        return ans;
    }
}
