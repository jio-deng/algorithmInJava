package com.dengzm.lib.leetcode.lc_801_900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 特殊等价字符串组
 * @date 2020/3/12 12:52
 */
public class Leetcode893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}
