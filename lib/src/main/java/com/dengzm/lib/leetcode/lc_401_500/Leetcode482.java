package com.dengzm.lib.leetcode.lc_401_500;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 密钥格式化
 * @date 2020/2/21 12:16
 */
public class Leetcode482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder result = new StringBuilder();
        String target = S.toUpperCase();

        int sum = 0;
        for (int n = 0; n < target.length(); n ++) {
            if (target.charAt(n) != '-') {
                sum ++;
            }
        }


        int i = -1;
        if (sum % K > 0) {
            for (i = 0; i < target.length(); i ++) {
                if (target.charAt(i) == '-') {
                    continue;
                }

                result.append(target.charAt(i));
                if (result.length() >= sum % K) {
                    break;
                }
            }

            result.append('-');
        }
        int length = 0;
        for (i = i + 1; i < target.length(); i ++) {
            if (target.charAt(i) == '-') {
                continue;
            }

            result.append(target.charAt(i));
            length ++;
            if (length == K) {
                result.append('-');
                length = 0;
            }
        }

        if (result.length() > 0 && result.charAt(result.length() - 1) == '-') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }
}
