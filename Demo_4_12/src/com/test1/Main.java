package com.test1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] inorder = new int[N];
        int[] postorder = new int[N];
        for (int i = 0; i < N; i++) {
            postorder[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            inorder[i] = scanner.nextInt();
        }
        TreeNode root = createTree(postorder, inorder);
        System.out.println(levelOrder(root));
        System.out.println();
    }

    public static TreeNode createTree(int[] postorder, int[] inorder) {
        index = inorder.length - 1;
        return createTreeChild(postorder, inorder, 0, postorder.length - 1);
    }

    public static int index;

    public static TreeNode createTreeChild(int[] postorder, int[] inorder, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int rootIndex = 0;
        for (rootIndex = postorder.length - 1; rootIndex >= 0; rootIndex--) {
            if (inorder[rootIndex] == postorder[index]) {
                break;
            }
        }
        index--;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.right = createTreeChild(postorder, inorder, rootIndex + 1, end);
        root.left = createTreeChild(postorder, inorder, begin, rootIndex - 1);
        return root;
    }

    public static String levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            str.append(root.value).append(" ");
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}
