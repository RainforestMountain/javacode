package com.test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i <= N; i++) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            switch (strings[0]) {
                case "Pop": {
                    if (stack.isEmpty()) {
                        System.out.println("Invalid");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                }
                case "Push": {
                    int value = Integer.parseInt(strings[1]);
                    stack.push(value);
                    break;
                }
                case "PeekMedian": {
                    if (stack.isEmpty()) {
                        System.out.println("Invalid");
                    } else {
                        Integer[] array = stack.toArray(new Integer[0]);
                        Arrays.sort(array);
                        System.out.println(array[(array.length - 1) / 2]);
                    }
                    break;
                }
            }
        }

    }

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            int temp = heap.peek();
            if (temp > arr[i]) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
