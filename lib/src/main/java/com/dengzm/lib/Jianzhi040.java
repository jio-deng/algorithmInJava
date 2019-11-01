package com.dengzm.lib;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description 040 最小的k个数
 * 输入n个整数，找出其中最小的k个数
 *
 * Created by deng on 2019/9/18.
 */
public class Jianzhi040 {

    public static void main(String[] args) {
        int[] data1 = new int[] {1,2,3,4,5,6,7,8,9,1,1,1,1,1,1,1,1};
        int[] data2 = new int[] {1,2,3,4,5,6,6,6,6};

        getLeastNumbers(data1, 4);
        getLeastNumbers(data2, 4);
    }

    /**
     * 使用最大堆或者红黑树，选出k个数后，后续的数字与最大值进行比较、替换、排序，最后得出最小的k个数
     *
     * 书中使用的是该方法，但是该方法只针对不含重复数字的数组有效，因为Set不可以保存重复的数字
     * 故上面的两个测试项，第一个的结果是不对的。
     * 请知悉
     */
    private static void getLeastNumbers(int[] source, int k) {
        if (source == null || source.length == 0 || k < 1 || source.length < k) {
            System.out.println("data invalid");
            return;
        }

        TreeSet<Integer> result = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < source.length; i ++) {
            if (result.size() < k) {
                result.add(source[i]);
            } else {
                int max = result.iterator().next();
                if (max > source[i]) {
                    result.remove(max);
                    result.add(source[i]);
                }
            }
        }

        for (int integer : result) {
            System.out.println(integer);
        }
    }

}
