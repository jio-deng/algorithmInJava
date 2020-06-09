package com.dengzm.lib.leetcode.lc_201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 汇总区间
 * @date 2020/6/9 14:54
 */
public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int start = 0;
        int tobe = nums[0];
        for (int i = 0; i <= nums.length; i ++) {
            if (i == nums.length) {
                StringBuilder sb = new StringBuilder();
                if (tobe - 1 > nums[start]) {
                    sb.append(nums[start]).append("->").append(tobe - 1);
                } else {
                    sb.append(nums[start]);
                }
                res.add(sb.toString());
                break;
            }

            if (nums[i] == tobe) {
                tobe ++;
            } else {
                StringBuilder sb = new StringBuilder();
                if (tobe - 1 > nums[start]) {
                    sb.append(nums[start]).append("->").append(tobe - 1);
                } else {
                    sb.append(nums[start]);
                }
                res.add(sb.toString());

                start = i;
                tobe = nums[i] + 1;
            }
        }


        return res;
    }
}
