package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题57. 和为s的两个数字
 *              面试题57 - II. 和为s的连续正数序列
 * @date 2020/3/6 9:18
 */
public class Ms057 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int v = nums[start] + nums[end];
            if (v == target) {
                ans[0] = nums[start];
                ans[1] = nums[end];
                break;
            } else if (v < target) {
                start ++;
            } else {
                end --;
            }
        }

        return ans;
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        if (target <= 2) {
            return res.toArray(new int[res.size()][]);
        }

        // 从2开始，不会全部遍历，当左端到达0的时候即跳出循环
        for (int i = 2; i < target; i ++) {
            int tmp = target / i;

            // 因数是双数，则需要满足（tmp + tmp + 1）* num / 2 == target
            // 因数是单数，则需要满足 tmp * num == target
            if (i % 2 == 0 && (tmp * 2 + 1) * i / 2 == target ||
                    i % 2 != 0 && tmp * i == target) {

                // 判断长度是否足够
                if (tmp <= (i - 1) / 2) {
                    break;
                }

                int[] ans = new int[i];
                for (int j = 0; j < ans.length; j ++) {
                    ans[j] = tmp - (i - 1) / 2 + j;
                }

                res.add(ans);
            }
        }

        res.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return res.toArray(new int[res.size()][]);
    }
}
