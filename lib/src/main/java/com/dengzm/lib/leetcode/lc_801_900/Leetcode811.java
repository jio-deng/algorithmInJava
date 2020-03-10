package com.dengzm.lib.leetcode.lc_801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 子域名访问计数
 * @date 2020/3/8 8:52
 */
public class Leetcode811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] ss = cpdomain.split(" ");
            int num = Integer.valueOf(ss[0]);
            map.put(ss[1], map.getOrDefault(ss[1], 0) + num);
            int index = 1;
            while (index < ss[1].length() - 1) {
                if (ss[1].charAt(index) == '.') {
                    String key = ss[1].substring(index + 1);
                    map.put(key, map.getOrDefault(key, 0) + num);
                }

                index ++;
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue()).append(" ").append(entry.getKey());
            result.add(sb.toString());
        }

        return result;
    }
}
