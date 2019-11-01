package com.dengzm.lib;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description 059 队列最大值
 * 题目一：滑动窗口的最大值
 * 例如：数组[2,3,4,2,6,2,5]，窗口大小为3，得到的最大值为[4,4,6,6,6,5]
 * 题目二：队列的最大值
 * 请定义一个队列，实现函数max得到队列的最大值，max、push_back、pop_front的时间复杂度为O(1)
 *
 *
 * Created by deng on 2019/10/31.
 */
public class Jianzhi059 {

    public static void main(String[] args) {
        int[] data1 = new int[] {2,3,4,2,6,2,5,1};
        System.out.println(maxValuesInWindow(data1, 3).toString());

        QueueWithMax<Integer> queue = new QueueWithMax<>();
        queue.push_back(6);
        queue.push_back(6);
        queue.push_back(6);
        queue.push_back(2);
        queue.push_back(3);
        queue.push_back(5);
        queue.push_back(4);
        queue.push_back(2);
        queue.push_back(2);
        queue.push_back(1);
        for (int i = 0; i < 10; i ++) {
            System.out.println("Max is " + queue.max());
            queue.pop_front();
        }
    }

    /**
     * 题目一
     * 使用链表，保存当前窗口中最大值的下标
     * 保存最大值的同时，也保存后续添加进入的值中，小于最大值的值，当最大值滑出窗口后，第二大值自动变为最大值
     *
     * @param data data
     * @param size window size
     * @return max values
     */
    private static ArrayList<Integer> maxValuesInWindow(int[] data, int size) {
        ArrayList<Integer> maxValuesInWindow = new ArrayList<>();

        if (data == null || data.length == 0 || size < 1) {
            return maxValuesInWindow;
        }

        // 保存最大值的下标
        LinkedList<Integer> indexQueue = new LinkedList<>();

        // 初始化，在前size个数中，找到最大的数，并记录下标
        for (int i = 0; i < size; i ++) {
            while (!indexQueue.isEmpty() && data[i] >= data[indexQueue.getFirst()]) {
                indexQueue.removeLast();
            }

            indexQueue.addLast(i);
        }

        // 边界判断
        if (size >= data.length - 1) {
            maxValuesInWindow.add(data[indexQueue.getFirst()]);
            return maxValuesInWindow;
        }

        // 滑动窗口
        for (int i = size; i < data.length; i ++) {
            // 结果中保存最大值
            maxValuesInWindow.add(data[indexQueue.getFirst()]);

            // 滑动窗口，获得的新数字，需要与之前的数字进行对比
            // 如果大于之前的数字，要把之前的去掉
            while (!indexQueue.isEmpty() && data[i] >= data[indexQueue.getLast()]) {
                indexQueue.removeLast();
            }

            // 判断当前最大的数字，是否已经被滑出了窗口
            if (!indexQueue.isEmpty() && indexQueue.getFirst() <= (i - size)) {
                indexQueue.removeFirst();
            }

            indexQueue.addLast(i);
        }

        maxValuesInWindow.add(data[indexQueue.getFirst()]);

        return maxValuesInWindow;
    }

    /**
     * 题目二
     *
     * 与题目一类似，利用一个额外的队列保存最大值
     */
    public static class QueueWithMax<T extends Comparable> {
        private LinkedList<InternalData> data;
        private LinkedList<InternalData> maxMembers;

        private int currentIndeX;

        public QueueWithMax() {
            currentIndeX = 0;
            data = new LinkedList<>();
            maxMembers = new LinkedList<>();
        }

        public void push_back(T number) {
            // 此处的边界判断与书上不同，应该为大于，不是大于等于
            while (!maxMembers.isEmpty() && number.compareTo(maxMembers.getLast().value) > 0) {
                maxMembers.removeLast();
            }

            InternalData internalData = new InternalData(number, currentIndeX);
            data.addLast(internalData);
            maxMembers.addLast(internalData);

            currentIndeX ++;
        }

        public InternalData pop_front() {
            if (maxMembers.isEmpty()) {
                throw new RuntimeException("Queue is empty.");
            }

            if (maxMembers.getFirst().value == data.getFirst().value) {
                maxMembers.removeFirst();
            }

            return data.removeFirst();
        }

        public T max() {
            if (maxMembers.isEmpty()) {
                throw new RuntimeException("Queue is empty.");
            }

            return maxMembers.peekFirst().value;
        }


        private class InternalData {
            T value;
            int index;

            InternalData(T value, int index) {
                this.value = value;
                this.index = index;
            }
        }

    }
}
