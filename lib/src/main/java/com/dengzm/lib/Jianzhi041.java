package com.dengzm.lib;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Description 041 数据流中的中位数
 *
 * Created by deng on 2019/9/18.
 */
public class Jianzhi041 {

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 100; i ++) {
            int random = new Random().nextInt(100);
            array.insert(random);
            System.out.println("Random = " + random + ", Middle Number is " + array.getMiddleNumber());
        }
    }

    public static class DynamicArray {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public DynamicArray() {
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            minHeap = new PriorityQueue<>();
        }


        public void insert(int target) {
            if (getCount() % 2 == 0) {
                // 偶数，先插入最大堆，需对比值大小
                if (minHeap.size() != 0 && target > minHeap.peek()) {
                    minHeap.offer(target);
                    target = minHeap.poll();
                }

                maxHeap.offer(target);
            } else {
                // 奇数，此时插入最小堆，需对比值大小
                if (maxHeap.size() != 0 && target < maxHeap.peek()) {
                    maxHeap.offer(target);
                    target = maxHeap.poll();
                }

                minHeap.offer(target);
            }
        }

        public float getMiddleNumber() {
            if (getCount() == 0) {
                return 0;
            }

            float result;

            if (getCount() % 2 == 0) {
                result = (((float) maxHeap.peek()) + ((float) minHeap.peek()) ) / 2;
            } else {
                result = (float) maxHeap.peek();
            }

            return result;
        }

        public int getCount() {
            return maxHeap.size() + minHeap.size();
        }
    }

}
