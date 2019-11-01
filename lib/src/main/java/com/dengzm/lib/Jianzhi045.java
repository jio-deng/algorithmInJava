package com.dengzm.lib;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Description Created by deng on 2019/9/21.
 */
public class Jianzhi045 {
    public static void main(String[] args) {
        int[] data1 = new int[] {3, 32, 321};
        int[] data2 = new int[] {3, 32, 321, 132};
        int[] data3 = new int[] {3, 32, 321, 12};
        int[] data4 = new int[] {3, 32, 321, 1};

        printMinNumber(data1);
        printMinNumber(data2);
        printMinNumber(data3);
        printMinNumber(data4);
    }

    /**
     * 这里借用了别人的实现方法，贴出原文
     * https://www.cnblogs.com/yongh/p/9949312.html
     */
    private static void printMinNumber(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i : data) {
            list.add(String.valueOf(i));
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String combine1 = o1 + o2;
                String combine2 = o2 + o1;

                return combine1.compareTo(combine2);
            }
        });

        StringBuilder sb= new StringBuilder();
        for(String str:list) {
            sb.append(str);
        }

        System.out.println(sb.toString());
    }
}
