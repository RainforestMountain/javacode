package com.test1;

import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.PriorityQueue;
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
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int val = scanner.nextInt();
            heap.offer(val);
        }
        scanner.nextLine();
        Integer[] array = heap.toArray(new Integer[0]);//
        for (int i = 0; i < M; i++) {
            StringBuilder str = new StringBuilder();
            str.append(scanner.nextLine());
            String[] strings = str.toString().split(" ");
            if (strings[3].equals("root")) {
                int val = Integer.parseInt(strings[0]);
                boolean jude = judeRoot(array, val);
                if (jude) {
                    System.out.println("T");
                } else {
                    System.out.println("F");
                }
            }
            if (strings[3].equals("are")) {
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[2]);
                boolean jude = judeSiblings(array, x, y);
                if (jude) {
                    System.out.println("T");
                } else {
                    System.out.println("F");
                }
            }
            if (strings[3].equals("parent")) {
                int p = Integer.parseInt(strings[0]);
                int c = Integer.parseInt(strings[strings.length - 1]);
                boolean jude = judeParent(array, p, c);
                if (jude) {
                    System.out.println("T");
                } else {
                    System.out.println("F");
                }
            }
            if (strings[3].equals("child")) {
                int c = Integer.parseInt(strings[0]);
                int p = Integer.parseInt(strings[strings.length - 1]);
                boolean jude = judeChild(array, c, p);
                if (jude) {
                    System.out.println("T");
                } else {
                    System.out.println("F");
                }
            }
        }
    }

    public static boolean judeRoot(Integer[] array, int val) {
        return array[0] == val;
    }

    public static boolean judeSiblings(Integer[] array, int x, int y) {
        int xi, yi;
        for (xi = 0; xi < array.length; xi++) {
            if (array[xi] == x) {
                break;
            }
        }
        for (yi = 0; yi < array.length; yi++) {
            if (array[yi] == y) {
                break;
            }
        }
        int k = (xi + yi - 3) % 4;
        return k == 0 && ((xi == yi + 1) || (yi == xi + 1));
    }

    public static boolean judeParent(Integer[] array, int p, int c) {
        int pi, ci;
        for (pi = 0; pi < array.length; pi++) {
            if (array[pi] == p) {
                break;
            }
        }
        for (ci = 0; ci < array.length; ci++) {
            if (array[ci] == c) {
                break;
            }
        }

        return pi <= (array.length - 2) / 2 && ((ci == 2 * pi + 1) || (ci == 2 * pi + 2));
    }

    public static boolean judeChild(Integer[] array, int c, int p) {
        int pi, ci;
        for (pi = 0; pi < array.length; pi++) {
            if (array[pi] == p) {
                break;
            }
        }
        for (ci = 0; ci < array.length; ci++) {
            if (array[ci] == c) {
                break;
            }
        }

        return pi <= (array.length - 2) / 2 && ((ci == 2 * pi + 1) || (ci == 2 * pi + 2));
    }

    public static void main(String[] args) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String actual = scanner.nextLine();

        for (int i = 0; i < actual.length(); i++) {
            char ch = Character.toUpperCase(actual.charAt(i));
            set1.add(ch);
        }
        for (int i = 0; i < src.length(); i++) {
            char ch = Character.toUpperCase(src.charAt(i));
            if (!set1.contains(ch) && !set2.contains(ch)) {
                System.out.println(ch);
                set2.add(ch);
            }
        }

    }

}
