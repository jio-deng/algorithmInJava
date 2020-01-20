package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 电话号码的字母组合
 * @date 2019/12/23 10:37
 */
public class Leetcode017 {
    private HashMap<Integer, String> map = new HashMap<>();

    {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        letterCombCore(result, "", digits);

        return result;
    }

    private void letterCombCore(ArrayList<String> result, String front, String digits) {
        if (digits.equals("")) {
            result.add(front);
        } else {
            int digit = digits.charAt(0) - '0';
            String target = map.get(digit);
            digits = digits.substring(1);

            for (int i = 0; i < target.length(); i ++) {
                letterCombCore(result, front + target.charAt(i), digits);
            }
        }
    }

    /*执行结果：通过
      显示详情
      执行用时 :1 ms, 在所有 java 提交中击败了95.05%的用户
      内存消耗 :36.2 MB, 在所有 java 提交中击败了73.14%的用户*/
}
