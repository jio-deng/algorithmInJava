package com.dengzm.lib.jianzhi;

import java.util.Arrays;

/**
 * @Description 061 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的
 * 2-10为数字本身，A为1，JQK为11，12，13，大小王可以看成任意数字
 *
 * Created by deng on 2019/11/1.
 */
public class Jianzhi061 {

    public static void main(String[] args) {
        int[] data1 = new int[] {1,2,3,4,5};
        int[] data2 = new int[] {1,2,3,3,5};
        int[] data3 = new int[] {1,2,3,4,6};
        int[] data4 = new int[] {0,2,3,4,5};
        int[] data5 = new int[] {0,1,2,4,5};

        System.out.println(isContinuous(data1));
        System.out.println(isContinuous(data2));
        System.out.println(isContinuous(data3));
        System.out.println(isContinuous(data4));
        System.out.println(isContinuous(data5));
    }

    /**
     * 通过计算数组中空隙的数量与0的数量，比较大小
     *
     * @param numbers pokers
     * @return is continuous
     */
    private static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        // 将数组排序
        Arrays.sort(numbers);

        int numberOfZero = 0;
        int numberOfGap = 0;

        // 统计出0的数量，同时也是非零数字开始的下标
        for (int i = 0; i < numbers.length && numbers[i] == 0; i ++) {
            numberOfZero ++;
        }

        int small = numberOfZero;
        int big = small + 1;

        while (big < numbers.length) {
            // 有相同的牌时，为对子，不是顺子
            if (numbers[small] == numbers[big]) {
                return false;
            }

            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big ++;
        }

        return numberOfGap <= numberOfZero;
    }
}
