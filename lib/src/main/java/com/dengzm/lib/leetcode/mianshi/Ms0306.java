package com.dengzm.lib.leetcode.mianshi;

import java.util.LinkedList;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 面试题 03.06. 动物收容所
 * @date 2020/4/9 18:09
 */
public class Ms0306 {
    class AnimalShelf {
        int time = 0;
        LinkedList[] queues = new LinkedList[2];
        LinkedList[] times = new LinkedList[2];

        public AnimalShelf() {
            queues[0] = new LinkedList<Integer>();
            queues[1] = new LinkedList<Integer>();
            times[0] = new LinkedList<Integer>();
            times[1] = new LinkedList<Integer>();
        }

        public void enqueue(int[] animal) {
            queues[animal[1]].offer(animal[0]);
            times[animal[1]].offer(time);
            time ++;
        }

        public int[] dequeueAny() {
            int[] res = new int[] {-1, -1};

            if (times[0].isEmpty() && times[1].isEmpty()) {
                return res;
            }

            int time0 = times[0].isEmpty() ? 20001 : (int) times[0].peek();
            int time1 = times[1].isEmpty() ? 20001 : (int) times[1].peek();

            if (time0 < time1) {
                res[0] = (int) queues[0].poll();
                times[0].poll();
                res[1] = 0;
            } else {
                res[0] = (int) queues[1].poll();
                times[1].poll();
                res[1] = 1;
            }

            return res;
        }

        public int[] dequeueDog() {
            int[] res = new int[2];
            if (queues[1].isEmpty()) {
                res[0] = -1;
                res[1] = -1;
            } else {
                res[0] = (int) queues[1].poll();
                res[1] = 1;
                times[1].poll();
            }

            return res;
        }

        public int[] dequeueCat() {
            int[] res = new int[2];
            if (queues[0].isEmpty()) {
                res[0] = -1;
                res[1] = -1;
            } else {
                res[0] = (int) queues[0].poll();
                res[1] = 0;
                times[0].poll();
            }

            return res;
        }
    }

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
}
