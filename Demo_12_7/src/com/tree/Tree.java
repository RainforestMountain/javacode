package com.tree;

import java.util.*;

public class Tree {
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static int index = 0;//index指针移动用于不断获取data的值

    public static TreeNode createTree(char[] data) {
        //'#'代表空结点
        if (data[index] == '#') {
            index++;
            return null;
        }
        TreeNode T = new TreeNode(data[index++]);
        T.left = createTree(data);
        T.right = createTree(data);
        return T;
    }

    //获取树的结点个数
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    //获取度为0的叶子结点个数
    public static int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int count = 0;
        if (root.left != null) {
            count = getLeafNodeCount(root.left);
        }
        if (root.right != null) {
            count = count + getLeafNodeCount(root.right);
        }
        return count;
    }

    //获取树的高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h1 = getHeight(root.left) + 1;
        int h2 = getHeight(root.right) + 1;
        return Math.max(h1, h2);
    }

    //查找值为val的结点
    public static TreeNode find(TreeNode root, char val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.val == val) {
                return root;
            }
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return null;
    }

    //非递归先序遍历
    public static void newPreOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val + " ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    //非递归先序遍历
    public static void newPreOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) { //栈为空并且root指向空，都访问完了结束循环
            while (root != null) {  //栈结点的左下结点进栈，边访问边进栈
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            //此时栈顶结点的左子树已经遍历完或者左子树为空
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;  //处理遍历栈顶结点的右子树
            }
        }
    }

    //非递归中序遍历
    public static void newInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) { ////栈为空并且root指向空，都访问完了结束循环
            while (root != null) { //栈结点的左下结点进栈
                stack.push(root);
                root = root.left;
            }
            //此时栈顶结点的左子树已经遍历完或者左子树为空
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right; //处理遍历栈顶结点的右子树
            }
        }
    }

    //非递归后序遍历
    public static void newPostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode r = null;
        boolean flag = true;//true表示此时p指向栈顶结点，false表示此时p指向栈顶结点的右子树中的结点
        do {
            while (p != null) { //栈结点的左下结点进栈
                stack.push(p);
                p = p.left;
            }
            //此时p的左孩子为空
            //进栈后置为ture,接下来p会指向栈顶结点
            flag = true;
            while (!stack.isEmpty() && flag) {
                p = stack.peek();
                //当栈顶结点的右子树都遍历完了，即结点的右孩子为刚才访问过的结点或者右孩子为空
                if (p.right == r || p.right == null) {
                    System.out.print(p.val + " ");
                    p = stack.pop();
                    r = p;//r指向刚才访问过的结点
                } else {
                    p = p.right;
                    flag = false;//当前p不指向栈顶结点
                }
            }
            //此时栈顶结点的左子树已经遍历完或者左子树为空，访问了空结点
        } while (!stack.isEmpty());//栈为空时都访问了
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] data = "ABC##DEG##H##F##I#J##".toCharArray();//树的结点先序序列创建树，用'#'表示空结点
        Tree.TreeNode root = createTree(data);
        System.out.println(size(root));
        System.out.println(getLeafNodeCount(root));
        System.out.println(getHeight(root));
        System.out.println("---------------------------");
        TreeNode ans = find(root, 'H');
        if (ans != null) {
            System.out.println(ans.val);
        }
        newPreOrder1(root);
        System.out.println();
        newPreOrder2(root);
        System.out.println();
        newInOrder(root);
        System.out.println();
        newPostOrder(root);
        System.out.println();
    }

}

