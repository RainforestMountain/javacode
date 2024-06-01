package com.systemtest;

import com.BookList.BookList;
import com.user.AdminUser;
import com.user.NormalUser;
import com.user.User;

import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("请输入你的姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("选择你的身份,1.图书管理员,2.普通用户");
        User user;
        BookList bookList = new BookList();
        while (true) {
            int n = scanner.nextInt();
            if (n == 1) {
                user = new AdminUser(name);
                break;
            } else if (n == 2) {
                user = new NormalUser(name);
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        while (true) {
            System.out.println("选择操作:");
            System.out.println(user);
            int choice = scanner.nextInt();
            if (!user.judeInput(choice)) {
                System.out.println("输入选择操作的数字错误，重新输入");
                continue;
            }
            user.doOperation(bookList, choice);
        }

    }
}
