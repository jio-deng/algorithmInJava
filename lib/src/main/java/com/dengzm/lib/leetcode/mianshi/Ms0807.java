package com.dengzm.lib.leetcode.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 08.07. 无重复字符串的排列组合
 * @date 2020/4/17 19:32
 */
public class Ms0807 {
    public String[] permutation(String S) {
        if (S == null || S.length() == 0) {
            return new String[] {};
        }
        List<String> list = new ArrayList<>();
        boolean[] isVisited = new boolean[S.length()];
        permutationCore(S, isVisited, list, new StringBuilder());
        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; i ++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void permutationCore(String S, boolean[] isVisited, List<String> list, StringBuilder sb) {
        if (sb.length() == S.length()) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < S.length(); i ++) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            sb.append(S.charAt(i));
            permutationCore(S, isVisited, list, sb);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
