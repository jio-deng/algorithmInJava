package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 连续出现的数字
 * @date 2020/4/3 10:21
 */
public class Leetcode180 {
    /**
     * # Write your MySQL query statement below
     * select distinct Num as ConsecutiveNums
     * from (
     *     select Num,
     *         case
     *             when @prev = Num then @count := @count + 1
     *             when (@prev := Num) is not null then @count := 1
     *         end as CNT
     *     from Logs, (select @prev := null, @count := null) as t
     * ) as temp
     * where temp.CNT >= 3
     *
     *
     * select distinct a.Num as ConsecutiveNums
     * from Logs as a,Logs as b,Logs as c
     * where a.Num=b.Num and b.Num=c.Num and a.id=b.id-1 and b.id=c.id-1;
     */
}
