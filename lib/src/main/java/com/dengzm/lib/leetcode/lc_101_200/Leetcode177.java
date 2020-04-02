package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 第N高的薪水
 * @date 2020/4/2 13:59
 */
public class Leetcode177 {
    /**
     * CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
     * BEGIN
     *   SET N = N - 1;
     *   RETURN (
     *       # Write your MySQL query statement below.
     *       SELECT DISTINCT salary FROM employee ORDER BY salary DESC LIMIT N, 1
     *   );
     * END
     */
}
