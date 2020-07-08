package com.dengzm.lib.leetcode.lc_301_400;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 验证二叉树的前序序列化
 * @date 2020/6/27 12:33
 */
public class Leetcode331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }

        String[] nodes = preorder.split(",");
        int ans = isValidSerializationCore(nodes, 0);
        return ans == nodes.length - 1;
    }

    private int isValidSerializationCore(String[] nodes, int index) {
        if (index >= nodes.length) {
            return nodes.length + 1;
        }

        if (nodes[index].equals("#")) {
            return index;
        }

        int i = isValidSerializationCore(nodes, index+1);
        return isValidSerializationCore(nodes, i+1);
    }
}
