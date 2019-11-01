package com.dengzm.lib;

import java.util.Random;

/**
 * @Description 039 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 *
 * Created by deng on 2019/5/25.
 */
public class Jianzhi039 {



    public static void main(String[] args) {
        int[] data1 = new int[] {1,2,3,4,5,6,6,6,6,6};
        int[] data2 = new int[] {1,2,3,4,5,6,7,8,9,1,1,1,1,1,1,1,1};
        int[] data3 = new int[] {1,2,3,4,5,6,6,6,6};

        System.out.println(getMoreThanHalfUsingPartition(data1));
        System.out.println(getMoreThanHalfUsingPartition(data2));
        System.out.println(getMoreThanHalfUsingPartition(data3));

        System.out.println(getMoreThanHalfUsingCount(data1));
        System.out.println(getMoreThanHalfUsingCount(data2));
        System.out.println(getMoreThanHalfUsingCount(data3));
    }

    /**
     * 方法一：使用快排的方式，寻找数组的中位数
     * 当数组中超过一半的数字为相同数字时，该数组的中位数一定是该数字
     */
    private static int getMoreThanHalfUsingPartition(int[] source) {
        if (source == null || source.length == 0) {
            return -1;
        }

        int middle = source.length / 2;
        int start = 0;
        int end = source.length - 1;
        int index = partition(source, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(source, start, end);
            } else {
                start = index + 1;
                index = partition(source, start, end);
            }
        }

        int result = source[index];
        return checkMoreThanHalf(source, result) ? result : -1;
    }

    private static int partition(int[] data, int start, int end) {
        if (data == null || data.length == 0 || end >= data.length) {
            throw new RuntimeException("partition out of range!");
        }

        int index = new Random().nextInt(end - start + 1) + start;
        swap(data, index, end);

        int small = start - 1;
        for (index = start; index <= end; index ++) {
            if (data[index] < data[end]) {
                small ++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }

        small ++;
        swap(data, end, small);

        return small;
    }

    private static void swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    /**
     * 方法二：通过遍历数组统计个数找出超过一半的数字
     * 当后一个数与前一个数相同时，计数+1；不同时，计数-1；如果数字为0，则保存下一个数，数字置为1
     * 如果数组中某个数超过一半的数量，则遍历后统计的为该数
     */
    private static int getMoreThanHalfUsingCount(int[] source) {
        if (source == null || source.length == 0) {
            return -1;
        }

        if (source.length == 1) {
            return source[0];
        }

        int result = source[0];
        int times = 1;

        for (int i = 1; i < source.length; i ++) {
            if (times == 0) {
                result = source[i];
                times = 1;
            } else if (result == source[i]) {
                times ++;
            } else {
                times --;
            }
        }

        return checkMoreThanHalf(source, result) ? result : -1;
    }

    private static boolean checkMoreThanHalf(int[] data, int target) {
        int times = 0;
        for (int aData : data) {
            if (aData == target) {
                times++;
            }
        }

        return times * 2 >= data.length;
    }
}
