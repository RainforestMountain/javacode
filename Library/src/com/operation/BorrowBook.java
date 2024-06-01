package com.operation;

import com.BookList.Book;
import com.BookList.BookList;

import java.util.Scanner;

public class BorrowBook implements Operation {

    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书：");
        System.out.println("输入需要借阅的书名");
        String name = new Scanner(System.in).nextLine();
        int index = FindBook.search(bookList, name);
        if (index == -1) {
            System.out.println("没有找到需借阅的图书");
        } else if (index != 1 && bookList.getBook(index).isBorrowed()) {
            System.out.println("图书已被借阅");
        } else {
            bookList.getBook(index).setBorrowed(true);
            System.out.println("借阅成功");
        }
    }
}
