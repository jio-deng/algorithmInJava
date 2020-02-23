package com.dengzm.lib.leetcode.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/2/23 12:43
 */
public class LeetcodeComp200223 {
    /**
     * 5169. 日期之间隔几天
     * 请你编写一个程序来计算两个日期之间隔了多少天。
     *
     * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
     * 输出：1
     * 示例 2：
     *
     * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
     * 输出：15
     *  
     *
     * 提示：
     *
     * 给定的日期是 1971 年到 2100 年之间的有效日期。
     */
    int[] x = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(get(date1)-get(date2));
    }

    int get(String date) {
        int y=0,m=0,d=0,i,ans=0;

        for(i=0;i<4;i++) y = y * 10 + date.charAt(i) - '0';
        for(i=5;i<7;i++) m = m * 10 + date.charAt(i) - '0';
        for(i=8;i<10;i++) d = d * 10 + date.charAt(i) - '0';
        for(i=0;i<y;i++) if(i%400==0||i%4==0 && i%100!=0) ans+=366;
        else ans+=365;
        if(y%400==0 || y%4==0 && y%100!=0)x[2]=29;
        else x[2]=28;
        for(i=1;i<m;i++)ans+=x[i];
        ans+=d;
        return ans;
    }

    /**
     * 5170. 验证二叉树
     * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
     *
     * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
     *
     * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
     *
     * 注意：节点没有值，本问题中仅仅使用节点编号。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
     * 输出：true
     * 示例 2：
     *
     *
     *
     * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
     * 输出：false
     * 示例 3：
     *
     *
     *
     * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
     * 输出：false
     * 示例 4：
     *
     *
     *
     * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
     * 输出：false
     *  
     *
     * 提示：
     *
     * 1 <= n <= 10^4
     * leftChild.length == rightChild.length == n
     * -1 <= leftChild[i], rightChild[i] <= n - 1
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < leftChild.length; i ++) {
            if (leftChild[i] != -1) {
                if (set.contains(leftChild[i])) {
                    return false;
                }

                set.add(leftChild[i]);
            }

            if (rightChild[i] != -1) {
                if (set.contains(rightChild[i])) {
                    return false;
                }

                set.add(rightChild[i]);
            }
        }

        boolean hasMissing = false;
        for (int i = 0; i < n; i ++) {
            if (!set.contains(i)) {
                if (!hasMissing) {
                    hasMissing = true;
                } else {
                    return false;
                }
            }
        }

        return hasMissing;
    }


    /**
     * 5171. 最接近的因数
     * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
     *
     * 两数乘积等于  num + 1 或 num + 2
     * 以绝对差进行度量，两数大小最接近
     * 你可以按任意顺序返回这两个整数。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：num = 8
     * 输出：[3,3]
     * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
     * 示例 2：
     *
     * 输入：num = 123
     * 输出：[5,25]
     * 示例 3：
     *
     * 输入：num = 999
     * 输出：[40,25]
     *  
     *
     * 提示：
     *
     * 1 <= num <= 10^9
     */
    public int[] closestDivisors(int num) {
        int[] ans = new int[2];
        ans[0] = (int)Math.sqrt(num + 2);
        ans[1] = ans[0];
        if (ans[0] * ans[1] == num + 2) {
            return ans;
        }

        ans[0] = (int)Math.sqrt(num + 1);
        ans[1] = ans[0];
        while (true) {
            int muti = ans[0] * ans[1];
            if (muti < num + 1) {
                ans[1] ++;
            } else if (muti > num + 2) {
                ans[0] --;
            } else {
                break;
            }
        }

        return ans;
    }



    /**
     * 5172. 形成三的最大倍数
     * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
     *
     * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
     *
     * 如果无法得到答案，请返回一个空字符串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：digits = [8,1,9]
     * 输出："981"
     * 示例 2：
     *
     * 输入：digits = [8,6,7,1,0]
     * 输出："8760"
     * 示例 3：
     *
     * 输入：digits = [1]
     * 输出：""
     * 示例 4：
     *
     * 输入：digits = [0,0,0,0,0,0]
     * 输出："0"
     *  
     *
     * 提示：
     *
     * 1 <= digits.length <= 10^4
     * 0 <= digits[i] <= 9
     * 返回的结果不应包含不必要的前导零。
     */
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);

        int sum = 0;
        for (int i = 0; i < digits.length; i ++) {
            sum += digits[i];
        }

        if (sum < 3) {
            for (int num : digits) {
                if (num == 0) {
                    return "0";
                }
            }

            return "";
        }

        StringBuilder ans = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i --) {
            ans.append(digits[i]);
        }

        if (sum % 3 == 0) {
            return ans.toString();
        }

        if (sum % 3 == 1) {
            getMod1(ans, digits);
        } else {
            getMod2(ans, digits);
        }

        return ans.toString();
    }

    private int[] getMod1(StringBuilder sb, int[] digits) {
        for (int i = 0; i < digits.length; i ++) {
            if (digits[i] % 3 == 1) {
                sb.deleteCharAt(digits.length - 1 - i);
                int[] newDigits = new int[digits.length - 1];
                for (int j = 0; j < i; j ++) {
                    newDigits[j] = digits[j];
                }

                for (int j = i+1; j < digits.length; j ++) {
                    newDigits[j-1] = digits[j];
                }

                return newDigits;
            }
        }

        digits = getMod2(sb, digits);
        return getMod2(sb, digits);
    }

    private int[] getMod2(StringBuilder sb, int[] digits) {
        for (int i = 0; i < digits.length; i ++) {
            if (digits[i] % 3 == 2) {
                sb.deleteCharAt(digits.length - 1 - i);
                int[] newDigits = new int[digits.length - 1];
                for (int j = 0; j < i; j ++) {
                    newDigits[j] = digits[j];
                }

                for (int j = i+1; j < digits.length; j ++) {
                    newDigits[j-1] = digits[j];
                }

                return newDigits;
            }
        }

        digits = getMod1(sb, digits);
        return getMod1(sb, digits);
    }

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        LeetcodeComp200223 leetcodeComp200223 = new LeetcodeComp200223();
//        int[] digits = new int[] {5,8};
//        leetcodeComp200223.largestMultipleOfThree(digits);

        System.out.println(leetcodeComp200223.daysBetweenDates("2020-02-23", "1994-07-31"));
    }
}
