package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static boolean insert(TreeNode root, int value) {

        if (root == null) {
            root = new TreeNode(value);
            return true;
        }
        TreeNode parent = null;
        while (root != null) {
            if (root.val > value) {
                parent = root;
                root = root.left;
            } else {
                parent = root;
                root = root.right;
            }
        }
        TreeNode node = new TreeNode(value);

        if (parent.val > value) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }

    public static boolean insertMirror(TreeNode root, int value) {

        if (root == null) {
            root = new TreeNode(value);
            return true;
        }
        TreeNode parent = null;
        while (root != null) {
            if (root.val <= value) {
                parent = root;
                root = root.left;
            } else {
                parent = root;
                root = root.right;
            }
        }
        TreeNode node = new TreeNode(value);

        if (parent.val <= value) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }

    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;
        TreeNode rootMirror = null;
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            arr[i] = value;
            if (i == 0) {
                root = new TreeNode(value);
                rootMirror = new TreeNode(value);
            } else {
                insert(root, value);
                insertMirror(rootMirror, value);
            }
        }
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        boolean jude = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != list.get(i)) {
                jude = false;
                break;
            }
        }
        list.clear();
        preorder(rootMirror, list);
        boolean judeMirror = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != list.get(i)) {
                judeMirror = false;
                break;
            }
        }

        if (jude) {
            System.out.println("YES");
            list.clear();
            postorder(root, list);
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    System.out.print(list.get(i));
                } else {
                    System.out.print(list.get(i) + " ");
                }
            }
        } else if (judeMirror) {
            System.out.println("YES");
            list.clear();
            postorder(rootMirror, list);
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    System.out.print(list.get(i));
                } else {
                    System.out.print(list.get(i) + " ");
                }
            }
        } else {
            System.out.println("NO");
        }
    }
}