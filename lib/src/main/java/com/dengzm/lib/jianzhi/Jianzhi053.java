package com.dengzm.lib.jianzhi;

/**
 * @Description 053 在排序数组中查找数字
 * 题目一：数字在排序数组中出现的次数
 * 题目二：0～n-1中缺失的数字
 * 题目三：数组中数值和下标相等的元素:假设一个单调递增的数组里的每个元素都是整数并且唯一，请实现一个函数可以找出数组中任意一个数值等于其下标的元素
 *
 * Created by deng on 2019/10/29.
 */
public class Jianzhi053 {

    public static void main(String[] args) {
        int[] data1 = new int[] {1, 2, 3, 3, 3, 3, 4, 6};
        int[] data2 = new int[] {1, 2, 3, 3, 3, 3, 4, 4, 6, 7, 8};
        int[] data3 = new int[] {1, 2, 3, 3, 3, 3, 4, 6};

        int[] data4 = new int[] {0, 1, 2, 3, 4, 6, 7, 8, 9};
        int[] data5 = new int[] {0, 2};
        int[] data6 = new int[] {1};

        int[] data7 = new int[] {-3, -1, 0, 2, 4, 6, 8};
        int[] data8 = new int[] {-3, 1};
        int[] data9 = new int[] {0};
        int[] data10 = new int[] {-3};


        System.out.println("Q1:number of 3 in data1 is " + getNumberOfK(data1, 3));
        System.out.println("Q1:number of 4 in data2 is " + getNumberOfK(data2, 4));
        System.out.println("Q1:number of 4 in data3 is " + getNumberOfK(data3, 4));

        System.out.println("Q2:lost number in data4 is " + getLostNum(data4));
        System.out.println("Q2:lost number in data5 is " + getLostNum(data5));
        System.out.println("Q2:lost number in data6 is " + getLostNum(data6));

        System.out.println("Q3:the num of which is equal to its index in data7 is " + getNumEqualToIndex(data7));
        System.out.println("Q3:the num of which is equal to its index in data8 is " + getNumEqualToIndex(data8));
        System.out.println("Q3:the num of which is equal to its index in data9 is " + getNumEqualToIndex(data9));
        System.out.println("Q3:the num of which is equal to its index in data10 is " + getNumEqualToIndex(data10));
    }

    /**
     * 题目一
     * 通过二分法，找到数字k的第一个位置和最后一个的位置
     * 时间复杂度 O(logn)
     *
     * @param data data
     * @param k the num we are looking for
     * @return how many k in data
     */
    private static int getNumberOfK(int[] data, int k) {
        if (data == null || data.length == 0) {
            return 0;
        }

        int first = getFirstK(data, k, 0, data.length - 1);
        int last = getLastK(data, k, 0, data.length - 1);

        return first == -1 ? 0 : last - first + 1;
    }

    private static int getFirstK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (end + start) / 2;
        int middleData = data[middleIndex];

        if (middleData == k) {
            // 当前数字为k，开始判断是否为第一个k
            if (middleIndex == 0 || (middleIndex > 0 && data[middleIndex - 1] != k)) {
                // 当前位置下标为0 或 前一个数字不是k
                // 表示此时得到的下标即为第一个k
                return middleIndex;
            } else {
                // 下标不为0，且前一个数字为k，在前半段中再次进行二分查找
                end = middleIndex - 1;
            }
        } else {
            // 当前数字不为k，进行判断，在前后半段中的哪一个
            if (middleData > k) {
                end = middleIndex - 1;
            } else {
                start = middleIndex + 1;
            }
        }

        return getFirstK(data, k, start, end);
    }

    private static int getLastK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (end + start) / 2;
        int middleData = data[middleIndex];

        if (middleData == k) {
            // 当前数字为k，开始判断是否为最后一个k
            if (middleIndex == data.length - 1 || (middleIndex < data.length - 1 && data[middleIndex + 1] != k)) {
                // 当前位置下标为length-1 或 后一个数字不是k
                // 表示此时得到的下标即为最后一个k
                return middleIndex;
            } else {
                // 下标不为length-1，且后一个数字为k，在后半段中再次进行二分查找
                start = middleIndex + 1;
            }
        } else {
            // 当前数字不为k，进行判断，在前后半段中的哪一个
            if (middleData > k) {
                end = middleIndex - 1;
            } else {
                start = middleIndex + 1;
            }
        }

        return getLastK(data, k, start, end);
    }

    /**
     * 题目二
     * 0～n-1，数字大小与下标相同
     * 使用二分法进行查找，找到第一个下标与数字不等的位置，即为缺失的数字
     *
     * @param data data
     * @return the lost num
     */
    private static int getLostNum(int[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }

        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            // 当mid的下标与数字不等时，如果前一个相等，或是mid为0，则当前mid即为缺失的数字；否则继续在前半段查找
            if (data[middle] != middle) {
                if (middle == 0 || (data[middle - 1] == middle - 1)) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            } else {
                // 下标相等时，在后半段查找
                left = middle + 1;
            }
        }

        return -1;
    }

    /**
     * 题目三
     * 二分法查找：如果num > index，则在前半段查找；如果num < index, 则在后半段查找
     *
     * @param data data
     * @return num of which is equal to its index
     */
    private static int getNumEqualToIndex(int[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }

        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (data[middle] == middle) {
                return middle;
            } else if (data[middle] < middle) {
                // num < index, 则在后半段查找
                left = middle + 1;
            } else {
                // num > index，则在前半段查找
                right = middle - 1;
            }
        }

        return -1;
    }
}
