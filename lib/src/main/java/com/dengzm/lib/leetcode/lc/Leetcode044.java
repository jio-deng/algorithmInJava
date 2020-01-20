package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 通配符匹配
 * @date 2020/1/20 9:48
 */
public class Leetcode044 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

//        // 临界情况
//        if (s.length() == 0) {
//            if (p.length() == 0) {
//                return true;
//            }
//
//            for (int i = 0; i < p.length(); i ++) {
//                if (p.charAt(i) != '*') {
//                    return false;
//                }
//            }
//
//            return true;
//        } else if (p.length() == 0) {
//            return false;
//        }
        String newS = "aa" + s;
        String newP = "aa" + p;

        int[][] dp = new int[newS.length() + 1][newP.length() + 1];
        dp[0][0] = 1;

        for (int j = 1; j < newP.length() + 1; j ++) {
            if (newP.charAt(j - 1) != '*') {
                break;
            }

            dp[0][j] = 1;
        }

        for (int i = 1; i < newS.length() + 1; i ++) {
            for (int j = 1; j < newP.length() + 1; j ++) {
                if (newS.charAt(i - 1) == newP.charAt(j - 1) || newP.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (newP.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }

        return dp[newS.length()][newP.length()] == 1;
    }

    public boolean isMatch1(String s, String p) {
        int i = 0, j = 0, m = s.length(), n = p.length(), iStart = -1, jStart = -1;

        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i ++;
                j ++;
            } else if (j < n && p.charAt(j) == '*') {
                iStart = i;
                jStart = j ++;
            } else if (iStart >= 0) {
                i = ++ iStart;
                j = jStart + 1;
            } else {
                return false;
            }
        }

        while (j < n && p.charAt(j) == '*') {
            j ++;
        }

        return j == n;
    }

    public static void main(String[] args) {
        Leetcode044 leetcode044 = new Leetcode044();
        leetcode044.isMatch("aa", "a");
    }

}
