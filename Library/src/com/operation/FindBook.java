package com.operation;

import com.BookList.Book;
import com.BookList.BookList;

import java.util.Scanner;

public class FindBook implements Operation {


    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        System.out.println("输入书名");
        String name = new Scanner(System.in).nextLine();
        int index = FindBook.search(bookList, name);
        if (index == -1) {
            System.out.println("不存在这本图书，查找失败");
        } else {
            System.out.println("查找成功");
            System.out.println(bookList.getBook(index));
        }
    }

    public static int search(BookList bookList, String name) {
        int index = -1;
        for (int i = 0; i < bookList.getExistNum(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                index = i;
                return index;
            }
        }
        return index;
    }
}
