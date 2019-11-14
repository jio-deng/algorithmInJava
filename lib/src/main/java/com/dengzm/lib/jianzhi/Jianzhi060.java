package com.dengzm.lib.jianzhi;

import java.text.NumberFormat;

/**
 * @Description 060 n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上的一面的点数之和为s。输入n，打印出所有可能出现的值出现的概率
 *
 * Created by deng on 2019/11/1.
 */
public class Jianzhi060 {
    private static int MAX_VALUE = 6; // 骰子的最大值

    public static void main(String[] args) {
        System.out.println("解法一");
        printProbability(10);
        System.out.println();

        System.out.println("解法二");
        printProbability2(10);
    }

    /**
     * 解法一：基于递归求骰子点数，时间效率不高
     * 想求出n个骰子的点数和，可以先把n个骰子分为两堆，第一堆只有一个，另一堆有n-1个。
     * 单独的一堆，可能出现1～6的点数，并与另一堆的点数来计算点数和。
     * n-1的堆，通过递归，再分出1和n-2，最后递归的结束条件为只剩下一个骰子
     *
     * @param n number of touzi
     */
    private static void printProbability(int n) {
        if (n < 1) {
            return;
        }

        int maxSum = n * MAX_VALUE;

        // 可能出现的值：n —— 6n，长度为 6n-n+1
        int[] probabilities = new int[maxSum - n + 1];

        for (int i = 0; i < maxSum - n + 1; i ++) {
            probabilities[i] = 0;
        }

        probability(n, probabilities);

        double total = Math.pow(MAX_VALUE, n);

        for (int i = 0; i < maxSum - n + 1; i ++) {
            double ratio = probabilities[i] / total;

            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(10);

            System.out.println((i+n) + " : " + format.format(ratio));
        }
    }

    /**
     * 第一个骰子，对应1～MAX_VALUE，分别求对应出现的次数
     *
     * @param n number
     * @param probabilities 出现的次数
     */
    private static void probability(int n, int[] probabilities) {
        for (int i = 1; i <= MAX_VALUE; i ++) {
            probability(n, n, i, probabilities);
        }
    }

    /**
     * 统计每种情况出现的次数
     *
     * @param original 一共有多少个
     * @param current 目前分堆有多少个
     * @param sum 目前的和是多少
     * @param probabilities 可能出现的次数
     */
    private static void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            // 只剩下一个骰子，与上面函数中第一个骰子对应
            probabilities[sum - original] ++;
        } else {
            for (int i = 1; i <= MAX_VALUE; i ++) {
                // 再次分堆，去掉一个骰子，将对应的数值增加到sum上
                probability(original, current - 1, i + sum, probabilities);
            }
        }
    }

    /**
     * 解法二：基于循环求骰子点数，时间性能好
     * 用两个数组来储存骰子的每个总数出现的次数
     * 在一轮循环中，第一个数组中的第n个数字表示骰子和为n出现的次数；
     * 在下一轮循环中，我们增加一个新的骰子，此时和为n的骰子出现的次数应该等于n-1、n-2、...、n-6出现的次数的总和
     *
     * @param n number of touzi
     */
    private static void printProbability2(int n) {
        if (n < 1) {
            return;
        }

        // 两个数组，循环赋值
        int[][] probabilities = new int[2][n * MAX_VALUE + 1];

        for (int i = 0; i < n * MAX_VALUE + 1; i ++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }

        // 标识当前使用的数组为哪个
        int flag = 0;

        // 第一个骰子，每个数字出现的次数为1
        for (int i = 1; i <= MAX_VALUE; i ++) {
            probabilities[flag][i] = 1;
        }

        // 增加骰子
        for (int k = 2; k <= n; k ++) {
            // 将另一个数组先清空
            for (int i = 0; i < k; i ++) {
                probabilities[1 - flag][i] = 0;
            }

            // 增加一个新的骰子，此时和为n的骰子出现的次数应该等于n-1、n-2、...、n-6出现的次数的总和
            for (int i = k; i <= MAX_VALUE * k; i ++) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= MAX_VALUE; j ++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }

            // 切换数组
            flag = 1 - flag;
        }

        double total = Math.pow(MAX_VALUE, n);

        for (int i = n; i < MAX_VALUE * n + 1; i ++) {
            double ratio = probabilities[flag][i] / total;

            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(10);

            System.out.println((i) + " : " + format.format(ratio));
        }
    }
}
