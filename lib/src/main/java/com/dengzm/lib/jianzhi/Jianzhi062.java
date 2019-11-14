package com.dengzm.lib.jianzhi;

import java.util.LinkedList;

/**
 * @Description 062 圆圈中最后剩下的数字
 * 0～n-1，共n个数字，排成一个圆圈，从数字0开始，每次从这个圆圈中删除第m个数字，求出这个圆圈里剩下的最后一个数字
 *
 * Created by deng on 2019/11/1.
 */
public class Jianzhi062 {

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(15, 13));
        System.out.println(lastRemaining2(5, 3));
        System.out.println(lastRemaining2(15, 13));
    }

    /**
     * 解法一：环形链表模拟圆圈
     *
     * @param n num
     * @param m delete position
     * @return last remaining number
     */
    private static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        // 圆圈——双向链表
        // 这里参考了网上的方式，并不需要使用循环链表，只需要计算出需要删除的节点下标即可
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i ++) {
            queue.addLast(i);
        }

        // 上一次删除的位置
        int removeIndex = 0;

        while (queue.size() > 1) {
            removeIndex = (removeIndex + m - 1) % queue.size();
            queue.remove(removeIndex);
        }

        return queue.getFirst();
    }

    /**
     * 解法二：数学公式
     * 首先，定义一个关于n和m的方程f(n,m)，表示每次在n个数字0～n-1中删除第m个数字最后剩下的数字
     * 在n个数字中，第一个被删除的数字是(m-1)%n，记为k，则第二次删除开始时，从k+1开始，序列为k+1, ..., n-1, 0, 1,..., k-1
     * 将该序列与0～n-2进行映射可得到映射函数p(x)=(x-k-1)%n。该函数的逆映射为p-1(x)=(x+k+1)%n
     * 映射后的序列与最初的序列类似，记为f(n-1,m)。将删除第一个数字后的函数代入，
     * 得到f(n,m)=f'(n-1,m)=p-1[f(n-1,m)]=[f(n-1,m)+k+1]%n,把k=(m-1)%n代入得到，f(n,m)=[f(n-1,m)+m]%n
     *
     * 经过上面的分析，得到了递归公式：
     * f(n,m) = 0                  (n = 1)
     *        = [f(n-1,m) + m] % n (n > 1)
     *
     * @param n num
     * @param m delete position
     * @return last remaining number
     */
    private static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i ++) {
            last = (last + m) % i;
        }

        return last;
    }


}
