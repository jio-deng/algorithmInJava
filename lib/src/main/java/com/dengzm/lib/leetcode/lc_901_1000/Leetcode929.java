package com.dengzm.lib.leetcode.lc_901_1000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 独特的电子邮件地址
 * @date 2020/3/16 11:00
 */
public class Leetcode929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean isPlusFound = false, isAtteFound = false;
            for (char c : email.toCharArray()) {
                if (isAtteFound) {
                    sb.append(c);
                } else if (c == '@') {
                    isAtteFound = true;
                    continue;
                } else if (isPlusFound) {
                    continue;
                } else if (c == '+') {
                    isPlusFound = true;
                    continue;
                }

                if (c != '.') {
                    sb.append(c);
                }
            }

            ans.add(sb.toString());
        }

        return ans.size();
    }
}
