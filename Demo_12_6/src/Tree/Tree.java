package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

    //先序遍历
    public static void preOrder(TreeNode T) {
        if (T == null) {
            return;
        }
        System.out.print(T.val + " ");
        preOrder(T.left);
        preOrder(T.right);
    }

    //中序遍历
    public static void inOrder(TreeNode T) {
        if (T == null) {
            return;
        }
        inOrder(T.left);
        System.out.print(T.val + " ");
        inOrder(T.right);
    }

    //后序遍历
    public static void postOrder(TreeNode T) {
        if (T == null) {
            return;
        }
        postOrder(T.left);
        postOrder(T.right);
        System.out.print(T.val + " ");
    }

    //层次遍历
    public static void levelOrder(TreeNode T) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(T);
        //队列不为空循环
        while (!queue.isEmpty()) {
            //及时更新T
            T = queue.poll();
            System.out.print(T.val + " ");
            if (T.left != null) {
                queue.offer(T.left);
            }
            if (T.right != null) {
                queue.offer(T.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] data = "ABD##E#H##CF##G##".toCharArray();//树的结点先序序列创建树，用'#'表示空结点
        Tree.TreeNode root = createTree(data);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
    }
}
