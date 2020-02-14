package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 上升的温度
 * @date 2020/2/13 12:49
 */
public class Leetcode197 {
    /**
     * # Write your MySQL query statement below
     *
     * #select Id as Weather
     * #from Weather w1, Weather w2
     * #where w1.Id - w2.Id = 1 and w1.Temperature > w2.Temperature;
     *
     * select a.Id
     * from Weather as a join Weather as b
     * on a.Temperature > b.Temperature and dateDiff(a.RecordDate,b.RecordDate) = 1
     */
}
