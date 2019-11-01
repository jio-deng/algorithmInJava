package com.dengzm.lib;

/**
 * @Description 051 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求逆序对的总数
 * 例如：数组{7,5,6,4}中有5个逆序对，分别为{7,6}, {7,5}, {7,4}, {6,4}, {5,4}
 *
 * Created by deng on 2019/9/22.
 */
public class Jianzhi051 {

    public static void main(String[] args) {
        int[] data1 = new int[] {7, 5, 6, 4};
        int[] data2 = new int[] {7, 5, 6, 4, 8, 1};
        int[] data3 = new int[] {7, 5, 6, 4, 1};
        int[] data4 = new int[] {7, 5, 6, 4, 10, 5, 4, 19, 2};

        System.out.println("inverse pairs num is " + countInversePairs(data1));
        System.out.println("inverse pairs num is " + countInversePairs(data2));
        System.out.println("inverse pairs num is " + countInversePairs(data3));
        System.out.println("inverse pairs num is " + countInversePairs(data4));
    }

    /**
     * 通过归并排序的方式进行统计
     * 拆分data，合并时对逆序对进行统计
     *
     * @param data data
     * @return num of inverse pairs
     */
    private static int countInversePairs(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }

        // 复制数组，不直接使用原始数据
        int[] copy = new int[data.length];

        System.arraycopy(data, 0, copy, 0, data.length);

        return countInversePairsCore(copy, 0, data.length - 1);
    }

    private static int countInversePairsCore(int[] copy, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int length = (end - start) / 2;

        int left = countInversePairsCore(copy, start, start + length);
        int right = countInversePairsCore(copy, start + length + 1, end);

        // 初始化前后半段的最后一个数字的下标
        int i = start + length;
        int j = end;

        // 临时数据
        int[] temp = new int[end - start + 1];

        // 临时数据的下标
        int indexCopy = end - start;

        // return result
        int count = 0;

        // 归并-合并时，如果前段大于后段，则增加count，因为前后半段各自都是递增的，所以增加的数量为end - mid
        while (i >= start && j >= start + length + 1) {
            if (copy[i] > copy[j]) {
                temp[indexCopy --] = copy[i --];
                count += j - start - length;
            } else {
                temp[indexCopy --] = copy[j --];
            }
        }

        // 将剩余数据复制到临时数据
        while (i >= start) {
            temp[indexCopy --] = copy[i --];
        }

        while (j >= start + length + 1) {
            temp[indexCopy --] = copy[j --];
        }

        // 将临时数据同步回copy，保证合并后的数据为递增
        System.arraycopy(temp, 0, copy, start, temp.length);

        return left + right + count;
    }


}
