package com.dengzm.lib.leetcode.lc_701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 字母大小写全排列
 * @date 2020/3/7 9:34
 */
public class Leetcode784 {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        letterCasePermutationCore(list, S, new StringBuilder(), 0);
        return list;
    }

    private void letterCasePermutationCore(List<String> list, String S, StringBuilder sb, int index) {
        if (index == S.length()) {
            list.add(sb.toString());
            return;
        }

        char c = S.charAt(index);


        if (c >= 'A' && c <= 'Z') {
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append((char) (c+32));
            letterCasePermutationCore(list, S, sb1, index + 1);
        } else if (c >= 'a' && c <= 'z') {
            StringBuilder sb2 = new StringBuilder(sb);
            sb2.append((char) (c-32));
            letterCasePermutationCore(list, S, sb2, index + 1);
        }

        sb.append(c);
        letterCasePermutationCore(list, S, sb, index + 1);
    }
}
