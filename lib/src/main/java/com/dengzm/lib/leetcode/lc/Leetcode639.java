package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 解码方法 2
 * @date 2020/1/31 9:11
 */
public class Leetcode639 {
    private int M = 1000000007;

    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
        }

        return (int) dp[s.length()];
    }

    public int numDecodings1(String s) {
        Long[] memo=new Long[s.length()];
        return (int) ways(s, s.length() - 1,memo);
    }

    public long ways(String s, int i, Long[] memo) {
        if (i < 0)
            return 1;
        if(memo[i]!=null)
            return memo[i];

        long res;
        if (s.charAt(i) == '*') {
            res = 9 * ways(s, i - 1,memo);
            if (i > 0) {
                if (s.charAt(i - 1) == '1')
                    res = (res + 9 * ways(s, i - 2,memo)) % M;
                else if (s.charAt(i - 1) == '2')
                    res = (res + 6 * ways(s, i - 2,memo)) % M;
                else if (s.charAt(i - 1) == '*')
                    res = (res + 15 * ways(s, i - 2,memo)) % M;
            }
        } else {
            res = s.charAt(i) != '0' ? ways(s, i - 1,memo) : 0;
            if (i > 0) {
                if (s.charAt(i - 1) == '1')
                    res = (res + ways(s, i - 2,memo)) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    res = (res + ways(s, i - 2,memo)) % M;
                else if (s.charAt(i - 1) == '*')
                    res = (res + (s.charAt(i)<='6'?2:1) * ways(s, i - 2,memo)) % M;
            }
        }

        memo[i]= res;
        return memo[i];
    }

//    private static final int MO = 1000000007;
//
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        return numDecodingsCore(s, 0);
//    }
//
//    private int numDecodingsCore(String s, int curIndex) {
//        if (curIndex >= s.length()) {
//            return 0;
//        }
//
//        int result;
//        char c = s.charAt(curIndex);
//        if (curIndex < s.length() - 1) {
//            char next = s.charAt(curIndex + 1);
//            if (c == '*') {
//                if (next == '*') {
//                    // 11-19 21-26 + 分开的1-9
//                    result = 15 + numDecodingsCore(s, curIndex + 2) + 9 + numDecodingsCore(s, curIndex + 1);
//                } else {
//                    int temp = next - '0';
//                    if (temp <= 6) {
//                        result = 2 + numDecodingsCore(s, curIndex + 2) + 9 + numDecodingsCore(s, curIndex + 1);
//                    } else {
//                        result = 1 + numDecodingsCore(s, curIndex + 2) + 9 + numDecodingsCore(s, curIndex + 1);
//                    }
//                }
//            } else {
//                if (next == '*') {
//                    if (c == '1') {
//                        result = 9 + numDecodingsCore(s, curIndex + 2) + 1 + numDecodingsCore(s, curIndex + 1);
//                    } else if (c == '2') {
//                        result = 6 + numDecodingsCore(s, curIndex + 2) + 1 + numDecodingsCore(s, curIndex + 1);
//                    } else {
//                        result = 1 + numDecodingsCore(s, curIndex + 1);
//                    }
//                } else {
//                    if (c == '1' || (c == '2' && next - '0' <= 6)) {
//                        result = 1 + numDecodingsCore(s, curIndex + 2) + 1 + numDecodingsCore(s, curIndex + 1);
//                    } else {
//                        result = 1 + numDecodingsCore(s, curIndex + 1);
//                    }
//                }
//            }
//        } else {
//            if (c == '*') {
//                result = 9;
//            } else {
//                result = 1;
//            }
//        }
//
//        if (result >= MO) {
//            result = result % MO;
//        }
//
//        return result;
//    }
}
