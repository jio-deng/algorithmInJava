package com.dengzm.lib.graph;

import java.util.ArrayList;

/**
 * @description node for tree
 *
 * @author Johnny Deng
 * @version 1.0
 * @date 2019/11/14 11:35
 */
public class TreeNode {
    public int value; // 到父节点的权值
    public int index;
    public int parentIndex;
    public ArrayList<TreeNode> children;

    public TreeNode() {
        this(-1, -1, 0);
    }

    public TreeNode(int index, int parentIndex, int value) {
        this.index = index;
        this.parentIndex = parentIndex;
        this.value = value;
        children = new ArrayList<>();
    }

    public boolean addChild(TreeNode node) {
        if (node.parentIndex == index) {
            children.add(node);
            return true;
        }

        if (children.size() > 0) {
            for (TreeNode child : children) {
                boolean result = child.addChild(node);
                if (result) {
                    break;
                }
            }
        }

        return false;
    }

    /**
     * 深度优先遍历打印
     */
    public void printTree() {
        System.out.println("TreeNode index is " + index + " , value is " + value + " , parent index is " + parentIndex);
        if (children.size() > 0) {
            for (TreeNode node : children) {
                node.printTree();
            }
        }
    }
}
