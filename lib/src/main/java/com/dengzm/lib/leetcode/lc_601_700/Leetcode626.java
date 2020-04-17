package com.dengzm.lib.leetcode.lc_601_700;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 换座位
 * @date 2020/4/17 14:18
 */
public class Leetcode626 {
    /**
     * # Write your MySQL query statement below
     * SELECT (CASE
     *             WHEN MOD(id,2) = 1 AND id = (SELECT COUNT(*) FROM seat) THEN id
     *             WHEN MOD(id,2) = 1 THEN id+1
     *             ElSE id-1
     *         END) AS id, student
     * FROM seat
     * ORDER BY id;
     */
}
