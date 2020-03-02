package com.dengzm.lib.leetcode.lc_701_800;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 数据流中的第K大元素
 * @date 2020/3/2 10:00
 */
public class Leetcode703 {

    static class KthLargest {
        int k;
        PriorityQueue<Integer> heap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i : nums) {
                add(i);
            }
        }

        public int add(int val) {
            if (heap.size() < k) {
                heap.offer(val);
            } else if (heap.peek() < val) {
                heap.poll();
                heap.offer(val);
            }

            return heap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[] {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);// returns 4
        kthLargest.add(5);// returns 5
        kthLargest.add(10);// returns 5
        kthLargest.add(9);// returns 8
        kthLargest.add(4);// returns 8
    }
}
