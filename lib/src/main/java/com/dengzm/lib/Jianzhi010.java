package com.dengzm.lib;

/**
 * @Description 010 斐波那契数列
 * Created by deng on 2018/12/19.
 */
public class Jianzhi010 {

    public static void main(String[] args) {
        long q1 = fibonacci(100);
        System.out.println(q1);
    }

    //题目1：求斐波那契数列的第n项
    //使用递归会有很多重复计算，而且当n特别大时，递归可能会造成调用栈溢出
    //使用for循环计算：避免了重复计算
    //
    //题目2：青蛙跳台阶问题
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶共有多少种跳法
    //f(n) = f(n-1) + f(n-2)
    public static long fibonacci(long n) {
        if (n <= 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        long firstNum = 1;
        long secondNum = 1;
        long result = 0;

        for (int i = 3; i <= n; i ++) {
            result = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = result;
        }

        return result;
    }
}
