package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/3/23 11:10
 */
public class LeetcodeComp200322 {
    /**
     * 1389. 按既定顺序创建目标数组
     * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
     *
     * 目标数组 target 最初为空。
     * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
     * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
     * 请你返回目标数组。
     *
     * 题目保证数字插入位置总是存在。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
     * 输出：[0,4,1,3,2]
     * 解释：
     * nums       index     target
     * 0            0        [0]
     * 1            1        [0,1]
     * 2            2        [0,1,2]
     * 3            2        [0,1,3,2]
     * 4            1        [0,4,1,3,2]
     * 示例 2：
     *
     * 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
     * 输出：[0,1,2,3,4]
     * 解释：
     * nums       index     target
     * 1            0        [1]
     * 2            1        [1,2]
     * 3            2        [1,2,3]
     * 4            3        [1,2,3,4]
     * 0            0        [0,1,2,3,4]
     * 示例 3：
     *
     * 输入：nums = [1], index = [0]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 1 <= nums.length, index.length <= 100
     * nums.length == index.length
     * 0 <= nums[i] <= 100
     * 0 <= index[i] <= i
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        if (nums.length == 0 || index.length == 0) {
            return new int[] {};
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (index[i] >= list.size()) {
                list.add(nums[i]);
            } else {
                list.add(index[i], nums[i]);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            ans[i] = list.get(i);
        }

        return ans;
    }


    /**
     * 1390. 四因数
     * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
     *
     * 如果数组中不存在满足题意的整数，则返回 0 。
     *
     *
     *
     * 示例：
     *
     * 输入：nums = [21,4,7]
     * 输出：32
     * 解释：
     * 21 有 4 个因数：1, 3, 7, 21
     * 4 有 3 个因数：1, 2, 4
     * 7 有 2 个因数：1, 7
     * 答案仅为 21 的所有因数的和。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^4
     * 1 <= nums[i] <= 10^5
     */
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }

        for (int num : nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= Math.sqrt(num); i ++) {
                if (num % i == 0) {
                    set.add(i);
                    set.add(num / i);

                    if (set.size() > 4) {
                        break;
                    }
                }
            }

            if (set.size() == 4) {
                for (Integer integer : set) {
                    ans += integer;
                }
            }
        }

        return ans;
    }


    /**
     * 1391. 检查网格中是否存在有效路径
     * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
     *
     * 1 表示连接左单元格和右单元格的街道。
     * 2 表示连接上单元格和下单元格的街道。
     * 3 表示连接左单元格和下单元格的街道。
     * 4 表示连接右单元格和下单元格的街道。
     * 5 表示连接左单元格和上单元格的街道。
     * 6 表示连接右单元格和上单元格的街道。
     *
     *
     * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
     *
     * 注意：你 不能 变更街道。
     *
     * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：grid = [[2,4,3],[6,5,2]]
     * 输出：true
     * 解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
     * 示例 2：
     *
     *
     *
     * 输入：grid = [[1,2,1],[1,2,1]]
     * 输出：false
     * 解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
     * 示例 3：
     *
     * 输入：grid = [[1,1,2]]
     * 输出：false
     * 解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
     * 示例 4：
     *
     * 输入：grid = [[1,1,1,1,1,1,3]]
     * 输出：true
     * 示例 5：
     *
     * 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
     * 输出：true
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * 1 <= grid[i][j] <= 6
     */
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        return findPath(grid, isVisited, 0, 0);
    }

    private boolean findPath(int[][] grid, boolean[][] isVisited, int x, int y) {
        int n = grid.length, m = grid[0].length;
        if (x == m - 1 && y == n - 1) {
            return true;
        }

        if (x >= m || x < 0 || y >= n || y < 0 || isVisited[y][x]) {
            return false;
        }

        isVisited[y][x] = true;

        int g = grid[y][x];
        if (g == 1) {
            if (x + 1 < m && grid[y][x+1] % 2 == 1) {
                if (findPath(grid, isVisited, x + 1, y)) {
                    return true;
                }
            }

            if (x - 1 >= 0 && (grid[y][x-1] == 1 || grid[y][x-1] == 4 || grid[y][x-1] == 6)) {
                if (findPath(grid, isVisited, x - 1, y)) {
                    return true;
                }
            }
        } else if (g == 2) {
            if (y + 1 < n && (grid[y+1][x] == 2 || grid[y+1][x] == 5 || grid[y+1][x] == 6)) {
                if (findPath(grid, isVisited, x, y + 1)) {
                    return true;
                }
            }

            if (y - 1 >= 0 && (grid[y-1][x] == 2 || grid[y-1][x] == 3 || grid[y-1][x] == 4)) {
                if (findPath(grid, isVisited, x, y - 1)) {
                    return true;
                }
            }
        } else if (g == 3) {
            if (y + 1 < n && (grid[y+1][x] == 2 || grid[y+1][x] == 5 || grid[y+1][x] == 6)) {
                if (findPath(grid, isVisited, x, y + 1)) {
                    return true;
                }
            }

            if (x - 1 >= 0 && (grid[y][x-1] == 1 || grid[y][x-1] == 4 || grid[y][x-1] == 6)) {
                if (findPath(grid, isVisited, x - 1, y)) {
                    return true;
                }
            }
        } else if (g == 4) {
            if (y + 1 < n && (grid[y+1][x] == 2 || grid[y+1][x] == 5 || grid[y+1][x] == 6)) {
                if (findPath(grid, isVisited, x, y + 1)) {
                    return true;
                }
            }

            if (x + 1 < m && grid[y][x+1] % 2 == 1) {
                if (findPath(grid, isVisited, x + 1, y)) {
                    return true;
                }
            }
        } else if (g == 5) {
            if (y - 1 >= 0 && (grid[y-1][x] == 2 || grid[y-1][x] == 3 || grid[y-1][x] == 4)) {
                if (findPath(grid, isVisited, x, y - 1)) {
                    return true;
                }
            }

            if (x - 1 >= 0 && (grid[y][x-1] == 1 || grid[y][x-1] == 4 || grid[y][x-1] == 6)) {
                if (findPath(grid, isVisited, x - 1, y)) {
                    return true;
                }
            }
        } else if (g == 6) {
            if (y - 1 >= 0 && (grid[y-1][x] == 2 || grid[y-1][x] == 3 || grid[y-1][x] == 4)) {
                if (findPath(grid, isVisited, x, y - 1)) {
                    return true;
                }
            }

            if (x + 1 < m && grid[y][x+1] % 2 == 1) {
                if (findPath(grid, isVisited, x + 1, y)) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * 1392. 最长快乐前缀
     * 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
     *
     * 给你一个字符串 s，请你返回它的 最长快乐前缀。
     *
     * 如果不存在满足题意的前缀，则返回一个空字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "level"
     * 输出："l"
     * 解释：不包括 s 自己，一共有 4 个前缀（"l", "le", "lev", "leve"）和 4 个后缀（"l", "el", "vel", "evel"）。最长的既是前缀也是后缀的字符串是 "l" 。
     * 示例 2：
     *
     * 输入：s = "ababab"
     * 输出："abab"
     * 解释："abab" 是最长的既是前缀也是后缀的字符串。题目允许前后缀在原字符串中重叠。
     * 示例 3：
     *
     * 输入：s = "leetcodeleet"
     * 输出："leet"
     * 示例 4：
     *
     * 输入：s = "a"
     * 输出：""
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 10^5
     * s 只含有小写英文字母
     */
    public String longestPrefix(String s) {
        int[] next = getNext(s);
        int n = next[s.length()];
        return s.substring(0, n);
    }

    private int[] getNext(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(j) == s.charAt(i))
                // 已有 [0, ..., j - 1] 与 [i - j, ..., i - 1] 匹配, 同时 s[j] == s[i]
                next[++i] = ++j;
                // 匹配长度增加 1, 查看下一个匹配位置
            else
                j = next[j];
            // 不匹配, 说明当前查看的前缀太长, 将 j 跳回到上一个可能的匹配位置
        }
        return next;
    }


}
