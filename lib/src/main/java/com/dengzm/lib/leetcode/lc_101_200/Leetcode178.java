package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 分数排名
 * @date 2020/4/3 10:00
 */
public class Leetcode178 {
    /**
     * # Write your MySQL query statement below
     * select s1.Score,count(distinct(s2.score)) Rank
     * from
     * Scores s1,Scores s2
     * where
     * s1.score<=s2.score
     * group by s1.Id
     * order by Rank
     */
}
