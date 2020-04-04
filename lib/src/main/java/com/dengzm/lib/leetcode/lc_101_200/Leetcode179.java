package com.dengzm.lib.leetcode.lc_101_200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 最大数
 * @date 2020/4/3 10:09
 */
public class Leetcode179 {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            ss[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length() + o2.length();
                int index = 0;
                while (index < len) {
                    char c1 = o1.charAt(index % o1.length());
                    char c2 = o2.charAt(index % o2.length());
                    if (c1 == c2) {
                        index ++;
                    } else {
                        return c2 - c1;
                    }
                }

                return 0;
            }
        });

        for (String s : ss) {
            sb.append(s);
        }

        if (sb.length() == 0 || sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
