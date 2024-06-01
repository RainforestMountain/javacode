package com.test4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node {
    int data;
    int address;
    int nextAddress;
    Node next;

    public Node(int data, int address, int nextAddress) {
        this.data = data;
        this.address = address;
        this.nextAddress = nextAddress;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initAddress = scanner.nextInt();
        int N = scanner.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int address = scanner.nextInt();
            int data = scanner.nextInt();
            int nextAddress = scanner.nextInt();
            list.add(new Node(data, address, nextAddress));
        }
        int i = list.size() - 1;
        int j = 1;
        boolean flag = true;
        while (i > j) {
            if (flag == true) {
                Node pre = list.get(i);
                Node cur = list.get(j);
                pre.next = cur;
                pre.nextAddress = cur.address;
                flag = false;
                i--;
                j++;
            } else {
                Node pre = list.get(j);
                Node cur = list.get(i);
                pre.next = cur;
                pre.nextAddress = cur.address;
                flag = true;
                i--;
                j++;
            }
        }
        

    }

    public static Node getNode(List<Node> list, int address) {
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.address == address) {
                return node;
            }
        }
        return null;
    }
}
