package com.dengzm.lib.leetcode.lc_1101_1200;

import java.util.concurrent.Semaphore;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 按序打印
 * @date 2020/3/26 10:42
 */
public class Leetcode1114 {

    class Foo {
        public Semaphore seam_first_two = new Semaphore(0);

        public Semaphore seam_two_second = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            seam_first_two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            seam_first_two.acquire();
            printSecond.run();
            seam_two_second.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            seam_two_second.acquire();
            printThird.run();
        }
    }
}
