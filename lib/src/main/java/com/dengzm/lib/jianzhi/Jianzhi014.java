package com.dengzm.lib.jianzhi;

/**
 * @Description 014 剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * Created by deng on 2018/12/20.
 */
public class Jianzhi014 {
    public static void main(String[] args) {
        System.out.println(maxProductAfterCut1(8));
        System.out.println(maxProductAfterCut1(18));
        System.out.println(maxProductAfterCut2(8));
        System.out.println(maxProductAfterCut2(18));
    }

    //方法1：动态规划
    //在剪一刀的时候，我们有n-1种选择，即f(n)=max(f(i)*f(n-i))。
    //我们从下至上进行计算，算出每个长度对应的能达到的最大乘积是多少，最后计算出结果
    public static int maxProductAfterCut1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max;

        for (int i = 4; i < length + 1; i ++) {
            max = 0;
            for (int j = 1; j <= i / 2; j ++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[length];
    }

    //方法2：贪婪算法
    //当n>=5时，我们尽可能的多剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
    //证明：当n>=5时，2(n-2)>n,3(n-3)>n,且3(n-3)>=2(n-2)，因此应该尽可能剪长度为3的绳子。
    //而长度为4时，2*2>3*1，应剪为两段为2的绳子。
    public static int maxProductAfterCut2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //尽可能多的剪去长度为3的绳子
        int timesOf3 = length / 3;
        //当绳子最后长度为4的时候，剪为2*2
        if (length - timesOf3 * 3 == 1) {
            timesOf3 --;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
