package com.dengzm.lib.leetcode.lc_101_200;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 部门工资最高的员工
 * @date 2020/4/3 11:05
 */
public class Leetcode184 {
    /**
     * # Write your MySQL query statement below
     * select d.Name as Department, e.Name as Employee, e.Salary
     * from Department d, Employee e
     * where e.DepartmentId = d.id and (e.Salary, e.DepartmentId) in (select max(Salary), DepartmentId from Employee group by DepartmentId)
     */
}
