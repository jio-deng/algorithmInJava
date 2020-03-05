package com.dengzm.lib.trees;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 堆
 * @date 2020/2/22 16:04
 */
public class Heap {
    // https://www.cnblogs.com/ysocean/p/8032660.html
    // Java手写小顶堆 - https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/solution/javashou-xie-xiao-ding-dui-by-kelvin-24/

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean insert(int key) {
        if(isFull()) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    //向上调整
    public void trickleUp(int index) {
        int parent = (index - 1) / 2; //父节点的索引
        Node bottom = heapArray[index]; //将新加的尾节点存在bottom中
        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    //向下调整
    public void trickleDown(int index) {
        Node top = heapArray[index];
        int largeChildIndex;
        while(index < currentSize/2) { //while node has at least one child
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            //find larger child
            if(rightChildIndex < currentSize &&  //rightChild exists?
                    heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
                largeChildIndex = rightChildIndex;
            }
            else {
                largeChildIndex = leftChildIndex;
            }
            if(top.getKey() >= heapArray[largeChildIndex].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
        heapArray[index] = top;
    }

    //根据索引改变堆中某个数据
    public boolean change(int index, int newValue) {
        if(index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if(oldValue < newValue) {
            trickleUp(index);
        }
        else {
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap() {
        System.out.println("heapArray(array format): ");
        for(int i = 0; i < currentSize; i++) {
            if(heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            }
            else {
                System.out.print("--");
            }
        }
    }

    class Node {
        private int iData;

        public Node(int key) {
            iData = key;
        }

        public int getKey() {
            return iData;
        }

        public void setKey(int key) {
            iData = key;
        }
    }







    /** API **/

    // 建堆。对于一个还没维护过的堆，从他的最后一个节点的父节点开始进行调整。
    public void buildHeap(int[] nums) {
        // 最后一个节点
        int lastNode = nums.length - 1;
        // 记住：父节点 = (i - 1) / 2  左节点 = 2 * i + 1  右节点 = 2 * i + 2;
        // 最后一个节点的父节点
        int startHeapify = (lastNode - 1) / 2;
        while (startHeapify >= 0) {
            //不断调整建堆的过程
            heapify(nums, startHeapify --);
        }
    }

    // 调整大顶堆的过程
    private void heapify(int[] nums, int i) {
        // 和当前节点的左右节点比较，如果节点中有更大的数，那么交换，并继续对交换后的节点进行维护
        int len = nums.length;
        if (i >= len) {
            return;
        }

        // 左右子节点
        int c1 = ((i << 1) + 1), c2 = ((i << 1) + 2);
        // 假定当前节点最大
        int max = i;
        // 如果左子节点比较大，更新max = c1;
        if (c1 < len && nums[c1] > nums[max]) {
            max = c1;
        }
        // 如果右子节点比较大，更新max = c2;
        if (c2 < len && nums[c2] > nums[max]) {
            max = c2;
        }
        // 如果最大的数不是节点i的话，那么heapify(nums, max)，即调整节点i的子树。
        if (max != i) {
            swap(nums, max, i);
            // 递归处理
            heapify(nums, max);
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
    }
}
