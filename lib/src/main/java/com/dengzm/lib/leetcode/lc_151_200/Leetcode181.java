package com.dengzm.lib.leetcode.lc_151_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 超过经理收入的员工
 * @date 2020/2/13 10:43
 */
public class Leetcode181 {
    /**
     * # Write your MySQL query statement below
     * SELECT
     *     a.Name AS 'Employee'
     * FROM
     *     Employee AS a,
     *     Employee AS b
     * WHERE
     *     a.ManagerId = b.Id
     *         AND a.Salary > b.Salary
     */
}
