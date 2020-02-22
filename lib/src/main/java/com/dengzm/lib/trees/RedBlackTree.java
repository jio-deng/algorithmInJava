package com.dengzm.lib.trees;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 红黑树
 * @date 2020/2/22 11:02
 */
public class RedBlackTree<T extends Comparable<T>> {
    /**
     * https://www.cnblogs.com/ysocean/p/8004211.html
     *
     * 红-黑规则
     * 1.每个节点不是红色就是黑色的；
     * 2.根节点总是黑色的；
     * 3.如果节点是红色的，则它的子节点必须是黑色的（反之不一定）,(也就是从每个叶子到根的所有路径上不能有两个连续的红色节点)；
     * 4.从根节点到叶节点或空子节点的每条路径，必须包含相同数目的黑色节点（即相同的黑色高度）。
     *
     * 注意：新插入的节点颜色总是红色的，这是因为插入一个红色节点比插入一个黑色节点违背红-黑规则的可能性更小，
     * 原因是插入黑色节点总会改变黑色高度（违背规则4），但是插入红色节点只有一半的机会会违背规则3（因为父节点是黑色的没事，父节点是红色的就违背规则3）。
     * 另外违背规则3比违背规则4要更容易修正。
     */
    RBTreeNode<T> root;


    /******************************************  对红黑树节点x进行旋转操作 ************************************/
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBTreeNode<T> x) {
        // 1.将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBTreeNode<T> y = x.right;
        x.right = y.left;
        setParent(x.right, x);

        // 2.将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        setParent(y, x.parent);
        if(x.parent == null){
            this.root = y;//如果x的父节点为空(即x为根节点)，则将y设为根节点
        }else{
            if(x == x.parent.left){//如果x是左子节点
                x.parent.left = y;//则也将y设为左子节点
            }else{
                x.parent.right = y;//否则将y设为右子节点
            }
        }

        // 3.将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        setParent(x, y);
    }

    /*
     * 右旋示意图：对节点y进行右旋
     *        p                   p
     *         \                   \
     *          x                   y
     *         /  \                / \
     *        y   rx   ----->     ly  x
     *       / \                     / \
     *     ly  ry                   ry rx
     * 右旋做了三件事：
     * 1. 将y的右子节点赋给x的左子节点,并将x赋给y右子节点的父节点(y右子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的右子节点设为x，将x的父节点设为y
     */
    private void rightRotate(RBTreeNode<T> x) {
        RBTreeNode<T> y = x.left;
        x.left = y.right;
        setParent(x.left, x);

        setParent(y, x.parent);
        if (x.parent == null) {
            this.root = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        y.right = x;
        setParent(x, y);
    }

    private void setParent(RBTreeNode<T> node, RBTreeNode<T> p) {
        if (node != null) {
            node.parent = p;
        }
    }

    /***************************************** 向红黑树中插入节点 ****************************************/
    public void insert(T value) {
        RBTreeNode<T> node = new RBTreeNode<>(value, null, null, null, true);
        insert(node);
    }

    public void insert(RBTreeNode<T> node) {
        if (node == null) {
            return;
        }

        RBTreeNode<T> current = null;//表示最后node的父节点
        RBTreeNode<T> x = root;//用来向下搜索

        //1.找到插入位置
        while (x != null) {
            current = x;
            int cmp = x.value.compareTo(node.value);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = current;

        //2.接下来判断node是左子节点还是右子节点
        if (current != null) {
            int cmp = current.value.compareTo(node.value);
            if (cmp < 0) {
                current.left = node;
            } else {
                current.right = node;
            }
        } else {
            root = node;
        }

        //3.利用旋转操作将其修正为一颗红黑树
        insertFixUp(node);
    }

    /**
     * 如果是第一次插入，由于原树为空，所以只会违反红-黑树的规则2，所以只要把根节点涂黑即可；
     * 如果插入节点的父节点是黑色的，那不会违背红-黑树的规则，什么也不需要做；
     * 但是遇到如下三种情况，我们就要开始变色和旋转了：
     *
     * ①、插入节点的父节点和其叔叔节点（祖父节点的另一个子节点）均为红色。
     * ②、插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的右子节点。
     * ③、插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的左子节点。
     */
    private void insertFixUp(RBTreeNode<T> node) {
        RBTreeNode<T> parent,gparent;//定义父节点和祖父节点
        //需要修正的条件：父节点存在，且父节点的颜色是红色
        while ((parent = parentOf(node)) != null && parent.isRed) {
            gparent = parentOf(parent);

            // 若父节点是祖父节点的左子节点，下面的else相反
            if (parent == gparent.left) {
                RBTreeNode<T> uncle = gparent.right;

                // case1:叔叔节点也是红色
                if (uncle != null && uncle.isRed) {
                    parent.isRed = false;
                    uncle.isRed = false;
                    gparent.isRed = true;
                    node = gparent;
                    continue;
                }

                // case2:叔叔节点是黑色，且当前节点是右子节点
                if (node == parent.right) {
                    leftRotate(parent);//从父节点出左旋
                    RBTreeNode<T> tmp = parent;//然后将父节点和自己调换一下，为下面右旋做准备
                    parent = node;
                    node = tmp;
                }

                //case3:叔叔节点是黑色，且当前节点是左子节点
                parent.isRed = false;
                gparent.isRed = true;
                rightRotate(gparent);

            } else {
                RBTreeNode<T> uncle = gparent.left;
                if (uncle != null && uncle.isRed) {
                    parent.isRed = false;
                    uncle.isRed = false;
                    gparent.isRed = true;
                    node = gparent;
                    continue;
                }

                if (node == parent.left) {
                    rightRotate(parent);
                    RBTreeNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                parent.isRed = false;
                gparent.isRed = true;
                leftRotate(gparent);
            }
        }

        root.setColor(false);//将根节点设置为黑色
    }

    private RBTreeNode<T> parentOf(RBTreeNode<T> node) {
        if (node != null) {
            return node.parent;
        }

        return null;
    }

    /***************************************** TODO 红黑树删除节点 ****************************************/
    public boolean delete(T value) {
        RBTreeNode<T> current = root;//用来向下搜索

        //1.找到需要删除的节点
        while (current != null) {
            int cmp = current.value.compareTo(value);
            if (cmp == 0) {
                break;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return false;
        }

        if ((null != current.left) && (null != current.right)) {      //将要删除的节点下有两个子节点
            dleTwoChildrenNode(current);
        } else {
            if ((null == current.left) && (null == current.right)) {  //将要删除的节点没有子节点
                deleteLeafFix(current);
                if (current.value.compareTo(current.parent.value) > 0) {
                    current.parent.right = null;
                } else {
                    current.parent.left = null;
                }
            } else { // 将要删除的节点下有一个子节点,
                dleOneChildNode(current);
            }
        }

        return true;
    }

    /**
     * 处理被删除节点有一个子节点的情况
     * @param delNode
     */
    private void dleOneChildNode(RBTreeNode<T> delNode){
        RBTreeNode<T> replaceNode = (null == delNode.left) ? delNode.right : delNode.left;
        deltetLeafNode(delNode, replaceNode);
    }

    /**
     * 处理被删除节点有两个子节点的情况
     * @param target 将要被删除的节点
     */
    private void dleTwoChildrenNode(RBTreeNode<T> target){
        RBTreeNode<T> replaceNode = successor(target);
        if ((null == replaceNode.right) && (null == replaceNode.left)) {
            deltetLeafNode(target, replaceNode);
        } else {
            target.value =  replaceNode.value;
            dleOneChildNode(replaceNode);
        }
    }

    private void deltetLeafNode(RBTreeNode<T> target, RBTreeNode<T> replaceNode){
        target.value = replaceNode.value;
        deleteLeafFix(replaceNode);
        if(replaceNode == replaceNode.parent.right){
            replaceNode.parent.right = null;
        }else{
            replaceNode.parent.left = null;
        }
    }

    /**
     * case1: 兄弟节点是黑色的，且有一个左节点（可以断定 左节点是红色的）
     * case2: 兄弟节点是黑色的，且有一个右节点（可以断定 右节点是红色的）
     * case3: 兄弟节点是黑色的，且有两个节点（可以断定 左右节点都是红色的） 这个和情况 1 是一样的
     * case4: 兄弟节点是黑色的，且没有子节点
     * case5: 如果该兄弟节点是红色的，那么根据红黑树的特性可以得出它的一定有两个黑色的子节点
     */
    private void deleteLeafFix(RBTreeNode<T> node) {
        while ((node != root) && (!node.isRed)) {
            RBTreeNode<T> parent = node.parent;
            RBTreeNode<T> brother = getBrother(node);
            if (node.value.compareTo(parent.value) > 0) { // 删除的是右叶子节点
                if(brother.isRed){ // case5: 如果该兄弟节点是红色的，那么根据红黑树的特性可以得出它的一定有两个黑色的子节点
                    brother.isRed = false;
                    brother.right.isRed = true;
                    rightRotate(parent);
                    break;
                } else {
                    if ((null == brother.left) && (null == brother.right)) { // case4: 兄弟节点是黑色的，且没有子节点
                        brother.isRed = true; // 将兄弟节点设为红色，将父节点设为当前节点递归， 直到根节点，或遇到红色节点，
                        node = parent;
                    } else {
                        if ((null != brother.left) && (brother.left.isRed)) {// case1: 兄弟节点是黑色的，且有一个左节点（可以断定 左节点是红色的）
                            // case3: 兄弟节点是黑色的，且有两个节点（可以断定 左右节点都是红色的） 这个和情况 1 是一样的
                            brother.isRed = parent.isRed;
                            parent.isRed = false;
                            brother.left.isRed = false;
                            rightRotate(parent);
                            break;
                        } else {// case2: 兄弟节点是黑色的，且有一个右节点（可以断定 右节点是红色的）
                            brother.right.isRed = false;
                            brother.isRed = true;
                            leftRotate(brother);
                        }
                    }
                }
            } else {// 删除的是左叶子节点
                if (brother.isRed) { // case5 : 如果该兄弟节点是红色的，那么根据红黑树的特性可以得出它的一定有两个黑色的子节点
                    brother.isRed = false;
                    brother.left.isRed = true;
                    leftRotate(parent);
                    break;
                } else {
                    if ((null == brother.left) && (null == brother.right)) { // case4: 兄弟节点是黑色的，且没有子节点
                        brother.isRed = true; // 将兄弟节点设为红色，将父节点设为当前节点递归， 直到根节点，或遇到红色节点，
                        node = parent;
                    } else {
                        if ((null != brother.right) && (brother.right.isRed)) { // case1 : 兄弟节点是黑色的，且有一个右节点（可以断定 右节点是红色的）
                            // case3 : 兄弟节点是黑色的，且有两个节点（可以断定 左右节点都是红色的） 这个和情况 1 是一样的
                            brother.isRed = parent.isRed;
                            parent.isRed = false;
                            brother.right.isRed = false;
                            leftRotate(parent);
                            break;
                        } else { // case2: 兄弟节点是黑色的，且有一个左节点（可以断定 左节点是红色的）
                            brother.left.isRed = false;
                            brother.isRed = true;
                            rightRotate(brother);
                        }
                    }
                }
            }
        }

        node.isRed = false;
    }

    /**
     * 找后继结点。即，查找"红黑树中数据值大于该结点"的"最小结点"
     */
    private RBTreeNode<T> successor(RBTreeNode<T> node) {
        if (node == null) {
            return null;
        }

        if (null != node.right) { // 获取 后继节点
            RBTreeNode<T> p = node.right;
            while (null != p.left) {
                p = p.left;
            }
            return p;
        } else {
            RBTreeNode<T> p = node.parent;
            RBTreeNode<T> ch = node;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private RBTreeNode<T> getBrother(RBTreeNode<T> node){
        if (null == node) {
            return null;
        }

        RBTreeNode<T> parent = node.parent;
        if (null == parent) {
            return null;
        }

        if (node.value.compareTo(parent.value) > 0) {
            return parent.left;
        } else {
            return parent.right;
        }
    }


    class RBTreeNode<T extends Comparable<T>> {
        T value;
        RBTreeNode<T> left;
        RBTreeNode<T> right;
        RBTreeNode<T> parent;
        boolean isRed;

        public RBTreeNode(T value, RBTreeNode<T> parent, RBTreeNode<T> left, RBTreeNode<T> right, boolean isRed) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.isRed = isRed;
        }

        public T getValue() {
            return value;
        }

        private void setColor(boolean isRed) {
            this.isRed = isRed;
        }

        public String toString() {
            return "value = " + value + ", isRed = " + isRed;
        }
    }


    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        RedBlackTree<Integer> bst = new RedBlackTree<>();

        bst.insert(100);
        bst.insert(50);
        bst.insert(150);
        bst.insert(20);
        bst.insert(85);
        bst.insert(10);
        bst.insert(15);
        bst.insert(75);
        bst.insert(95);
        bst.insert(65);
        bst.insert(76);
        bst.insert(60);
        bst.insert(66);
        bst.insert(61);


        // 当前节点是左节点 的 5中情况
        bst.delete(15); // 1. 兄弟节点是黑色的，且有一个右节点（可以断定 右节点是红色的）

        // 2. 兄弟节点是黑色的，且有一个左节点（可以断定 左节点是红色的
        //bst.insert(140);
        //bst.delete(95);

        // 4. 兄弟节点是黑色的，且没有子节点
        //bst.delete(66);

        //5. 如果该兄弟节点是红色的，那么根据红黑树的特性可以得出它的一定有两个黑色的子节点
        //bst.delete(95);
        //bst.delete(15);


        System.out.println(bst.root);
    }
}
