package com.dengzm.lib.leetcode.lc_601_700;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 员工的重要性
 * @date 2020/3/1 10:02
 */
public class Leetcode690 {
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        LinkedList<Employee> queue = new LinkedList<>();
        queue.add(findEmployee(employees, id));

        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            ans += e.importance;
            for (int i : e.subordinates) {
                queue.add(findEmployee(employees, i));
            }
        }

        return ans;
    }

    private Employee findEmployee(List<Employee> employees, int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                employees.remove(e);
                return e;
            }
        }

        return null;
    }

    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
