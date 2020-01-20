package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 括号生成
 * @date 2019/12/30 10:31
 */
public class Leetcode022 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        generateParenthesisCore(result, new StringBuilder("("), n, 1, 0);

        return result;
    }

    public void generateParenthesisCore(List<String> result, StringBuilder s, int n, int left, int right) {
        if (left == n) {
            if (right < n) {
                for (; right < n; right ++) {
                    s.append(")");
                }
            }
            result.add(s.toString());
            return;
        }

        s.append("(");
        generateParenthesisCore(result, new StringBuilder(s), n, left + 1, right);
        s.deleteCharAt(s.length() - 1);

        for (; right < left; right ++) {
            s.append(")");
            s.append("(");
            generateParenthesisCore(result, new StringBuilder(s), n, left + 1, right + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }


    /*-------------------- 他人解法 ----------------------*/
    /*速度相同，都是2ms。但是思路更清晰一些*/
    public List<String> generateParenthesis1(int n) {
        //回溯思想，需要加强练习
        List<String> result = new ArrayList<>();
        generateOneByOne("",result,n,n);//最开始是空字符串，还剩n个左右括号
        return result;
    }
    /**
     * 其实就是给你2n个格子，问你有效括号的组合数，第几层递归，就是处理第几个格子上的括号，判断放左还是放右
     * @param sublist
     * @param result  结果集
     * @param left  还剩多少左括号
     * @param right  还剩多少右括号
     */
    public static void generateOneByOne(String sublist ,List<String> result, int left,int right) {
        if (left == 0 && right == 0) {   // 括号都用完了，sublist组装完毕
            result.add(sublist);
            return ;
        }
        //每一层的递归，需要判断
        if (left > 0) {//还有剩余的左括号，那这个格子就可以放左括号
            generateOneByOne(sublist + "(", result, left-1, right);
        }
        if (right > left) {//只有剩余的右括号多于左括号时，这个格子才可以放右括号
            //比如()()_ _，那第五层递归就不能放右括号，因为剩余的左右括号相等
            generateOneByOne(sublist + ")", result, left, right-1);
        }
    }


    /**
     * 官方题解：
     * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode/
     */
}
