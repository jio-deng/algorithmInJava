package com.dengzm.lib.leetcode.lc_201_300;

import com.dengzm.lib.leetcode.lc.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 二叉树的序列化与反序列化
 * @date 2020/6/16 9:51
 */
public class Leetcode297 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            serializeCore(root, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private void serializeCore(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null,");
                return;
            }

            sb.append(node.val).append(",");
            serializeCore(node.left, sb);
            serializeCore(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.equals("")) {
                return null;
            }

            String[] strings = data.split(",");
            return deserializeCore(strings, new A(0));
        }

        private TreeNode deserializeCore(String[] strings, A a) {
            if (a.index >= strings.length || strings[a.index].equals("null")) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.valueOf(strings[a.index]));
            a.index ++;
            node.left = deserializeCore(strings, a);
            a.index ++;
            node.right = deserializeCore(strings, a);

            return node;
        }

        public class A {
            public int index;

            public A(int index) {
                this.index = index;
            }
        }
    }


//    public class Codec {
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            if (root == null) {
//                return "";
//            }
//
//            LinkedList<A> queue = new LinkedList<>();
//            queue.add(new A(root, 0));
//
//            StringBuilder sb = new StringBuilder();
//            int curLevel = -1;
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                while (size > 0) {
//                    A a = queue.poll();
//                    curLevel ++;
//                    while (curLevel < a.level) {
//                        sb.append("null,");
//                        curLevel ++;
//                    }
//
//                    sb.append(a.node.val).append(",");
//                    if (a.node.left != null) {
//                        queue.add(new A(a.node.left, a.level * 2 + 1));
//                    }
//
//                    if (a.node.right != null) {
//                        queue.add(new A(a.node.right, a.level * 2 + 2));
//                    }
//
//                    size --;
//                }
//            }
//
//            if (sb.length() > 0) {
//                sb.deleteCharAt(sb.length() - 1);
//            }
//
//            return sb.toString();
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            if (data == null || data.equals("")) {
//                return null;
//            }
//
//            String[] strings = data.split(",");
//            Map<Integer, TreeNode> map = new HashMap<>();
//
//            for (int i = 0; i < strings.length; i ++) {
//                if (strings[i].equals("null")) {
//                    continue;
//                }
//
//                map.put(i, new TreeNode(Integer.valueOf(strings[i])));
//                if (i != 0) {
//                    if (i % 2 == 1) {
//                        map.get((i-1)/2).left = map.get(i);
//                    } else {
//                        map.get((i-1)/2).right = map.get(i);
//                    }
//                }
//            }
//
//            return map.get(0);
//        }
//
//        private class A {
//            TreeNode node;
//            int level;
//
//            public A(TreeNode node, int level) {
//                this.node = node;
//                this.level = level;
//            }
//        }
//    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
